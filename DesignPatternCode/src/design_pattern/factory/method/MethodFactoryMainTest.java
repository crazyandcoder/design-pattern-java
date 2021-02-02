package design_pattern.factory.method;

public class MethodFactoryMainTest {
    public static void main(String[] args) {

        IFactory factoryA = new ConcreteFactoryA();
        IProduct productA = factoryA.createProduction(ConcreteIProductA.class);
        productA.description();


        IFactory  factoryB=new ConcreteFactoryB();
        IProduct productB = factoryB.createProduction(ConcreteIProductBB.class);
        productB.description();
    }
}
