package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Enemies.Enemy;

class GameStateManager{
    private static final int STARTING_MONEY = 10000;
    private static final int STARTING_HEALTH = 100;

    private int money;
    private int health;
    private Level currentLevel;
    private ArrayList<Level> levels;
    Controller controller;
    int currentLevelIndex;
    private ShapeRenderer sr;

    private enum State {
        PLAYING,
        MAINMENU,
        GAMEOVER,
        PAUSED,
    }
    private State state;
  

    public GameStateManager(ShapeRenderer sr){
        this.money = STARTING_MONEY;
        this.health = STARTING_HEALTH;
        levels = new ArrayList<>();
        this.currentLevel = null;
        currentLevelIndex = 0;
        state = State.PLAYING;
        this.sr = sr;
    }

    public void update(Game game){
        switch (state){
            case PLAYING:
                game.updateEnemys();
                game.updateTowers();
                game.updateProjectiles(sr);
                break;
        }

    }


    public boolean spawnNextEnemy(Game game){  //false if all enemies from all levels have been spawned
        Enemy e = currentLevel.nextEnemy();
        if(e!=null){
            game.addEnemy(e);
            return true;
        }
        else if(!isLastLevel()){
            currentLevel = levels.get(++currentLevelIndex);
            if (currentLevel.getCurrentWave().getCurrentEnemy()==null) return false;
            else{game.addEnemy(currentLevel.getCurrentWave().getCurrentEnemy());}
        }
        return false;
    }

    public boolean isLastLevel(){
        return currentLevelIndex>=levels.size()-1;
    }

    public Level getNextLevel(Game game){
         if(levels.get(currentLevelIndex+1)!=null){
            return(levels.get(currentLevelIndex+1));
        }
        return null;
    }

    public void gameOver(){

    }

    public void initializeLevels(ArrayList<Level> levels){
        this.levels=levels;
    }

    public int getMoney(){ return money;}
    public void setMoney(int money) {this.money = money;}
    public void addMoney(int money) {this.money+=money;}
    public void subtractMoney(int money) {this.money-=money;}

    public int getHealth(){ return health;}
    public void setHealth(int health) {this.health = health;}
    public void addHealth(int health) {this.health+=health;}
    public void subtractHealth(int health) {this.health-=health;}

    public Level getLevel(){ return currentLevel;}
    public void addLevel(Level level) {levels.add(level);}

    public void setController(Controller controller) {this.controller = controller;}

}