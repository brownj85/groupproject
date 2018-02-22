
abstract class Worker {

    private static int numWorkers;

    private static WorkerManager manager;

    private int id;

    private EventQueue eventQueue = new EventQueue();

    public Worker(){
        this.id = numWorkers;
        numWorkers++;
        manager.addWorker(this);
    }

    public void receiveEvent(Event e){
        this.eventQueue.add(e);
    }

    public void processEvent(){}

    public void sendEvent(Event e){
        manager.receiveEvent(e);
    }

    public int getQueueSize(){
        return eventQueue.getSize();
    }





}
