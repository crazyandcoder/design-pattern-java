package design_pattern.struct.proxy._static;

public class ProxySubject extends Subject {

    private RealSubject realSubject = new RealSubject();

    @Override
    void request() {
        System.out.println("before invoke realSubject request !!!");
        realSubject.request();
        System.out.println("after invoke realSubject request !!!");
    }
}
