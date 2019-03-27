package main.java;


import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        boolean[][] matrix = new boolean[5][5];
        Random random = new Random();

        // generate random matrix
        for(int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix.length;j++){
                matrix[i][j] = random.nextBoolean();
            }
        }

        // print random matrix
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        FindCluster findCluster = new FindCluster(matrix);
        List<Cluster> clusters = findCluster.perfom();

        clusters.stream().forEach((e)-> {
            if (e.getPoints().size()>1)
                System.out.println(e.toString());
        });
    }
}
