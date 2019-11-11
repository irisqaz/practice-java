import java.util.Arrays;

/**
 * Count Blobs recursively in 1D array
 */
public class CountBlobs1DRec {

    public static void main(String[] args) {

        int[] arr = { 1, 0, 1, 1, 1, 0, 1 };
        // int[] arr = {};
        System.out.println();
        System.out.print(Arrays.toString(arr));

        int count = blobsCount(arr, arr.length);
        System.out.printf(" -> %d \n\n", count);
    }

    static int blobsCount(int arr[], int length) {

        boolean[] visited = new boolean[length]; // all default to false
        int count = 0;

        for (int i = 0; i < length; i++) {

            if (isBlob(i, arr, visited, length)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isBlob(int i, int[] arr, boolean[] visited, int length) {
        boolean isBlob = false;

        // detect blog by recursively visiting ones and count
        int count = visitOnes(i, arr, visited, length);

        if (count > 0){
            isBlob = true;
        }
        //System.out.printf("\nat %d, visited %d", i, count);
        return isBlob;
    }

    private static int visitOnes(int i, int[] arr, boolean[] visited, int length) {
        int count = 0;

        if (i < length && arr[i] == 1 && !visited[i]) {
            visited[i] = true;
            count = 1 + visitOnes(i+1, arr, visited, length);
        }
        return count;
    }
}