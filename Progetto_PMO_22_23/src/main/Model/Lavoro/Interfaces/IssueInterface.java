package main.Model.Lavoro.Interfaces;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IssueInterface {
    
    public int getIssueId();

    public String getDescription();

    public Optional<LocalDateTime> getIssueDate();

    public double getPrice();

    public WorkerType getIssueType();

    public void setIssueType(WorkerType type);

    public void setDescription(String description);

    public void setPrice(double price);

    public void setTime();

    public boolean getState();

    public void setState();

    public String getFinalTime();
}
