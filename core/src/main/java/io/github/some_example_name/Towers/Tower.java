package io.github.some_example_name.Towers;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import io.github.some_example_name.Enemies.Enemy;
import io.github.some_example_name.MainGame.Game;
import io.github.some_example_name.Projectiles.ProjectileType;
import io.github.some_example_name.Rendering.Position;
import io.github.some_example_name.Rendering.Renderable;

public abstract class Tower extends Renderable implements Cloneable{
    private float x, y, xShoot, yShoot, xShootOffset, yShootOffset, rotation, range; //TODO: Use Position object instead
    private Position position;
    private int health, maxHealth, cooldown, fireRate, cost;
    private ProjectileType projectile;
    private Texture texture;
    private Sprite sprite; 
    private boolean shooting;
    private Game game;
    private boolean exists;
    private Enemy enemy;


    public Tower(float x, 
                 float y, 
                 float xShootOffset, 
                 float yShootOffset, 
                 String texturePath, 
                 int maxHealth, 
                 int fireRate, 
                 float range, 
                 int cost,
                 Game game){
        this.rotation = 0;
        this.texture = new Texture(texturePath);
        this.sprite = new Sprite(texture);
        this.shooting = false;

        this.x = x;
        this.y = y;
        this.xShootOffset = xShootOffset; //projectile spawn offset from sprite coords
        this.yShootOffset = yShootOffset;
        this.xShoot = x+xShootOffset; //where projectiles are spawned relative
        this.yShoot = y+yShootOffset;
        this.position = new Position(x, y, sprite.getWidth()/2, sprite.getHeight()/2, xShoot, yShoot);

        this.cost = cost;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.fireRate = fireRate;
        this.range = range;
        this.projectile = new ProjectileType(game);
        this.exists = true;
        this.enemy = null;
        this.game = game;

    }

    
    public void shoot(Enemy enemy){};

    public void update(){
        if(health<=0){
            kill();
        }
        sprite.setX(x);
        sprite.setY(y);
        xShoot = x+xShootOffset;
        yShoot = y+yShootOffset;
        searchAndShoot();
        position.setXY(x, y);

       
    }

    public void searchAndShoot(){
        if(enemy==null || !enemy.exists()){
            searchForTarget();
            shoot(enemy);
        }
    }

    public void searchForTarget(){
        if(game.getEnemies()==null) return;
        Enemy closest = null;
        for(Renderable e: game.getEnemies()){
            if(e==null) continue;
            if(closest==null || !closest.exists() ||
              (calcDist(e.getX(), e.getY(), getX(), getY()) < 
               calcDist(closest.getX(),closest.getY(), getX(), getY()))){
                closest = (Enemy)e;
            }
        }
        enemy = closest;
    }

    public float calcDist(float x1, float y1, float x2, float y2){
        return (float)Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    public void kill(){
        exists = false;
    }

    public boolean exists() {return exists;}

    @Override
    public Tower clone() {
        try {
            return (Tower) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); 
        }
    }

    public boolean collidingWithOtherTower(){
        for(Tower t: game.getTowers()){
            if(t!=this && t.getPosition().isColliding(getPosition())){
                    System.out.println("Overlapping");
                    return true;
                }
        }
        return false;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
        position.setXY(x, y);
        sprite.setX(x);
        sprite.setY(y);
        
    }

    public float getX(){return x;}
    public float getY(){return y;}
    public Position getPosition(){return position;}
    public float getxShootOffset(){return xShootOffset;}
    public float getyShootOffset(){return yShootOffset;}
    public float getAngle(){return rotation;}
    public float getHp(){return health;}
    public ProjectileType getProjectile(){return projectile;}
    public float getxShoot(){return xShoot;}
    public float getyShoot(){return yShoot;}
    public Sprite getSprite(){return sprite;}
    public int getCost() {return cost;}
    public Enemy getEnemy() {return enemy;}
    public Game getGame() {return game;}


    private void subtractHp(int hp){this.health-=hp;}
    private void addHp(int hp){this.health+=hp;}
    public void setEnemy(Enemy enemy) {this.enemy = enemy;}
    public void setCost(int cost) {this.cost = cost;}
    private void setGame(Game game) {this.game=game;}
    public void setPosition(Position position){
        this.position = position;
        sprite.setX(position.x());
        sprite.setY(position.y());}
    public void setX(float x){
        this.x = x;
        position.setX(x);
        sprite.setX(x);
    }
    public void setY(float y){
        this.y=y;
        position.setY(y);
        sprite.setY(y);
    }


}