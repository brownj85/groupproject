import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> queue = new ArrayList<T>();

    public T pop(){
        return queue.remove(0);
    }

    public T getPop(){
        return queue.get(0);
    }

    public void add(T e){
        this.queue.add(e);
    }

    public int size(){
        return this.queue.size();
    }

    public void remove(T e){
        queue.remove(e);
    }

}
