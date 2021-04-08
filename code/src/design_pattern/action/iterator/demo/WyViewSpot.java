package design_pattern.action.iterator.demo;

public class WyViewSpot {
    private String Name;
    private String Introduce;
    WyViewSpot(String Name, String Introduce) {
        this.Name = Name;
        this.Introduce = Introduce;
    }
    public String getName() {
        return Name;
    }
    public String getIntroduce() {
        return Introduce;
    }
}
