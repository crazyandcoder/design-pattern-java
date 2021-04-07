package design_pattern.create.factory._abstract;

public class ConcreteFactory1 implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        AbstractProductA productA1 = new ProductA1();
        return productA1;
    }

    @Override
    public AbstractProductB createProductB() {
        AbstractProductB productB1 = new ProductB1();
        return productB1;
    }

    @Override
    public AbstractProductC createProductC() {
        return null;
    }
}
