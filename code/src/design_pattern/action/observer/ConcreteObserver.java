package design_pattern.action.observer;

public class ConcreteObserver<T> implements IObserver<T> {

    @Override
    public void update(T t) {
        System.out.println("receive: " + t.toString());
    }
}
