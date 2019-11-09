/**
 * CountBlobs
 */
public class CountBlobs2 {

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
                    count++;
                    //markVisited(visited, i, j);
                    int countVisits = markBlob(i, j, matrix, visited, rowCount, colCount);
                    System.out.printf("visits for %d,%d : %d \n", i, j, countVisits);
                }
            }
        }

        return count;
    }

    static int markBlob(int i, int j, int[][] matrix, int[][] visited, int rowCount, int colCount) {
        int marks = 0;
        visited[i][j] = 1;

        // recursively mark all the 4 adjacent cells - right, left, up and down
        int row = i+1;
        int col = j;
        if (inGrid(row, rowCount) && matrix[row][col] == 1){
            marks = marks + markBlob(row, col, matrix, visited, rowCount, colCount);
        }
        row = i - 1;
        col = j;
        if (inGrid(row, rowCount) && matrix[row][col] == 1){
            marks = marks + markBlob(row, col, matrix, visited, rowCount, colCount);
        }
        row = i;
        col = j + 1;
        if (inGrid(col, colCount) && matrix[row][col] == 1){
            marks = marks + markBlob(row, col, matrix, visited, rowCount, colCount);
        }
        row = i;
        col = j - 1;
        if (inGrid(col, colCount) && matrix[row][col] == 1){
            marks = marks + markBlob(row, col, matrix, visited, rowCount, colCount);
        }
        /*
        return markBlob(i + 1, j, matrix, visited, rowCount, colCount)
                + markBlob(i - 1, j, matrix, visited, rowCount, colCount)
                + markBlob(i, j + 1, matrix, visited, rowCount, colCount)
                + markBlob(i, j - 1, matrix, visited, rowCount, colCount);
        */
        return marks;
    }

    private static boolean inGrid(int row, int rowCount) {
        return row >= 0 && row < rowCount;
    }

    private static void markVisited(int[][] visited, int i, int j) {
        visited[i][j] = 1;
    }

}