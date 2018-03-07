import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

public class Dish {

    private HashMap<String, Integer> ingredients = new HashMap<>();

    private ArrayList<Adjustment> possibleAdjustments;

    private ArrayList<String> currAdjustments = new ArrayList<>();

    private double price;

    private String name;

    public Dish(String name, Double price, ArrayList<Pair<String, Integer>> ingredientPairs,
                ArrayList<Adjustment> possAdjustments){
        this.name = name;
        this.price = price;
        this.possibleAdjustments = possAdjustments;

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




}
