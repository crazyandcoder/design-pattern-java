package design_pattern.action.iterator;

public interface Aggregate<T> {

    public void add(T t);

    void remove(T t);

    public _Iterator getIterator();
}
