package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import io.github.some_example_name.Enemies.Enemy;
class Wave{
    private ArrayList<Enemy> enemies;
    private float nextWaveDelay;
    private float spawnDelay;
    private int enemyIndex = 0;

    public Wave(ArrayList<Enemy> enemies, float spawnDelay, float nextWaveDelay){
        this.enemies = enemies;
        this.spawnDelay = spawnDelay;
        this.nextWaveDelay = nextWaveDelay;
    }

    public Enemy nextEnemy(){
        if(enemies.get(++enemyIndex)!=null){
            return enemies.get(enemyIndex);
        }
        return null;
    }

    public boolean isOver(){
        return(enemyIndex>=enemies.size());
    }

    public Enemy getCurrentEnemy() {return enemies.get(enemyIndex);}
    public ArrayList<Enemy> getEnemies() {return enemies;}
    public float getNextWaveDelay() {return nextWaveDelay;}
    public void setNextWaveDelay(float delay) {this.nextWaveDelay = delay;}
    public void setSpawnDelay(float delay){ spawnDelay = delay;}
    public float getSpawnDelay(){ return spawnDelay;}
    public void setEnemies(ArrayList<Enemy> enemies) {this.enemies = enemies;}
    public void addEnemy(Enemy enemy) {this.enemies.add(enemy);}


}