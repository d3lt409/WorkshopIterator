package TodoList.models;

import java.util.List;

import TodoList.interfaces.TaskIterator;

public class TaskListIterator implements TaskIterator {

    private int currentPosition;
    private List<Task> tasks;

    public TaskListIterator(List<Task> tasks) {
        this.tasks = tasks;
        currentPosition = 0;
    }

    @Override
    public Task getNext() {
        if (hasNext()) {
            return tasks.get(currentPosition++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < tasks.size();
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}