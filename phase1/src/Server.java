import java.util.ArrayList;
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

    public void sendCurrentOrder(){
        sendTask(currOrder);
        currOrder = null;

    }

    // Still need to add other methods




}
