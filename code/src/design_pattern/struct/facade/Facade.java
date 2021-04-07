package design_pattern.struct.facade;

public class Facade {

    private ISystem systemA = new SystemA();
    private ISystem systemB = new SystemB();

    public void doOperate() {
        systemA.doOperate();
        systemB.doOperate();
    }

}
