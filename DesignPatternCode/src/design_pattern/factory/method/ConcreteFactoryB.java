package design_pattern.factory.method;

public class ConcreteFactoryB implements IFactory {

    @Override
    public IProduct createProduction(String name) {
        if (name.equals("b")) {
            return new ConcreteIProductB();
        } else if (name.equals("bb")) {
            return new ConcreteIProductBB();
        }
        return null;
    }

    /**
     * 根据相关参数生成具体的产品
     *
     * @param clz
     * @param <T>
     * @return
     */
    @Override
    public <T extends IProduct> IProduct createProduction(Class<T> clz) {
        try {
            IProduct IProduct = (IProduct) Class.forName(clz.getName()).newInstance();
            return (T) IProduct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
