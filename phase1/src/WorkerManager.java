import java.util.ArrayList;
import java.util.HashMap;

abstract class WorkerManager<T extends Worker>{

    private HashMap<Integer, Order> orders = new HashMap<>();

    protected ArrayList<T> workers;

    public void addWorker(T worker){
        workers.add(worker);
    }

    public abstract void chooseWorker(Order order);

}
