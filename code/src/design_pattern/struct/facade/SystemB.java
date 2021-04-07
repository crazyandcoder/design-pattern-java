package design_pattern.struct.facade;

public class SystemB implements ISystem{
    @Override
    public void doOperate() {
        System.out.println("System B");
    }
}
