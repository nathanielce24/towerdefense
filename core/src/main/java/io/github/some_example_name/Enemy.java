package io.github.some_example_name;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

abstract class Enemy extends Renderable{
    private static final String bloodTexturePath = "core\\src\\main\\java\\io\\github\\textures\\blood1.png";

    private float x, y, speed, toShootx, toShooty, toShootxOffset, toShootyOffset; //toShoot is the point where towers should aim their projectiles
    private int health, damage;
    private Tower target; 
    private Sprite sprite;
    private Sprite spriteAttack;
    private Texture texture;
    private Texture bloodTexture;
    private boolean alive;
    private Game game;
    Position position;

    public Enemy(float x,
                 float y, 
                 float toShootxOffset, 
                 float toShootyOffset, 
                 float speed, 
                 int health, 
                 int damage, 
                 String texturePath, Game game){
        this.x = x;
        this.y = y;
        this.toShootxOffset = toShootxOffset;
        this.toShootyOffset = toShootyOffset;
        this.toShootx = x+toShootxOffset;
        this.toShooty = y+toShootyOffset;
        this.position = new Position(x, y);

        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.texture = new Texture(texturePath);
        this.sprite = new Sprite(texture);
        this.target = null;
        this.game = game; 
        this.bloodTexture = new Texture(bloodTexturePath);
        alive = true;
    }

    public void attack(){
        attack(target);
    }
    public abstract void attack(Tower tower);
    public abstract void moveTowardsTarget();

    public void update(){ 
        sprite.setX(x);
        sprite.setY(y);
        setToShoot(x + toShootxOffset, y + toShootyOffset);
        boolean hit = false;
        for (Projectile p : game.getProjectiles()) {
            if (Math.abs(p.getX() - toShootx) < 5 && Math.abs(p.getY() - toShooty) < 5) {
                health -= p.getDamage();
                
                if (Math.random() > 0.5) {
                    sprite.setColor(p.getHitShader()[0], p.getHitShader()[1], p.getHitShader()[2], p.getHitShader()[3]);
                    hit = true;
                }
            }
        }
    
        if (!hit) {
            sprite.setColor(1, 1, 1, 1); 
        }
        if (health <= 0) {
            kill();
        }
        if (target != null) {
            moveTowardsTarget();
        }
    }

    public void kill(){
        Sprite bloodSprite = new Sprite(bloodTexture);
        bloodSprite.setPosition(x-2, y-4);
        game.addSprite(bloodSprite);
        alive = false;
    }

    public boolean exists(){
        return alive;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;

    }

    public float getX(){ return x; }
    public float getY(){ return y; }
    public float getSpeed(){ return speed; }
    public int getHp(){ return this.health; }
    public Sprite getSprite(){ return this.sprite; }
    public Tower getTarget(){ return this.target; }
    public int getDamage(){ return this.damage; }
    public float getToShootx(){ return toShootx; }
    public float getToShooty(){ return toShooty; }

    public void setX(float x){
        this.x = x; 
        position.setX(x);
        sprite.setX(x);
    }
    public void setY(float y){
        this.y = y;
        position.setY(y);
        sprite.setY(y);
    }
    public void subtractHp(int hp){ this.health -= hp; }
    public void addHp(int hp){ this.health += hp; }
    public void setTarget(Tower tower){ this.target = tower; }
    public void setDamage(int dmg){ this.damage = dmg; }
    public void setBloodTexture(String path){ bloodTexture = new Texture(path); }

    public void setToShoot(float x, float y){
        toShootx = x;
        toShooty = y;
    }


}