package io.github.some_example_name;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
class Position{
    private float x, y;
    private float xCenter, yCenter;
    private float xCenterOffset, yCenterOffset;
    private float xSpawnObject, ySpawnObject; 
    private float xSpawnOffset, ySpawnOffset;
    private float xBound, yBound;
    private float xBoundOffset, yBoundOffset;

    ShapeRenderer shapeRenderer;
    
    public Position(float x, float y){
        this.x=x;
        this.y=y;
        xCenter = yCenter = xSpawnObject = ySpawnObject = xSpawnOffset = ySpawnOffset = xBound = yBound = xBoundOffset = yBoundOffset = xCenterOffset = yCenterOffset = -1;
        shapeRenderer = new ShapeRenderer();
    }

    public Position(float x, float y, float xCenterOffset, float yCenterOffset){
        this(x,y);
        this.xCenter = x+xCenterOffset;
        this.yCenter = y+yCenterOffset;
    }

    public Position (float x, float y, float xCenterOffset, float yCenterOffset, float xSpawnOffset, float ySpawnOffset){
        this(x,y,xCenterOffset,yCenterOffset);
        this.xSpawnOffset = xSpawnOffset;
        this.ySpawnOffset = ySpawnOffset;
        this.xSpawnObject = x+xSpawnOffset;
        this.ySpawnObject = y+xSpawnOffset;
    }

    public Position (float x, float y, float xCenterOffset, float yCenterOffset, float xSpawnOffset, float ySpawnOffset, float xBoundOffset, float yBoundOffset){
        this(x,y,xCenterOffset,yCenterOffset, xSpawnOffset, ySpawnOffset);
        this.xBoundOffset = xBoundOffset;
        this.yBoundOffset = yBoundOffset;
        this.xBound = x+xBoundOffset;
        this.yBound = y+yBoundOffset;

        
    }

    public void update(){
        this.xBound = x+xBoundOffset;
        this.yBound = y+yBoundOffset;
        this.xSpawnObject = x+xSpawnOffset;
        this.ySpawnObject = y+xSpawnOffset;

        /*  shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

         shapeRenderer.line(x,y, xBound, y);
         shapeRenderer.line(x,y, x, yBound);

         shapeRenderer.end();*/
    }

    public boolean isColliding(Position position){ 
        return (x < position.xBound() && xBound > position.x()) &&
               (y < position.yBound() && yBound > position.y());
    }

    public boolean isCollidingPoint(Position position){ //checks if the origin of the object is colliding with position
        return (x<=position.xBound() && x>=position.x()) && (y<=position.yBound() && y>=position.y());
    }

    public boolean isCollidingPoint(float x, float y){
        return (this.x<=xBound && this.x>=x) && (this.y<=yBound && this.y>=y);
    }


    public float x(){ return x;}
    public float y() {return y;}
    public float xBound() {return xBound;}
    public float yBound(){return yBound;}
    public float xCenter(){return xCenter;}
    public float yCenter() {return yCenter;}
    public float xCenterOffset() {return xCenterOffset;}
    public float yCenterOffset() {return yCenterOffset;}
    public float xSpawnObject(){ return xSpawnObject;}
    public float ySpawnObject(){ return ySpawnObject;}
    public float xSpawnOffset() {return xSpawnOffset;}
    public float ySpawnOffset() {return ySpawnOffset;}
    public float xBoundOffset() {return xBoundOffset;}
    public float yBoundOffset() {return yBoundOffset;}

    public void setX(float x){ this.x = x; update();}
    public void setY(float y){ this.y = y; update();}
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
        update();
    }
    public void setXCenter(float x){this.xCenter = x;  update();}
    public void setYCenter(float y){this.yCenter = y;}
    public void setXSpawnObject(float x){ this.xSpawnObject = x; update();}
    public void setYSpawnObject( float y) {this.ySpawnObject = y;  update();}
    public void setXBoundOffset(float x) {this.xBoundOffset = x; update();}
    public void setYBoundOffset(float y) {this.yBoundOffset = y; update();}

}