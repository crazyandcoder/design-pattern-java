package design_pattern.action.responsibility;

public class ChainOfResponsibilityPattern {
    public static void main(String str[]) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
