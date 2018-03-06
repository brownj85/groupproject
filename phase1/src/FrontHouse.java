import java.util.ArrayList;
public class FrontHouse extends WorkSpace {

    private ArrayList<Table> tables;

    public FrontHouse(Restaurant restaurant, ServerManager serverManager, ArrayList<Table> tables){
        super(restaurant, serverManager);
        this.tables = tables;
    }
}
