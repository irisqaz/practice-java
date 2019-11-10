/**
 * CountBlobs
 */
public class CountBlobs1 {

    public static void main(String[] args) {
        int[] matrix = { 1, 1, 0, 1, 0 ,1, 1}; 

        int count = blobCount(matrix, matrix.length);
        System.out.printf("\ncount is %d \n\n", count);
    }

    static int blobCount(int matrix[], int rowCount) {
        int visited[] = new int[rowCount]; // all initialized to false

        int count = 0;

        for (int i = 0; i < rowCount; i++) {
                if (matrix[i] == 1 && visited[i] == 0) // unvisited black cell
                {
                    count++;
                    int visits = markVisited(i, matrix, visited, rowCount);
                    System.out.printf("for %d, visited : %d \n", i, visits);
                }
        }

        return count;
    }

    static int markVisited(int i, int[] matrix, int[] visited, int rowCount) {
        if (!isIndex(i,rowCount) || matrix[i] == 0 || visited[i] == 1){
            return 0;
        }

        //if (i >= rowCount)
        //    return 0;

        //if (visited[i] == 1) // already visited
        //    return 1;

        //if (matrix[i] == 0) // not a black cell
        //    return 0;

        visited[i] = 1;
        int count = 1;
        // recursively mark all the 4 adjacent cells - right, left, up and down
        return count + markVisited(i + 1, matrix, visited, rowCount);
                //+ markVisited(i - 1, matrix, visited, rowCount);
    }

    private static boolean isIndex(int i, int rowCount) {
        return i >= 0 && i < rowCount ;
    }
}