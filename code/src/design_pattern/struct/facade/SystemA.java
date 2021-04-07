package design_pattern.struct.facade;

public class SystemA implements ISystem{
    @Override
    public void doOperate() {
        System.out.println("System A");
    }
}
