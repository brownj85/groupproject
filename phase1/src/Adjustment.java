import java.util.HashMap;

public class Adjustment {
    private String name;
    private double price;
    private boolean addition; // true if this Adjustment is an addition. false if it is a subtraction
    private HashMap<String, Integer> ingredients;

    public Adjustment(String name, double price, HashMap<String, Integer> ingredients,
                      boolean addition) {
        this.name = name;
        this.price = price;
        this.addition = addition;
        this.ingredients = ingredients;
    }

    public boolean isAddition() {
        return addition;
    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Adjustment
                && name.equals(((Adjustment) o).getName())
                && price == ((Adjustment) o).getPrice()
                && ingredients.equals(((Adjustment) o).getIngredients());
    }
}
