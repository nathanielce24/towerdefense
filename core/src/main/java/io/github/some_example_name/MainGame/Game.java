package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Enemies.Enemy;
import io.github.some_example_name.Projectiles.Projectile;
import io.github.some_example_name.Rendering.RenderList;
import io.github.some_example_name.Towers.Tower;

public class Game{
    RenderList<Tower> towers;
    RenderList<Enemy> enemies;
    RenderList<Tower> towerGhosts;
    ArrayList<Projectile> projectiles;
    ArrayList<Sprite> sprites;

    ArrayList<Level> Levels;

    Controller controller; 
    int money;

    private EnemyManager enemyManager;
    private GameStateManager gameManager;
    private TowerManager towerManager;
    private ProjectileManager projectileManager;
    
    public Game(){
        towers = new RenderList<>();
        enemies = new RenderList<>();
        towerGhosts = new RenderList<>();
        projectiles = new ArrayList<>();
        sprites = new ArrayList<>();

        enemyManager = new EnemyManager();
        gameManager = new GameStateManager();
        towerManager = new TowerManager();
        projectileManager = new ProjectileManager();

        money = 10000;
    }

    public void updateTowers(){
       towerManager.update();
    }

    public boolean tryPlacingTower(Tower tower){
        return towerManager.TryPlacingTower(tower, gameManager);
    }

    public void updateEnemys(){
        enemyManager.update();
    }

    public void updateProjectiles(ShapeRenderer sr){
        projectileManager.update(sr);
    }


    public Controller getController(){ return controller;}
    public void setController(Controller controller){ 
        this.controller = controller;
        enemyManager.setController(controller);
        towerManager.setController(controller);
        gameManager.setController(controller);
        projectileManager.setController(controller);
        }

    public ArrayList<Projectile> getProjectiles(){  //TODO: seperate drawn and sprite projectiles
        return projectileManager.getDrawnProjectiles();
    }

    public RenderList<Tower> getTowers(){
        return towerManager.getTowers();
    }

    public RenderList<Tower> getTowerGhosts(){
        return towerManager.getTowerGhosts();
    }

    public RenderList<Enemy> getEnemies(){
        return enemyManager.getEnemies(); 
    }

    public void addTower(Tower tower){
        towerManager.addTower(tower);
    }

    public void addEnemy(Enemy enemy){
        enemyManager.addEnemy(enemy);
    }

    public void addProjectile(Projectile projectile){
            projectileManager.addProjectile(projectile);
    }

    public void addSprite(Sprite sprite){
        sprites.add(sprite);
    }

    public ArrayList<Sprite> getSprites(){
        return sprites;
    }

}