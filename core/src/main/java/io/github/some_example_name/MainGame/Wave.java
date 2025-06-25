package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import io.github.some_example_name.Enemies.Enemy;
class Wave{
    private ArrayList<Enemy> enemies;
    private float delay;

    public Wave(ArrayList<Enemy> enemies, float delay){
        this.enemies = enemies;
        this.delay = delay;
    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public float getDelay(){
        return delay;
    }

    public void setDelay(float delay){
        this.delay = delay;
    }

    public void setEnemies(ArrayList<Enemy> enemies){
        this.enemies = enemies;
    }

    public void addEnemy(Enemy enemy){
        this.enemies.add(enemy);
    }


}