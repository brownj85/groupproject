import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Observable;
import java.util.Observer;

public class Order extends Task implements Observer {

    private boolean prepared = false;
    private Server server;
    private Table table;
    private ArrayList<Dish> dishes = new ArrayList<Dish>();

    public Order(Server server, Table table) {
        this.server = server;
        this.table = table;
    }

    public void addDish(Dish d) {
        dishes.add(d);
        d.addObserver(this);
    }

    public double getPrice() {
        double price = 0.0;
        for (Dish dish : dishes) {
            price += dish.getPrice();
        }
        return price;
    }

    @Override
    public void update(Observable observable, Object o) {
        boolean allComplete = true;
        for (Dish dish : dishes) {
            if (!dish.isCompleted()) {
                allComplete = false;
                break;
            }
        }
        if (allComplete) {
            prepared = true;
            setChanged();
            notifyObservers();
        }
    }
}
=======

public class Order extends Task {

    private ArrayList<Dish> dishes;

    public Dish[] getDishes(){
        return null;
    }
}
>>>>>>> 8c318d711a4149b79611b32202bffa271b17a423
