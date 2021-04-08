package javase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ComparableDemo {
    public static void main(String args[]) {
        CopyOnWriteArrayList<Data> data = new CopyOnWriteArrayList<>();
        data.add(new Data("30.123"));
        data.add(new Data("1.123"));
        data.add(new Data("15.123"));
        data.add(new Data("150.123"));
        System.out.println(data);
        Collections.sort(data);
        System.out.println(data);
    }
}

class Data implements Comparable<Data> {
    private String data;

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }

    @Override
    public int compareTo(Data o) {
        double d1 = Double.parseDouble(this.data);
        double d2 = Double.parseDouble(o.data);
        if (d1 > d2) return 1;
        else if (d1 < d2) return -1;
        else return 0;
    }
}
