package design_pattern.factory._abstract;

public class AbstractFactoryMainTest {

    public static void main(String[] args) {

        AbstractFactory factory = new ConcreteFactory1();
        AbstractProductA productA = factory.createProductA();
        productA.eat();

        AbstractProductB productB = factory.createProductB();
        productB.eat();

        AbstractFactory factory2 = new ConcreteFactory2();
        AbstractProductA productA2 = factory2.createProductA();
        productA2.eat();

        AbstractProductB productB2 = factory2.createProductB();
        productB2.eat();



    }
}
