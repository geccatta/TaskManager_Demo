enum Status{
    ASSIGNED, IN_PROGRESS, NOT_ASSIGNED;
}
enum Priority{
    HIGH, MEDIUM, LOW;
}

public class Task implements Comparable<Task>{
    private String assignee;
    private String projectName;
    private String description;
    private Priority priority;
    private Status status;

    public Task(String projectName, String description, String assignee, Priority priority, Status status) {
        this.projectName = projectName;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    public Task(String projectName, String description, String assignee, Priority priority) {
        this(assignee, projectName, description, priority, assignee == null ? Status.NOT_ASSIGNED : Status.ASSIGNED);
    }

    public Task(String projectName, String description, Priority priority){
        this(projectName, description, null, priority);
    }

    public String getAssignee() {
        return assignee;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority(){
        return priority;
    }

    public Status getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(projectName, description, priority,
                                                        assignee, status);
    }

    @Override
    public int compareTo(Task o) {
        int projectComp = this.projectName.compareTo(o.projectName);
        if(projectComp == 0){
            projectComp = this.description.compareTo(o.description);
        }
        return projectComp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return getProjectName().equals(task.getProjectName()) && getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProjectName().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
