package design_pattern.create.factory.method;

/**
 * 抽象工厂类，不再负责创建具体的产品
 */
public interface IFactory {

    IProduct createProduction(String name);

    <T extends IProduct> IProduct createProduction(Class<T> clz);

}
