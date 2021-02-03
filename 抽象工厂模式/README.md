-   # 3. 抽象工厂模式

    ## 3.1 使用场景

    

     **为了更清晰地理解抽象工厂模式，需要先引入两个概念：**

    >   • **产品等级结构 ：**
    >
    >   产品等级结构即产品的继承结构，如一个抽象类是电视机，其子类有海尔电视机、海信电视机、TCL电视机，则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机是其子类。
    >
    >   
    >
    >   • **产品族 ：**
    >
    >   在抽象工厂模式中，产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品，如海尔电器工厂生产的海尔电视机、海尔电冰箱，海尔电视机位于电视机产品等级结构中，海尔电冰箱位于电冰箱产品等级结构中。

    

    在工厂方法模式中具体工厂负责生产具体的产品，每一个具体工厂对应一种具体产品，工厂方法也具有唯一性，一般情况下，一个具体工厂中只有一个工厂方法或者一组重载的工厂方法。但是有时候我们需要一个工厂可以提供多个产品对象，而不是单一的产品对象。

    

    当系统所提供的工厂所需生产的具体产品并不是一个简单的对象，而是多个位于不同产品等级结构中属于不同类型的具体产品时需要使用抽象工厂模式。

    

    抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形态。

    

    **抽象工厂模式与工厂方法模式最大的区别在于，工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构，一个工厂等级结构可以负责多个不同产品等级结构中的产品对象的创建 。当一个工厂等级结构可以创建出分属于不同产品等级结构的一个产品族中的所有对象时，抽象工厂模式比工厂方法模式更为简单、有效率。**

    

    

    ## 3.2 定义

    抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。

    

    ## 3.3 UML结构

    简单工厂模式包含如下角色：

    

    -   **AbstractFactory：****抽象工厂**
    -   **ConcreteFactory：具体**工厂
    -   **Product：具体产品角色**
    -   **AbstractProduct：抽象产品**

    

    

    ![image](https://cdn.nlark.com/yuque/0/2021/jpeg/666982/1611737001305-c14d95b2-ebc0-419c-b60c-f5eeae3a280f.jpeg)

    

    ## 3.4 时序图

    

    ![image](https://cdn.nlark.com/yuque/0/2021/jpeg/666982/1611737563021-9e1ac1d6-cb29-4e9d-88aa-3c0ff308f012.jpeg)

    

    ## 3.5 代码实例

    **抽象产品A**

    ```
    public interface AbstractProductA {
        void eat();
    }
    ```

    **具体产品A1**

    ```
    public class ProductA1 implements AbstractProductA {
        @Override
        public void eat() {
            System.out.println("A1 eat...");
        }
    }
    ```

    **具体产品A2**

    ```
    public class ProductA2 implements AbstractProductA {
        @Override
        public void eat() {
            System.out.println("A2 eat...");
        }
    }
    ```

    **抽象产品B**

    ```
    public interface AbstractProductB {
        void eat();
    }
    ```

    **具体产品B1**

    ```
    public class ProductB1 implements AbstractProductB {
        @Override
        public void eat() {
            System.out.println("B1 eat...");
        }
    }
    ```

    **具体产品B2**

    ```
    public class ProductB2 implements AbstractProductB {
        @Override
        public void eat() {
            System.out.println("B2 eat...");
        }
    }
    ```

    **抽象工厂**

    ```
    public interface AbstractFactory {
        AbstractProductA createProductA();
    
        AbstractProductB createProductB();
    }
    ```

    **具体工厂1，生成产品A和B**

    ```
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
    }
    ```

    

    **具体工厂2，生成产品A和B**

    ```
    public class ConcreteFactory2 implements AbstractFactory {
    
        @Override
        public AbstractProductA createProductA() {
            AbstractProductA productA2 = new ProductA2();
            return productA2;
        }
    
        @Override
        public AbstractProductB createProductB() {
            AbstractProductB productB2 = new ProductB2();
            return productB2;
        }
    }
    ```

    **测试**

    ```
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
    ```

    

    

    

    ## 3.6 优缺点

    ### 3.6.1 优点

    -   抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易。所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。另外，应用抽象工厂模式可以实现高内聚低耦合的设计目的，因此抽象工厂模式得到了广泛的应用。
    -   当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。这对一些需要根据当前环境来决定其行为的软件系统来说，是一种非常实用的设计模式。
    -   增加新的具体工厂和产品族很方便，无须修改已有系统，符合“开闭原则”。

    

    ### 3.6.2 缺点

    -   在添加新的产品对象时，难以扩展抽象工厂来生产新种类的产品，这是因为在抽象工厂角色中规定了所有可能被创建的产品集合，要支持新种类的产品就意味着要对该接口进行扩展，而这将涉及到对抽象工厂角色及其所有子类的修改，显然会带来较大的不便。
    -   开闭原则的倾斜性（**增加新的工厂和产品族容易，增加新的产品等级结构麻烦**）。

    

    

    ## 3.7 适用场景

    在以下情况下可以使用抽象工厂模式：

    

    -   一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是重要的。
    -   系统中有多于一个的产品族，而每次只使用其中某一产品族。
    -   属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。
    -   系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。

    

    ## 3.8 总结

    -   抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。
    -   抽象工厂模式包含四个角色：抽象工厂用于声明生成抽象产品的方法；具体工厂实现了抽象工厂声明的生成抽象产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中；抽象产品为每种产品声明接口，在抽象产品中定义了产品的抽象业务方法；具体产品定义具体工厂生产的具体产品对象，实现抽象产品接口中定义的业务方法。
    -   抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形态。抽象工厂模式与工厂方法模式最大的区别在于，工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构。
    -   抽象工厂模式的主要优点是隔离了具体类的生成，使得客户并不需要知道什么被创建，而且每次可以通过具体工厂类创建一个产品族中的多个对象，增加或者替换产品族比较方便，增加新的具体工厂和产品族很方便；主要缺点在于增加新的产品等级结构很复杂，需要修改抽象工厂和所有的具体工厂类，对“开闭原则”的支持呈现倾斜性。
    -   抽象工厂模式适用情况包括：一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节；系统中有多于一个的产品族，而每次只使用其中某一产品族；属于同一个产品族的产品将在一起使用；系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。