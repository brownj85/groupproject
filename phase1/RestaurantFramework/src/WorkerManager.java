abstract class WorkerManager<T extends Worker, U extends Task>{

    public abstract void addWorker(T worker);

    public abstract void chooseWorker(U task);

}
