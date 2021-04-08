package design_pattern.action.iterator.demo;

public interface ViewSpotSet {
    void add(WyViewSpot obj);
    void remove(WyViewSpot obj);
    ViewSpotIterator getIterator();
}
