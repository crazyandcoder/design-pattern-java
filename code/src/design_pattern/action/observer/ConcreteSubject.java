package design_pattern.action.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject<T> implements ISubject<T> {

    private List<IObserver<T>> observerList = new ArrayList<>();


    @Override
    public boolean attach(IObserver<T> observer) {
        return !this.observerList.contains(observer) && this.observerList.add(observer);
    }

    @Override
    public boolean detach(IObserver<T> observer) {
        return this.observerList.contains(observer) && this.observerList.remove(observer);
    }

    @Override
    public void notify(T t) {
        for (IObserver<T> observer : this.observerList) {
            observer.update(t);
        }
    }
}
