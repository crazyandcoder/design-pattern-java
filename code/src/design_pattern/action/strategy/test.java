package design_pattern.action.strategy;

import java.util.Comparator;

public class test {
    public static void main(String args[]) {
        IStrategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.algorithm();

        Comparator comparator;
    }
}
