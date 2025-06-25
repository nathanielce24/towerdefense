package io.github.some_example_name.Projectiles;
import io.github.some_example_name.Controllers.*;
import io.github.some_example_name.Enemies.*;
import io.github.some_example_name.MainGame.*;
import io.github.some_example_name.Rendering.*;
import io.github.some_example_name.Towers.*;
import io.github.some_example_name.UI.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Projectile{
    private float x, y, xStart, yStart, xTarget, yTarget; //TODO: replace with Position object
    private boolean alive;
    private int damage;
    private Enemy enemy;
    private Tower tower;
    private float[] hitShader;

    public Projectile(float xStart, 
                      float yStart, 
                      float xTarget, 
                      float yTarget){
        this.xStart = xStart;
        this.yStart = yStart;
        this.xTarget = xTarget;
        this.yTarget = yTarget;
        this.x = xStart;
        this.y = yStart;
        alive = true;
        hitShader = new float[]{1f, 0.5f, 0.5f, 1f};
    }

    public Projectile(Tower tower, Enemy enemy){
        this(0,0,0,0);
        this.tower = tower;
        this.enemy = enemy;
    }


    public void update(ShapeRenderer shapeRenderer){
         if(this.enemy!=null && !enemy.exists()) return;
         if(this.enemy!=null){
                xTarget=enemy.getToShootx();
                yTarget=enemy.getToShooty();
                x=xTarget;
                y=yTarget;
            }
         if(this.tower!=null){
                xStart=tower.getxShoot();
                yStart=tower.getyShoot();
            }
    }

    public void kill(){
        alive = false;
    }

    public boolean exists(){
        return alive;
    }

    public float[] getHitShader(){ return hitShader; }
    public Enemy getEnemy(){ return enemy; }
    public Tower getTower(){ return tower; }
    public float getxStart(){ return xStart; }
    public float getyStart(){ return yStart; }
    public float getxTarget(){ return xTarget; }
    public float getyTarget(){ return yTarget; }
    public float getX(){ return x; }
    public float getY(){ return y; }
    public int getDamage(){ return damage; }

    public void setHitShader(float[] shader){ hitShader = shader; }
    public void setDamage(int damage){ this.damage = damage; }
    public void setx(float x){ this.x = x; }
    public void sety(float y){ this.y = y; }



}