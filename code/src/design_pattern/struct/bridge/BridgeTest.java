package design_pattern.struct.bridge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BridgeTest {
    public static void main(String args[]) {
        Implementor implementorA=new ConcreteImplementorA();
        implementorA.operationImpl();

        Abstraction abstractionA=new RefineAbstraction(implementorA);
        abstractionA.operation();

        Abstraction abstractionB=new RefineAbstraction(new ConcreteImplementorB());
        abstractionB.operation();

    }
}
