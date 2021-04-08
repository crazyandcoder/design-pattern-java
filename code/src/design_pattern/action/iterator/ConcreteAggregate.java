package design_pattern.action.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate<E> implements Aggregate<E> {

    private List<E> list = new ArrayList<>();

    @Override
    public void add(E e) {
        list.add(e);
    }

    @Override
    public void remove(E e) {
        list.remove(e);
    }

    @Override
    public _Iterator getIterator() {
        return new ConcreteAggregateIterator();
    }


    private class ConcreteAggregateIterator<E> implements _Iterator<E> {
        private int index = -1;

        @Override
        public E first() {
            index = 0;
            return list == null ? null : (E) list.get(index);
        }

        @Override
        public E next() {
            if (hasNext()) {
                index++;
                return (E) list.get(index);
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return index < list.size() - 1;
        }
    }
}
