import java.util.Arrays;
import java.util.Random;

/**
 * Multiply
 */
public class Multiply {

    // multiply returns the product of two numbers
    // x and y
    // 2 * 4 -> 8
    private static int multiply(int x, int y) {
        int res = 1;
        return res;
    }

    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            // int N = getInt(0, 6);
            int N = 2;
            int[] nums = getNums(N, 10);
            // String padded = String.format("%1$25s", Arrays.toString(nums));
            System.out.printf("%5d * %d", nums[0], nums[1]);

            int result = multiply(nums[0], nums[1]);
            int soln = solution(nums[0], nums[1]);

            System.out.printf(" -> %-5d ", result);
            if (result != soln) {
                System.out.printf(" X expected: %d ", soln);
            } else {
                System.out.print(" correct");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[] getNums(int length, int size) {
        // return an array of integers with values
        // between length and size
        int[] nums = new int[length];

        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = rand.nextInt(size);
        }

        return nums;
    }

    private static int solution(int x, int y) {
        int res = 0;

        // repeat y times
        for (int i = 1; i <= y; i++){
            res = res + x;
        }

        return res;
    }

}