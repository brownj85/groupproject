import java.util.ArrayList;
import java.util.HashSet;

public class Cook extends Worker<Cook, Dish> {

    private Inventory inventory;

    private HashSet<Order> orders = new HashSet<>(); 

    public Cook(Kitchen kitchen, Inventory inventory){
        super(kitchen);
        this.inventory = inventory;
    }

    public boolean completeDish(Dish dish){
        if (inventory.removeInventoryItems(dish.getIngredients())){
            dish.complete();
            super.sendTask(dish);
            return true;
        }
        else{
            return false;
        }
    }




}
