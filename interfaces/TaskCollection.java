package TodoList.interfaces;

import TodoList.models.Task;

public interface TaskCollection {
    TaskIterator<Task> allTask();
    TaskIterator<Task> completedTasks();
    TaskIterator<Task> inCompletedTasks();
}
