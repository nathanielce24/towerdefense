package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Enemies.Enemy;
import io.github.some_example_name.Rendering.Position;

class Level{
    private ArrayList<Position> bounds;
    private ArrayList<Wave> waves;
    private Wave currentWave;
    private int waveIndex = 0;
    private Controller controller;

    
    public Level(){
        bounds = new ArrayList<>();
        waves = new ArrayList<>();
    }

    public void addWave(Wave wave){
        waves.add(wave);
    }

    public void setWaves(ArrayList<Wave> waves){
        this.waves = waves;
        currentWave=waves.get(0);
        waveIndex = 0;
    }

    public Wave nextWave(){
        if(++waveIndex<waves.size()){
            currentWave = waves.get(waveIndex);
            return waves.get(waveIndex);
        }
        else return null;
    }

    public Enemy nextEnemy(){
        if(currentWave==null) return null;
        Enemy e = currentWave.nextEnemy();
        if(e!=null) return e;
        else if(!isOver()) return nextWave().getCurrentEnemy();
        else return null;
    }

    public Wave getCurrentWave(){
        return waves.get(waveIndex);
    }

    public boolean hasNextWave(){
        return waveIndex<waves.size()-1;
    }

    public boolean isLastWave(){
        return waveIndex==waves.size()-1;
    }

    public boolean isOver(){
        return waveIndex>=waves.size();
    }

    public void setController(Controller controller) {this.controller = controller;}

}