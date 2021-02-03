-   # 2. 工厂方法模式

    ## 2.1 使用场景

    现在对该系统进行修改，**不再设计一个按钮工厂类来统一负责所有产品的创建，而是将具体按钮的创建过程交给专门的工厂子类去完成**，我们先定义一个抽象的按钮工厂类，再定义具体的工厂类来生成圆形按钮、矩形按钮、菱形按钮等，它们实现在抽象按钮工厂类中定义的方法。这种抽象化的结果使这种结构可以在不修改具体工厂类的情况下引进新的产品，如果出现新的按钮类型，只需要为这种新类型的按钮创建一个具体的工厂类就可以获得该新按钮的实例，这一特点无疑使得工厂方法模式具有超越简单工厂模式的优越性，更加符合“开闭原则”。

    

    工厂方法模式是简单工厂模式的进一步抽象和推广。由于使用了面向对象的多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责哪一个产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。

    

    ## 2.2 定义

    在工厂方法模式中，**工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象**，这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。

    

    ## 2.3 UML结构

    简单工厂模式包含如下角色：

    

    -   **Factory：**抽象工厂

    -   -   负责定义创建产品对象的公共接口

    

    -   **ConcreteFactory：具体**工厂

    -   -   工厂角色负责实现创建所有实例的内部逻辑

    

    -   **Product：抽象产品角色**

    -   -   抽象产品角色是所创建的所有对象的父类，负责描述所有实例所共有的公共接口

    

    -   **ConcreteProduct：具体产品角色**

    -   -   具体产品角色是创建目标，所有创建的对象都充当这个角色的某个具体类的实例。

    

    ![image](https://cdn.nlark.com/yuque/0/2021/jpeg/666982/1611718225567-4ab05aae-f163-465a-8003-61eacdeb90ae.jpeg)

    

    ## 2.4 时序图

    

    ![image](https://cdn.nlark.com/yuque/0/2021/jpeg/666982/1611718247885-b4936f1c-0ce0-47fe-b578-2a287ff72ec8.jpeg)

    

    ## 2.5 代码实例

    **抽象产品类IProduct**

    ```
    /**
     * 抽象产品
     */
    public interface IProduct {
        void description();
    }
    ```

    **具体产品A**

    ```
    public class ConcreteProductA implements IProduct {
    
        @Override
        public void description() {
            System.out.println("产品 A...");
        }
    }
    ```

    **具体产品AA**

    ```
    public class ConcreteProductAA implements IProduct {
    
        @Override
        public void description() {
            System.out.println("产品 AA...");
        }
    }
    ```

    **具体产品B**

    ```
    public class ConcreteProductB implements IProduct {
    
        @Override
        public void description() {
            System.out.println("产品 B...");
        }
    }
    ```

    **具体产品BB**

    ```
    public class ConcreteProductBB implements IProduct {
    
        @Override
        public void description() {
            System.out.println("产品 BB...");
        }
    }
    ```

    **
    **

    **抽象工厂类**

    ```
    /**
     * 抽象工厂类，不再负责创建具体的产品
     */
    public interface IFactory {
    
        IProduct createProduction(String name);
    
        <T extends IProduct> IProduct createProduction(Class<T> clz);
    
    }
    ```

    **具体工厂类A**

    ```
    public class ConcreteFactoryA implements IFactory {
    
        @Override
        public IProduct createProduction(String name) {
            if (name.equals("a")) {
                return new ConcreteIProductA();
            } else if (name.equals("aa")) {
                return new ConcreteIProductAA();
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
    ```

    **具体工厂类B**

    ```
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
    ```

    **
    **

    **测试**

    

    ```
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
    ```

    

    ## 2.6 优缺点

    ### 2.6.1 优点

    -   在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
    -   基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够使工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。工厂方法模式之所以又被称为多态工厂模式，是因为所有的具体工厂类都具有同一抽象父类。
    -   使用工厂方法模式的另一个优点是在系统中加入新产品时，无须修改抽象工厂和抽象产品提供的接口，无须修改客户端，也无须修改其他的具体工厂和具体产品，而只要添加一个具体工厂和具体产品就可以了。这样，系统的可扩展性也就变得非常好，完全符合“开闭原则”。

    

    ### 2.6.2 缺点

    -   在添加新产品时，需要编写新的具体产品类，而且还要提供与之对应的具体工厂类，系统中类的个数将成对增加，在一定程度上增加了系统的复杂度，有更多的类需要编译和运行，会给系统带来一些额外的开销。
    -   由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度，且在实现时可能需要用到DOM、反射等技术，增加了系统的实现难度。

    

    

    ## 2.7 适用场景

    在以下情况下可以使用工厂方法模式：

    

    -   一个类不知道它所需要的对象的类：在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建；客户端需要知道创建具体产品的工厂类。
    -   一个类通过其子类来指定创建哪个对象：在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。
    -   将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定，可将具体工厂类的类名存储在配置文件或数据库中。

    

    ## 2.8 总结

    -   工厂方法模式又称为工厂模式，它属于类创建型模式。在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。
    -   工厂方法模式包含四个角色：抽象产品是定义产品的接口，是工厂方法模式所创建对象的超类型，即产品对象的共同父类或接口；具体产品实现了抽象产品接口，某种类型的具体产品由专门的具体工厂创建，它们之间往往一一对应；抽象工厂中声明了工厂方法，用于返回一个产品，它是工厂方法模式的核心，任何在模式中创建对象的工厂类都必须实现该接口；具体工厂是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户调用，返回一个具体产品类的实例。
    -   工厂方法模式是简单工厂模式的进一步抽象和推广。由于使用了面向对象的多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。
    -   工厂方法模式的主要优点是增加新的产品类时无须修改现有系统，并封装了产品对象的创建细节，系统具有良好的灵活性和可扩展性；其缺点在于增加新产品的同时需要增加新的工厂，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性。
    -   工厂方法模式适用情况包括：一个类不知道它所需要的对象的类；一个类通过其子类来指定创建哪个对象；将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定。