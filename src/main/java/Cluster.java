package main.java;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    List<Point> points;

    public Cluster(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        String out = "Cluster: ";

        for(int i=0;i<points.size();i++){
            out += points.get(i).toString()+"; ";
        }
        return out;
    }
}
