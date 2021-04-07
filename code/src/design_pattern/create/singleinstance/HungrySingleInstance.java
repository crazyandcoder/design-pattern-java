package design_pattern.create.singleinstance;

public class HungrySingleInstance {
    private HungrySingleInstance() {

    }

    private static HungrySingleInstance instance = null;

    public synchronized static HungrySingleInstance getInstance() {
        if (instance == null) {
            instance = new HungrySingleInstance();
        }
        return instance;
    }
}
