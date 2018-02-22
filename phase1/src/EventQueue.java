import java.util.ArrayList;

public class EventQueue {

    private ArrayList<Event> queue = new ArrayList<Event>();

    public Event pop(){
        return queue.remove(0);
    }

    public void add(Event e){
        this.queue.add(e);
    }

    public int getSize(){
        return this.queue.size();
    }

}
