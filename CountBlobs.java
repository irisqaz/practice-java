/**
 * CountBlobs
 */
public class CountBlobs {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0, 1, 0 }, 
                           { 0, 1, 0, 1, 0 }, 
                           { 0, 1, 1, 1, 0 }, 
                           { 0, 0, 0, 0, 0 },
                           { 1, 0, 0, 0, 1 }, 
                           { 0, 0, 1, 1, 1 } };

        int count = blobCount(matrix, matrix.length, matrix[0].length);
        System.out.printf("\ncount is %d \n\n", count);
    }

    static int blobCount(int matrix[][], int rowCount, int colCount) {
        int visited[][] = new int[rowCount][colCount]; // all initialized to false

        int count = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 1 && visited[i][j] == 0) // unvisited black cell
                {
                    markVisited(i, j, matrix, visited, rowCount, colCount);
                    count++;
                }
            }
        }

        return count;
    }

    static int markVisited(int i, int j, int[][] matrix, int[][] visited, int rowCount, int colCount) {
        if (i < 0 || j < 0)
            return 0;

        if (i >= rowCount || j >= colCount)
            return 0;

        if (visited[i][j] == 1) // already visited
            return 1;

        if (matrix[i][j] == 0) // not a black cell
            return 0;

        visited[i][j] = 1;

        // recursively mark all the 4 adjacent cells - right, left, up and down
        return markVisited(i + 1, j, matrix, visited, rowCount, colCount)
                + markVisited(i - 1, j, matrix, visited, rowCount, colCount)
                + markVisited(i, j + 1, matrix, visited, rowCount, colCount)
                + markVisited(i, j - 1, matrix, visited, rowCount, colCount);
    }
}