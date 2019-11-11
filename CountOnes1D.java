import java.util.Arrays;

/**
 * Count Ones in 1D array
 */
public class CountOnes1D {

    public static void main(String[] args) {

        int[] arr = { 1, 0, 1, 1, 1, 0, 1 };
        // int[] arr = {};
        System.out.println();
        System.out.print(Arrays.toString(arr));

        int count = onesCount(arr, arr.length);
        System.out.printf(" -> %d \n\n", count);
    }

    static int onesCount(int arr[], int length) {

        int count = 0;

        for (int i = 0; i < length; i++) {
            
            if (isOne(arr[i])) {
                count++;
            }
        }

        return count;
    }

    private static boolean isOne(int i) {
        boolean isOne = false;

        if ( i == 1){
            isOne = true;
        }
        
        return isOne;
    }
}