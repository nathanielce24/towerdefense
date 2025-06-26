
package io.github.some_example_name.Controllers;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Draw{

     public static void thickLine(ShapeRenderer shapeRenderer, int thickness, float x1, float y1, float x2, float y2){
        for(int i = 0; i<thickness; i++){
            float offset = 0.05f*i*(float)Math.pow(-1, i);
            shapeRenderer.line(x1+offset, y1, x2+offset, y2);
        }
    }

    public static void jaggedLine(ShapeRenderer shapeRenderer, float x1, float y1, float x2, float y2, Color color, float jaggedness){  //TODO: Use random deviation of angle instead of slope                            
        shapeRenderer.setColor(color);
        float slope;
        if(Math.abs(x1-x2)<1){
            slope = 0.1f;
        }
        slope = ((y2-y1) / (x2-x1));
        float currx = x1;
        float curry = y1;
        float rand, dist, newx, newy;
        int count = 0;
        boolean fromRight = x2 > x1;
        float direction = 1f;
        if(!fromRight) direction = -1;
        while ((fromRight && currx < x2) || (!fromRight && currx > x2)) {
            rand = (((float)Math.random()-0.5f)*jaggedness);
            dist = (float)Math.random()*20;
            newx = currx + direction*(dist / (float)Math.sqrt(1 + Math.pow(slope + rand, 2)));
            newy = (float)(curry+direction*(slope+rand)*(dist/Math.sqrt(1+Math.pow(slope+rand, 2))));
            shapeRenderer.line(currx, curry, newx, newy);
            currx = newx;
            curry=newy;
            newx = currx + direction*(dist / (float)Math.sqrt(1 + Math.pow(slope - rand, 2)));
            newy = (float)(curry+direction*(slope-rand)*(dist/Math.sqrt(1+Math.pow(slope-rand, 2))));
            shapeRenderer.line(currx, curry, newx, newy);
            currx = newx;
            curry = newy;
            if(Math.sqrt(Math.pow(currx-x2, 2) + Math.pow(curry-y2, 2)) < 30){
                shapeRenderer.line(currx, curry, x2+((float)Math.random()-0.5f)*8, y2+((float)Math.random()-0.5f)*8);
                break;
            }
            if(count>=30){
                shapeRenderer.line(currx, curry, x2+((float)Math.random()-0.5f)*8, y2+((float)Math.random()-0.5f)*8);
                break;
            }
        }

    }

}