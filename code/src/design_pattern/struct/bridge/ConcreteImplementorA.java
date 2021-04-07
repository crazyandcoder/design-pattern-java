package design_pattern.struct.bridge;

public class ConcreteImplementorA implements Implementor{
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorA ----> operationImpl");
    }
}
