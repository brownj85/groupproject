import java.util.Observable;

abstract class Task extends Observable {

    private boolean completed = false;

    public void complete(){
        this.completed = true;
    }

    public boolean isCompleted(){
        return completed;
    }

}
