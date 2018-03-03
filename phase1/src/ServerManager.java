import java.util.ArrayList;
public class ServerManager extends WorkerManager {

    // Change this to ArrayList
    public ServerManager(Server[] servers){
        for (Server server: servers){
            this.addWorker(server);
        }
    }
    // TODO: Complete this
    public void chooseWorker(Task task){

    }
}
