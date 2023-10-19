package TodoList.interfaces;

public interface TaskIterator<T> {

    T getNext();

    boolean hasNext();

    void reset();

}
