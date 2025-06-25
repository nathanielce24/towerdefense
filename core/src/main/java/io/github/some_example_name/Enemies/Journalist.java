package io.github.some_example_name.Enemies;
import io.github.some_example_name.MainGame.Game;
import io.github.some_example_name.Towers.Tower;


public class Journalist extends Enemy{
    public Journalist(float x, float y, Game game){
        super(x, y, 5, 7, 0.05f, 5000, 100, "core\\src\\main\\java\\io\\github\\textures\\basicperson.png", game);
    }

    @Override
    public void moveTowardsTarget(){
        float deltaX = getTarget().getX() - getX();
        float deltaY = getTarget().getY() - getY();

        setX(getX()-getSpeed());
        if(Math.abs(deltaY)<2){
            return;
        }
        if(getTarget().getY() > getY()){
            setY(getY()+getSpeed());
        }
        else if (getTarget().getY()<getY()){
            setY(getY()-getSpeed());
        }
    }

    @Override
    public void attack(Tower tower){
        
    }
}