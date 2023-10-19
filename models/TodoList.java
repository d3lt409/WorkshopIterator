package TodoList.models;

import java.util.ArrayList;
import java.util.List;

import TodoList.interfaces.TaskCollection;
import TodoList.interfaces.TaskIterator;

public class TodoList implements TaskCollection {

    private List<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(String title, String description){
        this.tasks.add(new Task(title, description));
    }

    public boolean removeTask(String title){
        for (Task task : tasks) {
            if (task.getTitle().equals(title)){
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }

    public void completeTask(String title){
        for (Task task : tasks) {
            if (task.getTitle().equals(title)){
                task.completed();
                break;
            }
        }
    }

    @Override
    public TaskIterator allTask() {
        return new TaskListIterator(tasks);
    }

    @Override
    public TaskIterator completedTasks() {
        List<Task> completed = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.isCompleted()){
                completed.add(task);
            }
        }
        return new TaskListIterator(completed);
    }

    @Override
    public TaskIterator inCompletedTasks() {
        List<Task> inCompleted = new ArrayList<Task>();
        for (Task task : tasks) {
            if (!task.isCompleted()){
                inCompleted.add(task);
            }
        }
        return new TaskListIterator(inCompleted);
    }
    
}
