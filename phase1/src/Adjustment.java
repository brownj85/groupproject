import java.util.ArrayList;

public class Adjustment {
    private String name;
    private double price;
    private boolean addition; // true if this Adjustment is an addition. false if it is a subtraction
    private ArrayList ingredients;

    public Adjustment(String name, double price, ArrayList<Ingredient> ingredients,
                      boolean addition) {
        this.name = name;
        this.price = price;
        this.addition = addition;
        this.ingredients = ingredients;
    }

    public boolean isAddition() {
        return addition;
    }

    public ArrayList getIngredients() {
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
        if (o instanceof Adjustment) {
            return name.equals(((Adjustment) o).getName())
                    && price == ((Adjustment) o).getPrice()
                    && ingredients.equals(((Adjustment) o).getIngredients());
        } else {
            return false;
        }
    }
}
