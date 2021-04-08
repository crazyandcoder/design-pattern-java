package design_pattern.action.iterator;
public class IteratorPattern {
    public static void main(String args[]) {
        Aggregate<String> ag = new ConcreteAggregate<>();
        ag.add("北京大学");
        ag.add("南京大学");
        ag.add("东京大学");
        ag.add("曼哈顿大学");
        _Iterator<String> iterator = ag.getIterator();
        while (iterator.hasNext()){
            String result=iterator.next();
            System.out.println(result);
        }

        System.out.println("*************");
        String first=iterator.first();
        System.out.println("first: "+first);
    }
}
