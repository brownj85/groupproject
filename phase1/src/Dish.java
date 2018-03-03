<<<<<<< HEAD
import java.util.ArrayList;

public class Dish extends Task {
    private String name;
    private double basePrice;
    private ArrayList<Ingredient> baseIngredients;
    private ArrayList<Adjustment> possAdjustments;
    private ArrayList<Adjustment> adjustments = new ArrayList<>();

    public Dish(String name, double basePrice, ArrayList<Ingredient> baseIngredients,
                ArrayList<Adjustment> possAdjustments) {
        this.name = name;
        this.basePrice = basePrice;
        this.baseIngredients = baseIngredients;
        this.possAdjustments = possAdjustments;
    }

    public boolean addAdjustment(Adjustment a) {
        if (possAdjustments.contains(a)) {
            adjustments.add(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAdjustment(Adjustment a) {
        return adjustments.remove(a);
    }

    public ArrayList<Adjustment> getAdjustments() {
        return adjustments;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public ArrayList<Ingredient> getBaseIngredients() {
        return baseIngredients;
    }

    public ArrayList<Ingredient> getIngredients() {
        ArrayList<Ingredient> allIngredients = new ArrayList<>(baseIngredients);
        for (Adjustment adjustment : adjustments) {
            if (adjustment.isAddition()) {
                allIngredients.addAll(adjustment.getIngredients());
            } else {
                allIngredients.removeAll(adjustment.getIngredients());
            }
        }
        return allIngredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        double adjPrice = 0.0;
        for (Adjustment a : adjustments) {
            adjPrice += a.getPrice();
        }
        return basePrice + adjPrice;
    }

    @Override
    public void complete() {
        super.complete();
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Dish
                && name.equals(((Dish) o).getName())
                && basePrice == ((Dish) o).getBasePrice() 
                && baseIngredients.equals(((Dish) o).getBaseIngredients())
                && adjustments.equals(((Dish) o).getAdjustments());
=======
public class Dish extends Task {

    private Ingredient[] ingredients;

    public Ingredient[] getIngredients(){
        return null;
>>>>>>> 8c318d711a4149b79611b32202bffa271b17a423
    }
}
