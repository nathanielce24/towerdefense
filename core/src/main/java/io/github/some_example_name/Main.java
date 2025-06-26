package io.github.some_example_name;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.Controllers.Controller;
import io.github.some_example_name.Enemies.Enemy;
import io.github.some_example_name.Enemies.Journalist;
import io.github.some_example_name.MainGame.Game;
import io.github.some_example_name.Towers.LightningTower;
import io.github.some_example_name.Towers.Tower;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    Game game;
    ShapeRenderer sr;
    Texture background;
    Controller c;

    @Override
    public void create() {
        background = new Texture("core\\src\\main\\java\\io\\github\\textures\\landscape.png");
        batch = new SpriteBatch();
        sr = new ShapeRenderer();
        
        //image = new Texture("libgdx.png");
        game = new Game(sr);
        c = new Controller(game); 
        game.setController(c);           
        LightningTower t = new LightningTower(80, 100, game);
        t.setPower(4);
        game.addTower(t);
        game.addEnemy(new Journalist(300,30, game));
        game.addEnemy(new Journalist(500,170, game));
        game.addEnemy(new Journalist(300,200, game));
        game.addEnemy(new Journalist(500,100, game));
        game.getEnemies().get(0).setTarget(game.getTowers().get(0));
        game.getEnemies().get(1).setTarget(game.getTowers().get(0));
        
       // game.getTowers().get(0).setEnemy(game.getEnemies().get(0));



    }

    @Override
    public void render() {

        c.update();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();
        renderSprites(batch);
        batch.end();

        sr.begin(ShapeRenderer.ShapeType.Line); //TODO: allow for sprites to be drawn over shapes. Right now, shapes must be drawn on top.
        game.update();
        sr.end();
        
       

       
    }

    public void renderSprites(SpriteBatch batch){
         batch.draw(background, 0, 0);
        for(Sprite s: game.getSprites()){  //TODO: add null checks
            s.draw(batch);
        }
        for(Tower t: game.getTowers()){
            t.getSprite().draw(batch);
            t.getPosition().update();
        }
        for(Enemy e: game.getEnemies()){
            if(e!=null){
                e.getSprite().draw(batch);
            }   
        }

         for(Tower t: game.getTowerGhosts()){
            if(t!=null){
                t.getSprite().draw(batch);
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        //image.dispose();
    }
}
