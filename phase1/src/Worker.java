
abstract class Worker<U extends Worker, T extends Task>{

    private WorkSpace<U, T> workSpace;

    private Queue<T> taskQueue = new Queue<T>();

    private Inventory inventory;

    public Worker(WorkSpace<U, T> workSpace){
        this.workSpace = workSpace;
    }

    public int numTasks(){
        return taskQueue.size();
    }

    public void sendTask(T task){
        workSpace.receiveTask(task);
    }

    public void giveTask(T task){
        taskQueue.add(task);
    }

    public T getTask() {return taskQueue.pop();}
}
