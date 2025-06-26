package io.github.some_example_name.Projectiles;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import io.github.some_example_name.Controllers.Draw;
import io.github.some_example_name.Enemies.Enemy;
import io.github.some_example_name.Towers.Tower;

public class LightningBolt extends Projectile{
    private static final int maxTime = 30;
    public static final Color ELECTRIC_BLUE = new Color(0.49f, 0.98f, 1f, 1f);
    private static final int DAMAGE = 1;

    private float x;
    private float y;
    private float xStart = getxStart();
    private float yStart = getyStart();
    private float xTarget = getxTarget();
    private float yTarget = getyTarget();
    private boolean exists = exists();
    private Enemy enemy = getEnemy();
    private Tower tower = getTower();
    

    public LightningBolt(Tower tower, Enemy enemy){
        super(tower, enemy);
        setDamage(DAMAGE);
    }

    @Override
    public void update(ShapeRenderer shapeRenderer){
            if(this.enemy==null || !enemy.exists()) return;
            super.update(shapeRenderer);
            xTarget = getxTarget();
            yTarget = getyTarget();
            xStart = getxStart();
            yStart = getyStart();
            setHitShader(new float[]{0.4f, 0.4f, 0.7f, 1f});
           
            shapeRenderer.setColor(ELECTRIC_BLUE);
            drawBolt(shapeRenderer);
    }

    public void update(){
        return;
    }

    public void superUpdate(ShapeRenderer shapeRenderer){
         super.update(shapeRenderer);
    }


    
    public void drawBolt(ShapeRenderer shapeRenderer){
        Draw.jaggedLine(shapeRenderer, xStart, yStart, xTarget, yTarget, ELECTRIC_BLUE, 1); 
    }


    public void setxTarget(float xTarget){
        this.xTarget = xTarget;
    }

    public void setyTarget(float yTarget){
        this.yTarget = yTarget;
    }
}