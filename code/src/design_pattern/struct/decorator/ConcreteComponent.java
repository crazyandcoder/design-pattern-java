package design_pattern.struct.decorator;

public class ConcreteComponent implements Component{
    @Override
    public void sampleOperation() {
        System.out.println("ConcreteComponent sampleOperation");
    }
}
