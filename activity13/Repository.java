package activity13;

import java.util.ArrayList;

public class Repository<T> {

    private ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public ArrayList<T> getAll() {
        return items;
    }
}
