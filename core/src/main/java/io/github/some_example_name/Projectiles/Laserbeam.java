package io.github.some_example_name.Projectiles;
import io.github.some_example_name.Controllers.*;
import io.github.some_example_name.Enemies.*;
import io.github.some_example_name.MainGame.*;
import io.github.some_example_name.Rendering.*;
import io.github.some_example_name.Towers.*;
import io.github.some_example_name.UI.*;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Laserbeam extends LightningBolt{
    private static final int DAMAGE = 2;

    public static final Color BRIGHT_RED = new Color(1f, 0.2f, 0.2f, 1f);
    

    private float x;
    private float y;
    private float xStart = getxStart();
    private float yStart = getyStart();
    private float xTarget = getxTarget();
    private float yTarget = getyTarget();
    private boolean exists = exists();
    private Enemy enemy = getEnemy();
    private Tower tower = getTower();

    public Laserbeam(Tower tower, Enemy enemy){
        super(tower, enemy);
        setDamage(DAMAGE);
    }

    @Override
    public void update(ShapeRenderer shapeRenderer){
            if(this.enemy==null || !enemy.exists()) return;
            superUpdate(shapeRenderer);
            xTarget = getxTarget();
            yTarget = getyTarget();
            xStart = getxStart();
            yStart = getyStart();
            exists = exists();
            enemy = getEnemy();
            tower = getTower();
           
            shapeRenderer.setColor(BRIGHT_RED);
            setHitShader(new float[]{0.7f, 0.4f, 0.4f, 1f});
            
            Draw.thickLine(shapeRenderer, 8, xStart, yStart, xTarget, yTarget);
    }

   
}