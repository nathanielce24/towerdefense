package io.github.some_example_name.Controllers;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;

import io.github.some_example_name.MainGame.Game;
import io.github.some_example_name.Towers.LaserTurret;
import io.github.some_example_name.Towers.LightningTower;
import io.github.some_example_name.Towers.Tower;


public class Controller{
    Game game;

    float xMouse;
    float yMouse;
    boolean clicked;
   
    private final Map<Integer, Action> bindings;

    private enum Action {
        NONE,
        PLACING1,
        PLACING2,
        PLACING3,
        PLACING4,
        SELECTING,
        DELETING,
        UI
    }
    Action action;

    public Controller(Game game){
        this.game = game;
        bindings = new HashMap<>();
        action = Action.SELECTING;
        setBindings();
    }

    private void setBindings() {
        bindings.put(Keys.NUM_1, Action.PLACING1);
        bindings.put(Keys.NUM_2, Action.PLACING2);
        bindings.put(Keys.NUM_3, Action.PLACING3);
        bindings.put(Keys.NUM_4, Action.PLACING4);

        bindings.put(Keys.DEL, Action.DELETING);
    }

    public void update(){
        listen();
        interpretInput();
    }


    public void listen(){
        xMouse = Gdx.input.getX();
        yMouse = Gdx.graphics.getHeight() - Gdx.input.getY();
        clicked = Gdx.input.isButtonJustPressed(Input.Buttons.LEFT);
       
        for (Map.Entry<Integer, Action> entry : bindings.entrySet()) {
            if (Gdx.input.isKeyPressed(entry.getKey())) {
                action = entry.getValue();
                break;  
            }
        }
    }

    public void interpretInput(){
        switch (action){
            case SELECTING:
                break;
            case PLACING1:
                placeing(new LightningTower(xMouse, yMouse, game));
                break;
            case PLACING2:
                placeing(new LaserTurret(xMouse, yMouse, game));
                break;
            case NONE:
                game.getTowerGhosts().clear();
        }

    } 

    private void placeing(Tower tower){
        if(game.getTowerGhosts().isEmpty() ||
           !game.getTowerGhosts().get(0).getClass().equals(tower.getClass())){  //TODO?: Move this logic to RenderList
            game.getTowerGhosts().clear();
            Tower t2 = tower.clone();
            game.getTowerGhosts().add(t2);
        }
        if(clicked && game.tryPlacingTower(tower)){
            action = Action.NONE;
        }
    }

    private void placeTower(Tower tower){
        game.getTowers().add(tower);
    }

    public void setAction(Action action){
        this.action = action;
    }

    public float getXMouse(){
        return xMouse;
    }

    public float getYMouse(){
        return yMouse;
    }
    
}