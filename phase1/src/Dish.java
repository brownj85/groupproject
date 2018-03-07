import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

public class Dish {

    private HashMap<String, Integer> ingredients = new HashMap<>();

    private HashMap<String, Adjustment> possibleAdjustments;

    private ArrayList<String> currAdjustments = new ArrayList<>();

    private double price;

    private String name;

    public Dish(String name, Double price, ArrayList<Pair<String, Integer>> ingredientPairs,
                ArrayList<Pair<String, Adjustment>> adjustmentPairs){
        this.name = name;
        this.price = price;

        for (Pair<String, Adjustment> pair: adjustmentPairs){
            possibleAdjustments.put(pair.getKey(), pair.getValue());
        }

        for (Pair<String, Integer> pair: ingredientPairs){
            ingredients.put(pair.getKey(), pair.getValue());
        }
    }

    public String name(){
        return this.name;
    }

    public Double price(){
        return this.price;
    }

    public void addAdjustment(String name){
        Adjustment adj = this.possibleAdjustments.get(name);
        this.currAdjustments.add(name);
        mergeIngredientTable(adj.ingredients(), this.ingredients, adj.sign());
        this.price = adj.getPrice() + this.price;
    }

    public void removeAdjustment(String name){
        Adjustment adj = this.possibleAdjustments.get(name);
        this.currAdjustments.remove(name);
        mergeIngredientTable(adj.ingredients(), this.ingredients, adj.sign() * -1);

        if (adj.getPrice() > 0){
            this.price = this.price + adj.getPrice();
        }

    }
    protected void mergeIngredientTable(HashMap<String, Integer> source, HashMap<String, Integer> target, int sign){
        for (String key: source.keySet()){
            target.put(key, Math.max(target.get(key) + sign * source.get(key), 0));
        }
    }





}
