package main.Model.Lavoro;

import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;

public abstract class Worker implements BaseWorker{

    private int id;
    private String name;
    private String surname;
    private WorkerType workerType;

    public Worker(int id, WorkerType workerType, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workerType = workerType;
    }

    public int getWorkerId() {
        return id;
    }

    public String getWorkerName() {
        return name;
    }

    public String getWorkerSurname() {
        return surname;
    }

    public WorkerType getWorkType() {
        return workerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWorkType(WorkerType workType) {
        this.workerType = workType;
    }
    
}
