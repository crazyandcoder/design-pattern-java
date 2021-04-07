package design_pattern.create.singleinstance;

public class SingleTest {
    public static void main(String args[]) {
        System.out.println("id: "+EnumSingleInstance.INSTANCE.getId());
        System.out.println("id: "+EnumSingleInstance.INSTANCE.getId());
    }
}
