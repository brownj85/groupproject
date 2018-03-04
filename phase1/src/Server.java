import java.util.ArrayList;
import java.util.Dictionary;

public class Server extends Worker {

    private Order currOrder;
    private ArrayList<Table> tables;


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

    // Deliever an order assuming there's no complaints, and prepared is true
    private void delieverOrder(Order order){
        Table table = order.getTable();
        double newbill = table.getBill() + order.getPrice();
        table.setBill(newbill);
        currOrder = null;

    }


    // NOTE: THIS IS NOT DONE, NEED TO ASK GROUP MEMBERS EXACTLY WHAT'S SUPPOSED TO HAPPEN HERE
    private void adjustOrder(Order order, Dictionary<Dish, Adjustment> adjustments){
        // Note, probably need to be able to say if Dish if complete or not?
        currOrder = null;


    }

    public void setCurrOrder(Order order){
        currOrder = order;
    }

    public ArrayList<Table> getTables(){
        return this.tables;
    }






    // Still need to add other methods




}
