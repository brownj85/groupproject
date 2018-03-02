import java.util.ArrayList;

public class Dish extends Task {
    private String name;
    private double basePrice;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Adjustment> possAdjustments;
    private ArrayList<Adjustment> adjustments = new ArrayList<>();

    public Dish(String name, double basePrice, ArrayList<Ingredient> ingredients,
                ArrayList<Adjustment> possAdjustments) {
        this.name = name;
        this.basePrice = basePrice;
        this.ingredients = ingredients;
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

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
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
        if (o instanceof Dish) {
            return name.equals(((Dish) o).getName())
                    && basePrice == ((Dish) o).getBasePrice()
                    && ingredients.equals(((Dish) o).getIngredients())
                    && adjustments.equals(((Dish) o).getAdjustments());
        } else {
            return false;
        }
    }
}
