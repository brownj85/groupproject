import java.util.Observable;

abstract class Task extends Observable {

    private boolean completed = false;

    public void complete(){
        this.completed = true;
        setChanged();
        notifyObservers();
    }

    public boolean isCompleted(){
        return completed;
    }

}
