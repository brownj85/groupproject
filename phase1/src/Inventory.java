import java.util.*;

public class Inventory {

    private final int DEFAULT_THRESHOLD;

    private final int DEFAULT_STARTAMOUNT;

    private Restaurant restaurant;

    private HashMap<String, Integer>  inventory;

    private HashMap<String, Integer>  reorderThresholds;

    public Inventory(int defaultReorderThreshold, int defaultStartAmount, Restaurant restaurant){
        this.DEFAULT_THRESHOLD = defaultReorderThreshold;
        this.DEFAULT_STARTAMOUNT = defaultStartAmount;
        this.restaurant = restaurant;
    }

    public void addNewInventoryItem(String name, int startAmount, int reorderThreshold){
        inventory.put(name, startAmount);
        reorderThresholds.put(name, reorderThreshold);
    }

    public boolean removeInventoryItems(HashMap<String, Integer> ingredients){
        return false;
    }


}
