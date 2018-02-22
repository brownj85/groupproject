import java.util.ArrayList;

abstract class WorkerManager {

    private ArrayList<Worker> workers = new ArrayList<Worker>();

    private EventQueue eventQueue = new EventQueue();

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public void receiveEvent(Event e){
        eventQueue.add(e);
    }

    public void sendEvent(Event e, Worker w){
        w.receiveEvent(e);
    }


}
