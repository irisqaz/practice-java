import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * GenerateNumbers
 */
public class GenerateLongs {

    public static void main(String[] args) {
        Random rand = new Random();
        int N = rand.nextInt(7);
        long size = 10000000000000L;
        long[] nums = getNums(N, size);
        System.out.printf("\nAn array of %d numbers %s \n\n", N, Arrays.toString(nums));
    }

    private static long[] getNums(int length, long size) {
        // return an array of integers with values
        // between 0 and size
        long[] nums = new long[length];

        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            nums[i] = rand.nextLong(size);
        }
        
        return nums;
    }
}