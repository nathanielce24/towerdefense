package io.github.some_example_name.Enemies;

import com.badlogic.gdx.Gdx;

import io.github.some_example_name.MainGame.Game;
import io.github.some_example_name.Towers.Tower;

public class Journalist extends Enemy {

    public Journalist(float x, float y, Game game) {
        super(x, y, 5, 7, 10f, 5000, 100, "core\\src\\main\\java\\io\\github\\textures\\basicperson.png", game);
    }

    @Override
    public void moveTowardsTarget() {
        float deltaTime = Gdx.graphics.getDeltaTime(); 
        float deltaX = getTarget().getX() - getX();
        float deltaY = getTarget().getY() - getY();

        float moveAmount = getSpeed() * deltaTime;

        setX(getX() - moveAmount);
        if (Math.abs(deltaY) < 2f) {
            return;
        }

        if (getTarget().getY() > getY()) {
            setY(getY() + moveAmount);
        } else if (getTarget().getY() < getY()) {
            setY(getY() - moveAmount);
        }
    }

    @Override
    public void attack(Tower tower) {
        
    }
}
