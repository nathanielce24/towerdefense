package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import io.github.some_example_name.Controllers.Controller;

class GameStateManager{
    private static final int STARTING_MONEY = 10000;
    private static final int STARTING_HEALTH = 100;

    private int money;
    private int health;
    private Level currentLevel;
    private ArrayList<Level> levels;
    Controller controller;
    int currentLevelIndex;

    private enum State {
        PLAYING,
        MAINMENU,
        GAMEOVER,
        PAUSED,
    }
    private State state;
  

    public GameStateManager(){
        this.money = STARTING_MONEY;
        this.health = STARTING_HEALTH;
        levels = new ArrayList<>();
        this.currentLevel = null;
        currentLevelIndex = 0;
    }


    public void runLevel(int index, Game game){

    }

    public void runNextLevel(Game game){
        if(levels.get(currentLevelIndex+1)!=null){
            runLevel(++currentLevelIndex, game);
        }
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