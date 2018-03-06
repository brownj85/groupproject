import java.util.HashMap;

abstract class Worker<U extends Worker>{

    private WorkSpace<U> workSpace;

    private Queue<Integer> orderIdQueue = new Queue<>();

    private HashMap<Integer, Order> orders = new HashMap<>();

    private Inventory inventory;

    public Worker(WorkSpace<U> workSpace) {
        this.workSpace = workSpace;
    }

    public int numOrders() {
        return orderIdQueue.size();
    }

    public void sendOrder(Order order){
        workSpace.receiveOrder(order);
    }

    public void giveOrder(Order order){
        orderIdQueue.add(order.id());
        orders.put(order.id(), order);

    }

    public Order getOrder(){
        return orders.get(orderIdQueue.getPop());
    }

    public Order getOrder(int id){
        return orders.get(id);
    }

    public void completeOrder(int id){
        orderIdQueue.remove(id);
        Order order = orders.remove(id);
        workSpace.receiveOrder(order);
    }

}
