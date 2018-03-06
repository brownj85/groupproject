import java.util.HashSet;
import java.util.*;

class OrderManager implements Observer{

    private HashMap<Integer, Order> orders = new HashMap<>();

    private Restaurant restaurant;

    public OrderManager(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    protected void addOrder(Order order){
        orders.put(order.id(), order);
        order.addObserver(this);
    }

    public Order getOrderByID(int id){
        return orders.get(id);
    }

    public void update(Observable observable, Object o){
        Order order = (Order) observable;
        orders.remove(order.id());
        restaurant.receiveTask(order);
    }

    public int numOrders(){
        return this.orders.size();
    }

}
