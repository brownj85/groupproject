import java.util.*;

abstract class WorkSpace<U extends Worker> {

    private Restaurant restaurant;

    private WorkerManager<U> workerManager;

    private Queue<Order> orderQueue = new Queue<>();

    public WorkSpace(Restaurant restaurant, WorkerManager<U> workerManager){
        this.restaurant = restaurant;
        this.workerManager = workerManager;
    }

    public void receiveOrder(Order order){
        orderQueue.add(order);
    }

    private void sendOrder(Order order){
        restaurant.receiveTask(order);
    }

    public Order getOrder(){
        return orderQueue.pop();
    }

    public void assignOrder(Order order){
        workerManager.chooseWorker(order);
    }

}
