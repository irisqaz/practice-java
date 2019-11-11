import java.util.Arrays;

/**
 * Count Blobs in 1D array
 */
public class CountBlobs1D {

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

        if (arr[i] == 1 && !visited[i]){
            isBlob = true;
            visited[i] = true;
            // visit rest of blob
            for (int j = i + 1; j < length && arr[j] == 1; j++){
                visited[j] = true;
            }
        }
        return isBlob;
    }
}