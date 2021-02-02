package design_pattern.factory.simple;

/**
 * 工厂类，生成各个具体产品
 */
public class Factory {

    /**
     * 根据相关参数生成具体的产品
     *
     * @param name
     * @return
     */
    public static IProduct createProduction(String name) {
        if (name.equals("a")) {
            return new ConcreteIProductA();
        } else if (name.equals("b")) {
            return new ConcreteIProductB();
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
    public static <T extends IProduct> IProduct createProduction(Class<T> clz) {
        try {
            IProduct IProduct = (IProduct) Class.forName(clz.getName()).newInstance();
            return (T) IProduct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
