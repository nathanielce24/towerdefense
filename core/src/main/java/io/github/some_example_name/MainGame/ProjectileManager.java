package io.github.some_example_name.MainGame;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Projectiles.Projectile;
import io.github.some_example_name.Rendering.RenderList;

class ProjectileManager{
    private ArrayList<Projectile> drawnProjectiles;
    private RenderList<Projectile> spriteProjectiles;
    private Controller controller;

    public ProjectileManager(){
        this.drawnProjectiles = new ArrayList<>(); 
        this.spriteProjectiles = new RenderList<>();
    }

    public void update(ShapeRenderer sr){
        updateDrawnProjectiles(sr);
        updateSpriteProjectiles();
        spriteProjectiles.removeNulls();
    }

    public void updateDrawnProjectiles(ShapeRenderer sr){
        for(Projectile p: drawnProjectiles){
            if(p!=null) p.update(sr);
        }
    }

    public void updateSpriteProjectiles(){
        for(Projectile p: spriteProjectiles){
            if(p!=null && p.getSprite() != null)p.update();
        }
    }

    public void addProjectile(Projectile projectile){
        if(projectile.getSprite()==null){
            addDrawnProjectile(projectile);
        }
        else{
            addSpriteProjectile(projectile);
        }
    }

    public void addDrawnProjectile(Projectile projectile){ drawnProjectiles.add(projectile);}
    public void addSpriteProjectile(Projectile projectile) {spriteProjectiles.add(projectile);}

    public ArrayList<Projectile> getDrawnProjectiles(){return drawnProjectiles;}
    public RenderList<Projectile> getSpriteProjectiles() {return spriteProjectiles;}

    public void setController(Controller controller) {this.controller = controller;}
}