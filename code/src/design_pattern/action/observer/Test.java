package design_pattern.action.observer;

public class Test {
    public static void main(String args[]) {

        //被观察者
        ISubject<String> observable = new ConcreteSubject<>();

        //观察者
        IObserver<String> observer = new ConcreteObserver<>();

        //被观察者注入观察者
        observable.attach(observer);

        //被观察者通知观察者
        observable.notify("我改变了，这是最新的我...");
    }
}
