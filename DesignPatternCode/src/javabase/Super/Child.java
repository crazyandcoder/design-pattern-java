package javabase.Super;

public class Child extends Parent {

    private String company;

    public Child(String name, int age) {
        super(name, age);
    }

    public Child(String name, int age, String company) {
        super(name, age);
        this.company = company;
    }

    @Override
    public void print() {
        System.out.println("child: " + " age: " + super.getAge() + "  name: " + super.getName() + "  company: " + company);
    }
}
