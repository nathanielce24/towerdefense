package io.github.some_example_name;

class LightningTower extends Tower{
    
    ProjectileType projectile = getProjectile();
    float xShoot = getxShoot();
    float yShoot = getyShoot();
    private int power;
    private Game game = getGame();
    private boolean exists = exists();
    private Enemy enemy = getEnemy();

    public LightningTower(float x, float y, Game game){
        super(x, y, 18, 37, "core\\src\\main\\java\\io\\github\\textures\\lighttower.png", 100, 30, 150, 100, game);
        getPosition().setXBoundOffset(8);
        getPosition().setYBoundOffset(11);
        power = 1;
    }

    //core\\src\\main\\java\\io\\github\\textures\\lighttower.png

    @Override
    public void shoot(Enemy enemy){
        game.getProjectiles().add(new LightningBolt(this, enemy));
    }

    @Override
    public void update(){
      super.update();
      xShoot = getxShoot();
      yShoot = getyShoot();
      game = getGame();
      exists = exists();
      enemy = getEnemy();
    }

    @Override
    public void searchAndShoot(){
        if(getEnemy()==null || !getEnemy().exists()){
            searchForTarget();
            for(int i = 0; i<power; i++){
                shoot(getEnemy()); 
            } 
        }
    }
    
    @Override 
    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
        shoot(enemy);
    }

    public void setPower(int power){
        this.power = power;
    }

    public int getPower(){
        return power;
    }


}