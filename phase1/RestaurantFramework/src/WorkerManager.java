import java.util.ArrayList;

abstract class WorkerManager<T extends Worker, U extends Task>{

    protected ArrayList<T> workers;

    public void addWorker(T worker){
        workers.add(worker);
    }

    public abstract void chooseWorker(U task);

}
