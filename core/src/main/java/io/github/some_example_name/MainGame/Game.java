package io.github.some_example_name.MainGame;
import io.github.some_example_name.Controllers.*;
import io.github.some_example_name.Enemies.*;
import io.github.some_example_name.Projectiles.*;
import io.github.some_example_name.Rendering.*;
import io.github.some_example_name.Towers.*;
import io.github.some_example_name.UI.*;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Game{
    RenderList<Tower> towers;
    RenderList<Enemy> enemies;
    RenderList<Tower> towerGhosts;
    ArrayList<Projectile> projectiles;
    ArrayList<Sprite> sprites;
    Controller controller; 
    int money;
    
    public Game(){
        towers = new RenderList<>();
        enemies = new RenderList<>();
        towerGhosts = new RenderList<>();
        projectiles = new ArrayList<>();
        sprites = new ArrayList<>();

        money = 10000;
    }

    public void updateTowers(){
       for(Tower t: towers){
            t.update();
       }
    }

    public void updateEnemys(){
        for(Enemy e: enemies){
            if(e==null) continue;
            e.update();
            if(!e.exists()){
                enemies.set(enemies.indexOf(e), null);
            }
        }
    }

    public void updateProjectiles(ShapeRenderer sr){
        for(Projectile p: projectiles){
            p.update(sr);
        }
    }

    public void updateTowerGhosts(){  //TODO: Give GhostTowers their own class
       for(Tower t: towerGhosts){
            t.setX(controller.getXMouse());
            t.setY(controller.getYMouse());
            if(t.collidingWithOtherTower()) t.getSprite().setColor(0.9f,0.3f,0.3f, 1);
            else t.getSprite().setColor(1f,1f,1f,1f);
            t.getSprite().setAlpha(0.7f);
       }
    }

    public boolean tryPlacingTower(Tower tower){
        for(Tower t: towers){
            if(t.getPosition().isColliding(tower.getPosition())){
                System.out.println("Overlapping");
                return false;
            }
        }
        if(money>=tower.getCost()){
            towers.add(tower);
            money-=tower.getCost();
        }
        else{
            System.out.println("not enough money");
            return true;
        }
        return true;
    }

    public Controller getController(){ return controller;}
    public void setController(Controller controller){ this.controller = controller;}


    public ArrayList<Projectile> getProjectiles(){
        return projectiles;
    }

    public RenderList<Tower> getTowers(){
        return towers;
    }

    public RenderList<Tower> getTowerGhosts(){
        return towerGhosts;
    }

    public RenderList<Enemy> getEnemies(){
        return enemies; 
    }

    public void addTower(Tower tower){
        towers.add(tower);
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public void addProjectile(Projectile projectile){
        projectiles.add(projectile);
    }

    public void addSprite(Sprite sprite){
        sprites.add(sprite);
    }

    public ArrayList<Sprite> getSprites(){
        return sprites;
    }

}