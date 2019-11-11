import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Count Blobs recursively in 2D List
 */
public class CountBlobs2DRecList {

    public static void main(String[] args) {

        Integer[][] matrix = {  { 0, 0, 0, 1, 0 }, 
                                { 0, 1, 0, 1, 0 }, 
                                { 0, 1, 1, 1, 0 }, 
                                { 0, 0, 0, 0, 0 },
                                { 1, 0, 0, 0, 1 }, 
                                { 0, 0, 1, 1, 1 } };
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        System.out.println();
        for (int i = 0; i < matrix.length; i++){
            Integer[] row = matrix[i];
            List<Integer> l = Arrays.asList(row);
            System.out.printf("\t %s \n",l);
            list.add(l);
        }
        
        int count = blobsCount(list, list.size(), list.get(0).size());

        System.out.println();
        System.out.printf(" blobs: %d \n\n", count);
        
    }

    static int blobsCount(List<List<Integer>> list, int rows, int cols) {

        boolean[][] visited = new boolean[rows][cols]; // all default to false
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (isBlob(i, j, list, visited, rows, cols)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isBlob(int i, int j, List<List<Integer>> list, boolean[][] visited, int rows, int cols) {
        boolean isBlob = false;

        // detect blog by recursively visiting ones and count
        int count = visitOnes(i, j, list, visited, rows, cols);

        if (count > 0) {
            isBlob = true;
        }
        //System.out.printf("\nat %d,%d visited %d", i, j, count);
        return isBlob;
    }

    private static int visitOnes(int i, int j, List<List<Integer>> list, boolean[][] visited, int rows, int cols) {
        int count = 0;

        if (inGrid(i, j, rows, cols) && list.get(i).get(j) == 1 && !visited[i][j]) {
            visited[i][j] = true;
            count = 1 + visitOnes(i + 1, j, list, visited, rows, cols) + visitOnes(i - 1, j, list, visited, rows, cols)
                    + visitOnes(i, j + 1, list, visited, rows, cols) + visitOnes(i, j - 1, list, visited, rows, cols);
        }
        return count;
    }

    private static boolean inGrid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}