package design_pattern.struct.proxy._static;

public class Client {

    public void request() {
        Subject subject = new ProxySubject();
        subject.request();
    }
}
