package main.Model.Lavoro.Interfaces;

public interface BaseWorker {

    public int getWorkerId();

    public String getWorkerName();

    public String getWorkerSurname();

    public WorkerType getWorkType();

    public void setName(String name);

    public void setSurname(String surname);

    public void setWorkType(WorkerType workType);

}
