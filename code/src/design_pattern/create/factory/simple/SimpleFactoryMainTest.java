package design_pattern.create.factory.simple;


public class SimpleFactoryMainTest {
    public static void main(String[] args) {
        IProduct producta = Factory.createProduction(ConcreteIProductA.class);
        producta.description();
    }
}
