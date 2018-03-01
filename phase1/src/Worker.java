
abstract class Worker<U extends Worker, T extends Task>{

    private WorkSpace<U, T> workSpace;

    private Queue<T> taskQueue = new Queue<T>();

    public Worker(WorkSpace<U, T> workSpace){
        this.workSpace = workSpace;
    }

    public int numTasks(){
        return taskQueue.size();
    }

    private void sendTask(T task){
        workSpace.receiveTask(task);
    }

    public void giveTask(T task){
        taskQueue.add(task);
    }
    
}
