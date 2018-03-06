import java.math.*;
import java.util.Observable;
import java.util.Observer;

public class CookManager extends WorkerManager<Cook, Dish>{

    @Override
    public void chooseWorker(Dish dish) {

        Cook currCook = super.workers.get(0);

        for (Cook cook: super.workers){
            if (cook.numTasks() < currCook.numTasks()){
                currCook = cook;
            }
        }

        currCook.giveTask(dish);

    }



}
