import java.util.HashSet;
import java.util.*;

class OrderManager implements Observer{

    private HashSet<Order> orders = new HashSet<>();

    private Restaurant restaurant;

    public OrderManager(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    protected void addOrder(Order order){
        orders.add(order);
        order.addObserver(this);
    }

    public void update(Observable observable, Object o){
        Order order = (Order) observable;
        orders.remove(order);
        restaurant.receiveTask(order);
    }

    public int numOrders(){
        return this.orders.size();
    }

}
