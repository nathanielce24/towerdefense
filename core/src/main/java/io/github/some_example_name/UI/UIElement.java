package io.github.some_example_name.UI;
import io.github.some_example_name.Rendering.Position;
import io.github.some_example_name.Rendering.Renderable;
abstract class UIElement extends Renderable{
    private Position position;

    
    public void update(){

    }

    public boolean clicked(){
        return true;
    }

    public boolean exists(){
        return true;
    }

    public boolean overlapping(float x, float y){
        return true;
    }

    public boolean overlapping(Position p){
        return overlapping(p.x(), p.y());
    }

}