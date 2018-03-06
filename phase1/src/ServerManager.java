import java.util.ArrayList;
public class ServerManager<S, O> extends WorkerManager {

    public ServerManager(ArrayList<Server> servers){
        workers = servers;

    }

    public void chooseWorker(Task task){
        Table table = ((Order)task).getTable();
        // Unsure about this
        for (Object server : workers){
            if (((Server)server).getTables().contains(task)){
                Order order = (Order)task;
                ((Server) server).giveTask(order);
            }

    }


    }
    // Don't know if I need this
    public void assignTable(Server server, Table table){
        if (workers.contains(server)){
            server.addTable(table);
        }
    }
}
