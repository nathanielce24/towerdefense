package io.github.some_example_name.MainGame;
import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Rendering.RenderList;
import io.github.some_example_name.Towers.Tower;

class TowerManager{
    RenderList<Tower> towers;
    RenderList<Tower> towerGhosts;
    Controller controller;

    public TowerManager(){
        this.towers = new RenderList<>();
        this.towerGhosts = new RenderList<>();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void update(){
        updateTowers();
        updateTowerGhosts();
    }

    public void updateTowers(){
       for(Tower t: towers){
            t.update();
       }
       towers.removeNulls(); //FIX: horribly fucking inefficient
    }

    public void updateTowerGhosts(){  
       for(Tower t: towerGhosts){
            t.setX(controller.getXMouse());
            t.setY(controller.getYMouse());
            if(t.collidingWithOtherTower()) t.getSprite().setColor(0.9f,0.3f,0.3f, 1);
            else t.getSprite().setColor(1f,1f,1f,1f);
            t.getSprite().setAlpha(0.7f);
       }
       towerGhosts.removeNulls();
    }

    public boolean TryPlacingTower(Tower tower, GameStateManager gameStateManager){
        for(Tower t: towers){
            if(t.getPosition().isColliding(tower.getPosition())){
                System.out.println("Overlapping");
                return false;
            }
        }
        if(gameStateManager.getMoney()>=tower.getCost()){
            towers.add(tower);
            gameStateManager.subtractMoney(tower.getCost());
        }
        else{
            System.out.println("not enough money");
            return true;
        }
        return true;
    }

    public void addTower(Tower tower){ towers.add(tower);}

    public RenderList<Tower> getTowers() {return towers;}
    public RenderList<Tower> getTowerGhosts() {return towerGhosts;}
}