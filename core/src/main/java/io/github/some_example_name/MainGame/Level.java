package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Rendering.Position;

class Level{
    private ArrayList<Position> bounds;
    private ArrayList<Wave> waves;
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
    }

    public Wave getNextWave(){
        if(waveIndex<waves.size()){
            return waves.get(waveIndex++);
        }
        else return null;
    }

    public boolean hasNextWave(){
        return waveIndex<waves.size()-1;
    }

    public boolean isLastWave(){
        return waveIndex==waves.size()-1;
    }

    public void setController(Controller controller) {this.controller = controller;}

}