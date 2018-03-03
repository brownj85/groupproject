<<<<<<< HEAD
import java.util.Observable;

public class Ingredient extends Observable {
    private String name;
    private int quantity;
    private int reorderThreshold;

    public Ingredient(String name, int quantity, int reorderThreshold) {
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addToQuantity(int addition) {
        quantity += addition;
    }

    public boolean reduceQuantity(int deduction) {
        if (quantity - deduction < 0) {
            return false;
        } else {
            quantity -= deduction;
            if (quantity < reorderThreshold) {
                setChanged();
                notifyObservers();
            }
            return true;
        }
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof String) {
            return o.equals(name);
        } else {
            return o instanceof Ingredient && name.equals(((Ingredient) o).getName());
        }
    }
=======
public class Ingredient {
>>>>>>> 8c318d711a4149b79611b32202bffa271b17a423
}
