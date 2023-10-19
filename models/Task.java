package TodoList.models;

public class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.completed = false;
    }


    public String getTitle() {
        return this.title;
    }


    public String getDescription() {
        return this.description;
    }


    public boolean isCompleted() {
        return this.completed;
    }

    public void completed(){
        this.completed = true;
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", completed='" + isCompleted() + "'" +
            "}";
    }
    
}
