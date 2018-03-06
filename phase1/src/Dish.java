import java.util.ArrayList;
import java.util.HashMap;

public class Dish extends Task {
    private String name;
    private double basePrice;
    private HashMap<String, Integer> baseIngredients;
    private ArrayList<Adjustment> possAdjustments;
    private ArrayList<Adjustment> adjustments = new ArrayList<>();

    public Dish(String name, double basePrice, HashMap<String, Integer> baseIngredients,
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

    public HashMap<String, Integer> getBaseIngredients() {
        return baseIngredients;
    }

    public HashMap<String, Integer> getIngredients() {
        HashMap<String, Integer> allIngredients = new HashMap<>(baseIngredients);
        for (Adjustment adjustment : adjustments) {
            if (adjustment.isAddition()) {
                allIngredients = helpAddIngredients(allIngredients, adjustment.getIngredients());
            } else {
                allIngredients = helpSubtractIngredients(allIngredients, adjustment.getIngredients());
            }
        }
        return allIngredients;
    }

    private HashMap<String, Integer> helpAddIngredients(HashMap<String, Integer> dishIngredients,
                                                        HashMap<String, Integer> adjIngredients) {
        for (String ingredient : adjIngredients.keySet()) {
            int adjCount = adjIngredients.get(ingredient);
            if (dishIngredients.containsKey(ingredient)) {
                int dishCount = dishIngredients.get(ingredient);
                dishIngredients.replace(ingredient, dishCount + adjCount);
            } else {
                dishIngredients.put(ingredient, adjCount);
            }
        }
        return dishIngredients;
    }

    /**
     * Precondition: Any adjIngredients contains only keys found in dishIngredients.
     */
    private HashMap<String, Integer> helpSubtractIngredients(HashMap<String, Integer> dishIngredients,
                                                        HashMap<String, Integer> adjIngredients) {
        for (String ingredient : adjIngredients.keySet()) {
            int adjCount = adjIngredients.get(ingredient);
            int dishCount = dishIngredients.get(ingredient);
            dishIngredients.replace(ingredient, dishCount - adjCount);
        }
        return dishIngredients;
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
    }
}
