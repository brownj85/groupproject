
abstract class Worker<U extends Worker, T extends Task>{

    private static int numWorkers;

    private WorkSpace<U, T> workSpace;

    private int id;

    private Queue<T> taskQueue = new Queue<T>();

    public Worker(WorkSpace<U, T> workSpace){
        this.id = numWorkers;
        numWorkers++;
        this.workSpace = workSpace;
    }

    public int id(){
        return id;
    }

    public void sendTask(T task){
        workSpace.receiveTask(task);
    }

    public void giveTask(T task){
        taskQueue.add(task);
    }

    public abstract void processTask(T task);



}
