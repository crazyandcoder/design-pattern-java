package design_pattern.struct.decorator;

public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("ConcreteDecoratorB  sampleOperation");
    }
}
