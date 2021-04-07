package design_pattern.struct.proxy._dynamic;

public class Client {

    public static void main(String[] args) {
        ILawSuit proxy = (ILawSuit) ProxyFactory.getDynProxy(new CuiHuaNiu());
        proxy.prepare();
        proxy.submit("工资流水");
        proxy.defend();

        System.out.println("*****************");

        ILawSuit proxy1= (ILawSuit) ProxyFactory.getDynProxy(new SecondDogWang());
        proxy1.prepare();
        proxy1.submit("工资流水");
        proxy1.defend();
    }
}
