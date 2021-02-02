package design_pattern.factory.simple;

public class ConcreteIProductA implements IProduct {

    @Override
    public void description() {
        System.out.println("产品 A...");
    }
}
