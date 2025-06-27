package io.github.some_example_name.MainGame;
import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Enemies.Enemy;
import io.github.some_example_name.Rendering.RenderList;

class EnemyManager{
    private RenderList<Enemy> enemies;
    private Controller controller;

    public EnemyManager(){
        enemies = new RenderList<>();
    }

    public void update(){
         for(Enemy e: enemies){
            if(e==null) continue;
            e.update();
            if(!e.exists()){
                enemies.set(enemies.indexOf(e), null);
            }
        }
        enemies.removeNulls(); //TOFO: fucks performance when a lot of enemies are on screen. remove enemies immediatley when they die.
    }

    public void addEnemy(Enemy enemy){ enemies.add(enemy);}
    
    public void setController(Controller controller) {this.controller = controller;}

    public RenderList<Enemy> getEnemies() {return enemies;}
   

}