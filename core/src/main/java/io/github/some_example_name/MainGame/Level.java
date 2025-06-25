package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import io.github.some_example_name.Rendering.Position;

class Level{
    private ArrayList<Position> bounds;
    private ArrayList<Wave> waves;

    
    public Level(){
        bounds = new ArrayList<>();
        waves = new ArrayList<>();
    }

    public void addWave(Wave wave){
        waves.add(wave);
    }





}