abstract class Task {

    private boolean completed;

    public void complete(){
        this.completed = true;
    }

    public boolean isCompleted(){
        return completed;
    }
}
