package design_pattern.struct.proxy._static;

public class RealSubject extends Subject {

    @Override
    void request() {
        System.out.println("RealSubject request!!!");
    }
}
