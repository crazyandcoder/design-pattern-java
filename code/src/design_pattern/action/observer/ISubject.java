package design_pattern.action.observer;

public interface ISubject<T> {
    boolean attach(IObserver<T> observer);

    boolean detach(IObserver<T> observer);

    void notify(T t);
}
