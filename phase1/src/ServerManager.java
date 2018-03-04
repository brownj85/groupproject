import java.util.ArrayList;
public class ServerManager<S, O> extends WorkerManager {

    public ServerManager(ArrayList<Server> servers){
        workers = servers;

    }
    // TODO: Complete this
    public void chooseWorker(Task task){
        Table table = ((Order)task).getTable();
        // Unsure about this
        for (Object server : workers){
            if (((Server)server).getTables().contains(task)){
                Order order = (Order)task;
                ((Server) server).setCurrOrder(order);
            }

    }


    }
}
