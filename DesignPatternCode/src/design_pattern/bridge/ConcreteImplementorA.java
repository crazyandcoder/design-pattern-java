package design_pattern.bridge;

public class ConcreteImplementorA implements Implementor{
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorA ----> operationImpl");
    }
}
