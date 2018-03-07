import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

public class Adjustment {

    private String name;

    private HashMap<String, Integer> ingredients = new HashMap<>();

    private Double price;

    private int sign;

    public Adjustment(String name, Double price, ArrayList<Pair<String, Integer>> ingredientPairs){
        this.name = name;
        this.price = price;
        this.sign = 1;

        for (Pair<String, Integer> pair: ingredientPairs){
            ingredients.put(pair.getKey(), pair.getValue());
        }
    }

    public void setAddition(){
        this.sign = 1;
    }

    public void setSubtraction(){
        this.sign = -1;
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

    public Double price(){
        return this.price;
    }



}
