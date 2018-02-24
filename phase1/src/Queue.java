import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> queue = new ArrayList<T>();

    public T pop(){
        return queue.remove(0);
    }

    public void add(T e){
        this.queue.add(e);
    }

    public int size(){
        return this.queue.size();
    }

}
