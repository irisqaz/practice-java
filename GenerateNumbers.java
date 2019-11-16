import java.util.Arrays;
import java.util.Random;

/**
 * GenerateNumbers
 */
public class GenerateNumbers {

    public static void main(String[] args) {
        Random rand = new Random();
        int N = rand.nextInt(10);
        int size = rand.nextInt(100);
        int[] nums = getNums(N, size);
        System.out.printf("\nAn array of %d numbers %s \n\n", N, Arrays.toString(nums));
    }

    private static int[] getNums(int length, int size) {
        // return an array of integers with values
        // between 0 and size
        int[] nums = new int[length];

        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = rand.nextInt(size);
        }
        
        return nums;
    }
}