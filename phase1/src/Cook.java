import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Cook extends Worker<Cook, Dish> {

    private Inventory inventory;

    private HashMap<Integer, Order> orders = new HashMap<>();

    public Cook(Kitchen kitchen, Inventory inventory){
        super(kitchen);
        this.inventory = inventory;
    }

    public boolean completeDish(Dish dish){
        if (inventory.removeInventoryItems(dish.getIngredients())){
            dish.complete();
            return true;
        }
        else{
            return false;
        }
    }




}
