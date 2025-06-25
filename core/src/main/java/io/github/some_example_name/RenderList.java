package io.github.some_example_name;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.Sprite;

class RenderList<T extends Renderable> implements Iterable<T> {
    private final ArrayList<T> objects;

    public RenderList() {
        objects = new ArrayList<>();
    }

    public RenderList(ArrayList<T> objectList) {
        this.objects = new ArrayList<>(objectList);
        Collections.sort(this.objects);
    }

    public boolean add(T object) {
        int index = Collections.binarySearch(objects, object);
        if (index < 0) {
            index = -index - 1;
        }
        objects.add(index, object);
        return true;
    }

    public T get(int index) {
        return objects.get(index);
    }

    public Sprite getSprite(int index) {
        return objects.get(index).getSprite();
    }

    public int indexOf(T object) {
        return objects.indexOf(object);
    }

    public boolean isEmpty(){
        return objects.isEmpty();
    }

    public void set(int index, T object) {
        objects.set(index, object);
    }

    public void clear() {
        objects.clear();
    }

    public boolean remove(T object) {
        return objects.remove(object);
    }

    public ArrayList<T> getCopy() {
        return new ArrayList<>(objects);
    }

    @Override
    public Iterator<T> iterator() {
        return objects.iterator();
    }
}