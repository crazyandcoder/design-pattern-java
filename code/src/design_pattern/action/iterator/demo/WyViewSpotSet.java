package design_pattern.action.iterator.demo;

import java.util.ArrayList;

public class WyViewSpotSet implements ViewSpotSet {
    private ArrayList<WyViewSpot> list = new ArrayList<WyViewSpot>();
    public void add(WyViewSpot obj) {
        list.add(obj);
    }
    public void remove(WyViewSpot obj) {
        list.remove(obj);
    }
    public ViewSpotIterator getIterator() {
        return (new WyViewSpotIterator(list));
    }
}
