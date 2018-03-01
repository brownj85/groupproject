abstract class Task {

    private boolean completed = false;

    public void complete(){
        this.completed = true;
    }

    public boolean isCompleted(){
        return completed;
    }

}
