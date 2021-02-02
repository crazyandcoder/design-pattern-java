package design_pattern.singleinstance;

public class DoubleCheckSingleInstance {
    private static DoubleCheckSingleInstance instance;

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
