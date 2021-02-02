## 1.1 使用场景

例如，一个系统中可以存在多个打印任务，但是只能有一个正在工作的任务；一个系统只能有一个窗口管理器或文件系统；一个系统只能有一个计时工具或ID（序号）生成器。



## 1.2 定义

单例模式(Singleton Pattern)：单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。

## 1.3 UML结构

![image](https://cdn.nlark.com/yuque/0/2021/jpeg/666982/1612144967557-dc5ce871-6414-43ee-9719-193c12816fe3.jpeg)

## 1.4 时序图

![image](https://cdn.nlark.com/yuque/0/2021/jpeg/666982/1612144979649-8bc29033-3f04-4434-97a4-20dd13753569.jpeg)



## 1.5 代码实例

### 1.5.1 饿汉式

**饿汉式的实现方式比较简单。在类加载的时候，instance静态实例就已经创建并初始化好了**，所以，instance实例的创建过程是线程安全的。不过，这**样的实现方式不支持延迟加载（在真正用到IdGenerator的时候，再创建实例）**，从名字中我们也可以看出这一点。具体的代码实现如下所示：



```
public class IdGenerator { 
  private AtomicLong id = new AtomicLong(0);
  private static final IdGenerator instance = new IdGenerator();
  private IdGenerator() {}
  public static IdGenerator getInstance() {
    return instance;
  }
  public long getId() { 
    return id.incrementAndGet();
  }
}
```



有人觉得这种实现方式不好，因为不支持延迟加载，如果实例占用资源多（比如占用内存多）或初始化耗时长（比如需要加载各种配置文件），提前初始化实例是一种浪费资源的行为。最好的方法应该在用到的时候再去初始化。不过，我个人并不认同这样的观点。



如果初始化耗时长，那我们最好不要等到真正要用它的时候，才去执行这个耗时长的初始化过程，这会影响到系统的性能（比如，在响应客户端接口请求的时候，做这个初始化操作，会导致此请求的响应时间变长，甚至超时）。采用饿汉式实现方式，将耗时的初始化操作，提前到程序启动的时候完成，这样就能避免在程序运行的时候，再去初始化导致的性能问题。



如果实例占用资源多，按照fail-fast的设计原则（有问题及早暴露），那我们也希望在程序启动时就将这个实例初始化好。如果资源不够，就会在程序启动的时候触发报错（比如Java中的 PermGen Space OOM），我们可以立即去修复。这样也能避免在程序运行一段时间后，突然因为初始化这个实例占用资源过多，导致系统崩溃，影响系统的可用性。



### 1.5.2 懒汉式

有饿汉式，对应的，就有懒汉式。**懒汉式相对于饿汉式的优势是支持延迟加载**。具体的代码实现如下所示：



```
public class IdGenerator { 
  private AtomicLong id = new AtomicLong(0);
  private static IdGenerator instance;
  private IdGenerator() {}
  public static synchronized IdGenerator getInstance() {
    if (instance == null) {
      instance = new IdGenerator();
    }
    return instance;
  }
  public long getId() { 
    return id.incrementAndGet();
  }
}
```



***不过懒汉式的缺点也很明显，我们给getInstance()这个方法加了一把大锁（synchronzed），导致这个函数的并发度很低。量化一下的话，并发度是1，也就相当于串行操作了。而这个函数是在单例使用期间，一直会被调用。如果这个单例类偶尔会被用到，那这种实现方式还可以接受。但是，如果频繁地用到，那频繁加锁、释放锁及并发度低等问题，会导致性能瓶颈，这种实现方式就不可取了。***

***
***



### 1.5.3 双重检测

饿汉式不支持延迟加载，懒汉式有性能问题，不支持高并发。那我们再来看一种既支持延迟加载、又支持高并发的单例实现方式，也就是双重检测实现方式。



在这种实现方式中，只要instance被创建之后，即便再调用getInstance()函数也不会再进入到加锁逻辑中了。所以，这种实现方式解决了懒汉式并发度低的问题。具体的代码实现如下所示：



```
public class IdGenerator { 
  private AtomicLong id = new AtomicLong(0);
  private static IdGenerator instance;
  private IdGenerator() {}
  public static IdGenerator getInstance() {
    if (instance == null) {
      synchronized(IdGenerator.class) { // 此处为类级别的锁
        if (instance == null) {
          instance = new IdGenerator();
        }
      }
    }
    return instance;
  }
  public long getId() { 
    return id.incrementAndGet();
  }
}
```



***网上有人说，这种实现方式有些问题。因为指令重排序\******，可能会导致IdGenerator对象被new出来，并且赋值给instance之后，还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。\***

***要解决这个问题，我们需要给instance成员变量加上volatile关键字，禁止指令重排序才行。实际上，只有很低版本的Java才会有这个问题。我们现在用的高版本的Java已经在JDK内部实现中解决了这个问题（解决的方法很简单，只要把对象new操作和初始化操作设计为原子操作，就自然能禁止重排序）。关于这点的详细解释，跟特定语言有关，我就不展开讲了，感兴趣的同学可以自行研究一下\*****。**

### 1.5.4 静态内部类

我们再来看一种比双重检测更加简单的实现方法，那就是利用Java的静态内部类。它有点类似饿汉式，但又能做到了延迟加载。具体是怎么做到的呢？我们先来看它的代码实现。



```
public class IdGenerator { 
  private AtomicLong id = new AtomicLong(0);
  private IdGenerator() {}
  private static class SingletonHolder{
    private static final IdGenerator instance = new IdGenerator();
  }
  
  public static IdGenerator getInstance() {
    return SingletonHolder.instance;
  }
 
  public long getId() { 
    return id.incrementAndGet();
  }
}
```



**SingletonHolder 是一个静态内部类，当外部类IdGenerator被加载的时候，并不会创建SingletonHolder实例对象。只有当调用getInstance()方法时，SingletonHolder才会被加载，这个时候才会创建instance。instance的唯一性、创建过程的线程安全性，都由JVM来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载。**





### 1.5.5 枚举

最后，我们介绍一种最简单的实现方式，基于枚举类型的单例实现。这种实现方式通过Java枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。具体的代码如下所示：



```
public enum IdGenerator {
  INSTANCE;
  private AtomicLong id = new AtomicLong(0);
 
  public long getId() { 
    return id.incrementAndGet();
  }
}
```



## 1.6 优缺点

### 1.6.1 优点

由于单例模式在内存中只有一个实例，减少了内存开支，特别是一个对象需要频繁地创建、销毁时，而且创建或销毁时性能又无法优化，单例模式的优势就非常明显。



由于单例模式只生成一个实例，所以减少了系统的性能开销，当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后用永久驻留内存的方式来解决（在Java EE中采用单例模式时需要注意JVM垃圾回收机制）。



单例模式可以避免对资源的多重占用，例如一个写文件动作，由于只有一个实例存在内存中，避免对同一个资源文件的同时写操作。



单例模式可以在系统设置全局的访问点，优化和共享资源访问，例如可以设计一个单例类，负责所有数据表的映射处理。

### 1.6.2 缺点



单例模式一般没有接口，扩展很困难，若要扩展，除了修改代码基本上没有第二种途径可以实现。



单例模式为什么不能增加接口呢？因为接口对单例模式是没有任何意义的，它要求“自行实例化”，并且提供单一实例、接口或抽象类是不可能被实例化的。当然，在特殊情况下，单例模式可以实现接口、被继承等，需要在系统开发中根据环境判断。单例模式对测试是不利的。在并行开发环境中，如果单例模式没有完成，是不能进行测试的，没有接口也不能使用mock的方式虚拟一个对象。



单例模式与单一职责原则有冲突。一个类应该只实现一个逻辑，而不关心它是否是单例的，是不是要单例取决于环境，单例模式把“要单例”和业务逻辑融合在一个类中。





## 1.7 单例模式存在的问题



大部分情况下，我们在项目中使用单例，都是用它来表示一些全局唯一类，比如配置信息类、连接池类、ID生成器类。单例模式书写简洁、使用方便，在代码中，我们不需要创建对象，直接通过类似IdGenerator.getInstance().getId()这样的方法来调用就可以了。但是，这种使用方法有点类似硬编码（hard code），会带来诸多问题。

-   构造函数需要是private访问权限的，这样才能避免外部通过new创建实例；
-   考虑对象创建时的线程安全问题；
-   考虑是否支持延迟加载；
-   考虑getInstance()性能是否高（是否加锁）。



## 1.8 总结

**1.单例的定义**

单例设计模式（Singleton Design Pattern）理解起来非常简单。一个类只允许创建一个对象（或者叫实例），那这个类就是一个单例类，这种设计模式就叫作单例设计模式，简称单例模式。

**2.单例的用处**

从业务概念上，有些数据在系统中只应该保存一份，就比较适合设计为单例类。比如，系统的配置信息类。除此之外，我们还可以使用单例解决资源访问冲突的问题。

**3.单例的实现**

单例有下面几种经典的实现方式。

-   饿汉式

饿汉式的实现方式，在类加载的期间，就已经将instance静态实例初始化好了，所以，instance实例的创建是线程安全的。不过，这样的实现方式不支持延迟加载实例。

-   懒汉式

懒汉式相对于饿汉式的优势是支持延迟加载。这种实现方式会导致频繁加锁、释放锁，以及并发度低等问题，频繁的调用会产生性能瓶颈。

-   双重检测

双重检测实现方式既支持延迟加载、又支持高并发的单例实现方式。只要instance被创建之后，再调用getInstance()函数都不会进入到加锁逻辑中。所以，这种实现方式解决了懒汉式并发度低的问题。

-   静态内部类

利用Java的静态内部类来实现单例。这种实现方式，既支持延迟加载，也支持高并发，实现起来也比双重检测简单。

-   枚举

最简单的实现方式，基于枚举类型的单例实现。这种实现方式通过Java枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。



