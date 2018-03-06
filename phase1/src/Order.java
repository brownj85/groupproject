import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Order extends Task implements Observer {

    static int numOrders = 0;

    private boolean prepared = false;
    private Server server;
    private Table table;
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private int orderID;

    public Order(Server server, Table table) {
        this.server = server;
        this.table = table;
        this.orderID = numOrders;
        numOrders++;
    }

    public void addDish(Dish d) {
        dishes.add(d);
        d.addObserver(this);
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public HashMap<String, Integer> allIngredients(){
        HashMap<String, Integer> result = new HashMap<String, Integer>();


        for (Dish dish: dishes){
            HashMap curr = dish.getIngredients();
            for (Object o: curr.keySet()){
                String key = (String) o;
                result.merge(key, (Integer) curr.get(key), (a,b) -> a + b);
            }
        }

        return result;
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

    public Table getTable() {
        return table;
    }

    public int id(){
        return this.orderID;
    }
}
