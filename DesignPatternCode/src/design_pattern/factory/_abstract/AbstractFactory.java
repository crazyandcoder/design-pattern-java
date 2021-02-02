package design_pattern.factory._abstract;

public interface AbstractFactory {
    AbstractProductA createProductA();

    AbstractProductB createProductB();

    AbstractProductC createProductC();
}
