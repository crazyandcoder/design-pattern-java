package design_pattern.singleinstance;

public class SingleInstanceTest {

    public static void main(String[] args) {


        createHungryThread();
        createHungryThread();
        createHungryThread();
//        createHungrySingleInstance();
//        createThread();
//        createThread();
    }

    public static void createThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                createLazySingleInstance();
            }
        }).start();
    }
    public static void createHungryThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                createHungrySingleInstance();
            }
        }).start();
    }

    public static void createLazySingleInstance() {
        for (int i = 0; i < 5; i++) {
            System.out.println(LazySingleInstance.getInstance().toString());
        }
    }

    public static void createHungrySingleInstance() {
        for (int i = 0; i < 20; i++) {
            System.out.println(HungrySingleInstance.getInstance().toString());
        }
    }
}
