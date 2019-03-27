package main.java;

import java.util.ArrayList;
import java.util.List;

public class FindCluster {

    List<Cluster> clusters;
    private final boolean[][] matrix;

    List<Point> neighbours = new ArrayList<>();


    public FindCluster(boolean[][] matrix){
        clusters = new ArrayList<>();
        this.matrix = matrix;
    }

    /**

     (x-1,y-1)      (x-1,y)     (x-1,y+1)
      (x,y-1)        (x,y)       (x,y+1)
     (x+1,y-1)      (x+1,y)     (x+1,y+1)

     */
    private void findNeighbours(Point point){

        matrix[point.getX()][point.getY()] = false;

        if(point.getX()>=1 && point.getY()>=1) {
            if (matrix[point.getX() - 1][point.getY() - 1]) {
                neighbours.add(new Point(point.getX() - 1, point.getY() - 1));
                findNeighbours(new Point(point.getX() - 1, point.getY() - 1));
            }
        }

        if(point.getX()>=1) {
            if(matrix[point.getX()-1][point.getY()]){
                neighbours.add(new Point(point.getX()-1,point.getY()));
                findNeighbours(new Point(point.getX()-1,point.getY()));
            }
        }

        if(point.getX()>=1 && point.getY()<matrix.length-1) {
            if (matrix[point.getX() - 1][point.getY() + 1]) {
                neighbours.add(new Point(point.getX() - 1, point.getY() + 1));
                findNeighbours(new Point(point.getX() - 1, point.getY() + 1));
            }
        }

        if(point.getY()>=1) {
            if(matrix[point.getX()][point.getY()-1]){
                neighbours.add(new Point(point.getX(),point.getY()-1));
                findNeighbours(new Point(point.getX(),point.getY()-1));
            }
        }

        if(point.getY()<matrix.length-1) {
            if(matrix[point.getX()][point.getY()+1]){
                neighbours.add(new Point(point.getX(),point.getY()+1));
                findNeighbours(new Point(point.getX(),point.getY()+1));
            }
        }

        if(point.getY()>=1 && point.getX()<matrix.length-1) {
            if(matrix[point.getX()+1][point.getY()-1]){
                neighbours.add(new Point(point.getX()+1,point.getY()-1));
                findNeighbours(new Point(point.getX()+1,point.getY()-1));
            }
        }

        if(point.getX()<matrix.length-1) {
            if(matrix[point.getX()+1][point.getY()]){
                neighbours.add(new Point(point.getX()+1,point.getY()));
                findNeighbours(new Point(point.getX()+1,point.getY()));
            }
        }

        if(point.getX()<matrix.length-1 && point.getY()<matrix.length-1) {
            if(matrix[point.getX()+1][point.getY()+1]){
                neighbours.add(new Point(point.getX()+1,point.getY()+1));
                findNeighbours(new Point(point.getX()+1,point.getY()+1));
            }
        }
    }

    public List<Cluster> perfom(){

        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){

                if(matrix[i][j]){
                    neighbours.add(new Point(i,j));
                    findNeighbours(new Point(i,j));
                    clusters.add(new Cluster(neighbours));
                    neighbours.clear();
                }
            }
        }

        return clusters;
    }

}
