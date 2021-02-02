package design_pattern.factory._abstract;

public class ConcreteFactory2 implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        AbstractProductA productA2 = new ProductA2();
        return productA2;
    }

    @Override
    public AbstractProductB createProductB() {
        AbstractProductB productB2 = new ProductB2();
        return productB2;
    }

    @Override
    public AbstractProductC createProductC() {
        return null;
    }
}
