import java.util.*;

public class Kitchen extends WorkSpace<Cook, Dish> {

    private OrderManager orderManager;

    public Kitchen(Restaurant restaurant, CookManager cookManager){
        super(restaurant, cookManager);
        this.orderManager = new OrderManager(restaurant);
    }

    public void receiveTask(Order order){
        orderManager.addOrder(order);
        processOrder(order);
    }

    public void processOrder(Order order) {
        for (Dish dish : order.getDishes()) {
            if (!dish.isCompleted()) {
                receiveTask(dish);
            }
        }
    }

}


