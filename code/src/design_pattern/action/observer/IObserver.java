package design_pattern.action.observer;

/**
 * 抽象观察者
 * @param <T>
 */
public interface IObserver<T> {
    void update(T t);
}
