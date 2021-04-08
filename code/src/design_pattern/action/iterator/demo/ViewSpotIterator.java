package design_pattern.action.iterator.demo;

public interface ViewSpotIterator {
    boolean hasNext();
    WyViewSpot first();
    WyViewSpot next();
    WyViewSpot previous();
    WyViewSpot last();
}
