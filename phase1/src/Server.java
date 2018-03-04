import java.util.ArrayList;
public class Server extends Worker {

    private Order currOrder;
    private ArrayList<Table> tables;
    private Dish currDish;

    public Server(FrontHouse frontHouse, ArrayList<Table> tables){
        super(frontHouse);
        this.tables = tables;
    }

    public void addTable(Table table){
        this.tables.add(table);
    }

    public void createOrder(Table table){
        Order newOrder = new Order(this, table);
        this.currOrder = newOrder;
    }

    public void updateOrder(Dish dish){
        currOrder.addDish(dish);
        currDish = dish;
    }

    public void AdjustDish(Dish dish, Adjustment a, boolean add){
        if (currOrder.getDishes().contains(dish)){
            int index = currOrder.getDishes().indexOf(dish);
            if (add) {
                currOrder.getDishes().get(index).addAdjustment(a);
            }
            else {
                currOrder.getDishes().get(index).removeAdjustment(a);
            }

        }
    }
    public void sendCurrentOrder(){
        sendTask(currOrder);
        currOrder = null;

    }

    // Still need to add other methods




}
