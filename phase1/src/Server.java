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

    public void createnewOrder(Table table){
         this.currOrder = new Order(this, table);
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

    public void getNewCompletedOrder(){
        if (numTasks() != 0){
            currOrder = (Order) getTask();
        }
    }

    // Deliever an order assuming there's no complaints, and prepared is true
    private void delieverOrder(){
        if (!currOrder.equals(null)) {
            Table table = currOrder.getTable();
            double newbill = table.getBill() + currOrder.getPrice();
            table.setBill(newbill);
            currOrder = null;
        }

    }


    // NOTE: THIS IS NOT DONE, NEED TO ASK GROUP MEMBERS EXACTLY WHAT'S SUPPOSED TO HAPPEN HERE
    private void adjustOrder(Dictionary<Dish, Adjustment> adjustments){
        // Note, probably need to be able to say if Dish if complete or not?
        if (!currOrder.equals(null)){
            currOrder = null;
        }


    }

    public void setCurrOrder(Order order){
        currOrder = order;
    }

    public ArrayList<Table> getTables(){
        return this.tables;
    }






    // Still need to add other methods




}
