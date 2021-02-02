package design_pattern.singleinstance;

public class StaticInnerSingleInstance {
    private  StaticInnerSingleInstance(){

    }
    private static class StaticInnerClassHelper{
        private static final StaticInnerSingleInstance instance =new StaticInnerSingleInstance();
    }

    public static StaticInnerSingleInstance getInstance(){
        return StaticInnerClassHelper.instance;
    }

}
