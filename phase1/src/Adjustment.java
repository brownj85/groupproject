import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

public class Adjustment {

    private String name;

    private HashMap<String, Integer> ingredients;

    private Double price;

    private int sign;

    public Adjustment(String name, Double price, ArrayList<Pair<String, Integer>> ingredientPairs, boolean positive){
        this.price = price;

        if (positive){
            this.sign = 1;
            this.name = "(+) " + name;
        }
        else{
            this.sign = -1;
            this.name = "(-) " + name;
        }

        for (Pair<String, Integer> ingredientPair: ingredientPairs){
            ingredients.put(ingredientPair.getKey(), ingredientPair.getValue());
        }
    }

    public Double getPrice(){
        if (this.sign == 1){
            return price;
        }
        else{
            return 0.0;
        }
    }

    public String name(){
        return this.name;
    }

    public int sign(){
      return this.sign;
    }

    public HashMap<String, Integer> ingredients(){
        return this.ingredients;
    }

}
