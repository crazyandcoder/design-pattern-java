package design_pattern.create.singleinstance;

public class DoubleCheckSingleInstance {
    private static volatile DoubleCheckSingleInstance instance;

    private DoubleCheckSingleInstance() {

    }

    public static DoubleCheckSingleInstance getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleInstance.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleInstance();
                }
            }
        }
        return instance;
    }
}
