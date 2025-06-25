package io.github.some_example_name.Rendering;
import com.badlogic.gdx.graphics.g2d.Sprite;
public abstract class Renderable implements Comparable<Renderable>{
    private float x;
    private float y;
    private Sprite sprite;

    @Override
    public int compareTo(Renderable object){
        if(getY() < object.getY()){
            return 1;
        }
        return -1;
    }

    public abstract void update();
    public abstract boolean exists();

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y=y;
    }

    public Sprite getSprite(){
        return sprite;
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
}