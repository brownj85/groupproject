import java.math.*;
import java.util.Observable;
import java.util.Observer;

public class CookManager extends WorkerManager<Cook>{

    @Override
    public void chooseWorker(Order order) {

        Cook currCook = super.workers.get(0);

        for (Cook cook: super.workers){
            if (cook.numOrders() < currCook.numOrders()){
                currCook = cook;
            }
        }

        currCook.giveOrder(order);
    }



}
