package io.github.some_example_name.Towers;
import io.github.some_example_name.Enemies.Enemy;
import io.github.some_example_name.MainGame.Game;
import io.github.some_example_name.Projectiles.Laserbeam;
import io.github.some_example_name.Projectiles.ProjectileType;

public class LaserTurret extends Tower{
    private static final String texturePath = "core\\src\\main\\java\\io\\github\\textures\\laserturret.png";

    ProjectileType projectile = getProjectile();
    float xShoot = getxShoot();
    float yShoot = getyShoot();
    private int power;
    private Game game = getGame();
    private boolean exists = exists();
    private Enemy enemy = getEnemy();

    public LaserTurret(float x, float y, Game game){
        super(x, y, 12, 28, texturePath, 100, 30, 150, 100, game);
        getPosition().setXBoundOffset(20);
        getPosition().setYBoundOffset(8);
    }


    @Override
    public void shoot(Enemy enemy){
        game.getProjectiles().add(new Laserbeam(this, enemy));
    }

    @Override 
    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
        this.shoot(enemy); //unlike towers that use actual projectiles, the laser turret locks onto enemies;
    }

}