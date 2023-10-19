package TodoList.interfaces;


public interface TaskCollection {
    TaskIterator allTask();
    TaskIterator completedTasks();
    TaskIterator inCompletedTasks();
}
