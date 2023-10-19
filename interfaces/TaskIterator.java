package TodoList.interfaces;

import TodoList.models.Task;

public interface TaskIterator {

    Task getNext();

    boolean hasNext();

    void reset();

}
