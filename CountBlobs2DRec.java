

/**
 * Count Blobs recursively in 2D array
 */
public class CountBlobs2DRec {

    public static void main(String[] args) {

        int[][] matrix = { { 0, 0, 0, 1, 0 }, 
                           { 0, 1, 0, 1, 0 }, 
                           { 0, 1, 1, 1, 0 }, 
                           { 0, 0, 0, 0, 0 },
                           { 1, 0, 0, 0, 1 }, 
                           { 0, 0, 1, 1, 1 } };


        int count = blobsCount(matrix, matrix.length, matrix[0].length);

        System.out.println();
        System.out.printf(" blobs: %d \n\n", count);
    }

    static int blobsCount(int matrix[][], int rows, int cols) {

        boolean[][] visited = new boolean[rows][cols]; // all default to false
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (isBlob(i, j, matrix, visited, rows, cols)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isBlob(int i, int j, int[][] matrix, boolean[][] visited, int rows, int cols) {
        boolean isBlob = false;

        // detect blog by recursively visiting ones and count
        int count = visitOnes(i, j, matrix, visited, rows, cols);

        if (count > 0) {
            isBlob = true;
        }
        //System.out.printf("\nat %d,%d visited %d", i, j, count);
        return isBlob;
    }

    private static int visitOnes(int i, int j, int[][] matrix, boolean[][] visited, int rows, int cols) {
        int count = 0;

        if (inGrid(i, j, rows, cols) && matrix[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            count = 1 + visitOnes(i + 1, j, matrix, visited, rows, cols)
                      + visitOnes(i - 1, j, matrix, visited, rows, cols)
                      + visitOnes(i, j + 1, matrix, visited, rows, cols)
                      + visitOnes(i, j - 1, matrix, visited, rows, cols);
        }
        return count;
    }

    private static boolean inGrid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}