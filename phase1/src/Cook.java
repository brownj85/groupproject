import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Cook extends Worker<Cook> {

    private Inventory inventory;

    public Cook(Kitchen kitchen, Inventory inventory){
        super(kitchen);
        this.inventory = inventory;
    }

    public void completeOrder(int id){
        Order order = getOrder(id);

        order.
    }






}
