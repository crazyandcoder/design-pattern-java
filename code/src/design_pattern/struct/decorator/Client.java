package design_pattern.struct.decorator;

public class Client {
    public static void main(String[] args) {
        Component component=new ConcreteComponent();
        Component concreteDecoratorA = new ConcreteDecoratorA(component);
        concreteDecoratorA.sampleOperation();

        System.out.println("***********************");

        Component concreteDecoratorB = new ConcreteDecoratorB(component);
        concreteDecoratorB.sampleOperation();

    }
}
