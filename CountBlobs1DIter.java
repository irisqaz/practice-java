import java.util.Arrays;

/**
 * Count Blobs iteratively in 1D array
 */
public class CountBlobs1DIter {

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

        // detect blog by visiting ones and count
        int count = 0;
        for (int j = i; j < length && arr[j] == 1 && !visited[j]; j++) {
            visited[j] = true;
            count++;
        }

        if (count > 0){
            isBlob = true;
        }

        return isBlob;
    }
}