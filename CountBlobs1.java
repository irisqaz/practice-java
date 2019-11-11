import java.util.Arrays;

/**
 * CountBlobs in 1D array
 */
public class CountBlobs1 {

    public static void main(String[] args) {

        int[] arr = { 1, 0, 1, 1, 1, 0, 1};
        //int[] arr = {};
        System.out.println();
        System.out.print(Arrays.toString(arr));

        int count = blobCount(arr, arr.length);
        System.out.printf(" -> %d \n\n", count);
    }

    static int blobCount(int matrix[], int length) {
        boolean[] visited = new boolean[length]; // all initialized to false

        int blobs = 0;

        for (int i = 0; i < length; i++) {
                if (matrix[i] == 1 && !visited[i]) // a new blob
                {
                    blobs++;
                    visited[i] = true;
                    visitNeighbor(i, matrix, visited, length);
                    //System.out.printf("\nfor %d, neighbors : %d", i, neighbors);
                }
        }

        return blobs;
    }

    static int visitNeighbor(int i, int[] matrix, boolean[] visited, int rowCount) {

        int neighbors = 0;
        int next = i + 1; // next neighbor to the right
        if (isIndex(next, rowCount) && matrix[next] == 1 && !visited[next]){
            visited[next] = true;
            neighbors++;
            // recursively visit all the adjacent neighbors to the right
            neighbors = neighbors + visitNeighbor(i + 1, matrix, visited, rowCount);
        }
        return neighbors;
    }

    private static boolean isIndex(int i, int rowCount) {
        return i >= 0 && i < rowCount ;
    }
}