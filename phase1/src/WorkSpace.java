abstract class WorkSpace<U extends Worker, T extends Task> {

    private Restaurant restaurant;

    private WorkerManager<U, T> workerManager;

    private Queue<T> taskQueue = new Queue<>();

    public WorkSpace(Restaurant restaurant, WorkerManager<U, T> workerManager){
        this.restaurant = restaurant;
        this.workerManager = workerManager;
    }

    public void receiveTask(T task){
        taskQueue.add(task);
    }

    public void sendTask(T task){
        restaurant.receiveTask(task);
    }

    public T getTask(){
        return taskQueue.pop();
    }

    public void assignTask(){
        T task = taskQueue.pop();
        workerManager.chooseWorker(task);
    }

    public abstract void processTask(T task);

}
