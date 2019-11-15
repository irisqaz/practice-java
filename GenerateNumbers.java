import java.util.Arrays;
import java.util.Random;

/**
 * GenerateNumbers
 */
public class GenerateNumbers {

    public static void main(String[] args) {
        int N = 10;
        int size = 1000;
        int[] nums = getNums(N, size);
        System.out.printf("\nAn array of %d numbers %s \n\n", N, Arrays.toString(nums));
    }

    private static int[] getNums(int length, int size) {
        // return an array of integers with values
        // between 2 and N
        int[] nums = new int[length];

        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = rand.nextInt(size);
        }
        
        return nums;
    }
}