public class Restaurant {

    private Queue<Task> taskQueue = new Queue<Task>();

    public void receiveTask(Task task){
        taskQueue.add(task);
    }
}
