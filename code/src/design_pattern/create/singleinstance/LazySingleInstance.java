package design_pattern.create.singleinstance;

public class LazySingleInstance {
    private LazySingleInstance() {

    }

    private static LazySingleInstance instance = new LazySingleInstance();

    public static LazySingleInstance getInstance() {
        return instance;
    }


}
