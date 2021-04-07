package design_pattern.struct.adapter._class;

/**
 * Adaptee是一组不兼容ITarget接口定义的接口
 */
public class ClassAdaptee {
    public void fa() {
        System.out.println("Adaptee fa");

    }

    public void fb() {
        System.out.println("Adaptee fb");
    }

    public void fc() {
        System.out.println("Adaptee fc");

    }


}
