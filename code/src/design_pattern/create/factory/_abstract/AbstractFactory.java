package design_pattern.create.factory._abstract;

public interface AbstractFactory {
    AbstractProductA createProductA();

    AbstractProductB createProductB();

    AbstractProductC createProductC();
}
