import java.util.Arrays;
import java.util.Random;

/**
 * Swap
 */
public class Swap {

    private static int[] shift(int[] nums) {

        return nums;
    }

    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            //int N = getInt(0, 6);
            int N = 2;
            int[] nums = getNums(N, 100);
            // String padded = String.format("%1$25s", Arrays.toString(nums));
            System.out.printf("%25s", Arrays.toString(nums));

            int[] result = shift(nums);
            int[] soln = solution(nums);

            System.out.printf(" -> %-25s ", Arrays.toString(result));
            if (!Arrays.equals(result, soln)) {
                System.out.printf(" X expected: %s ", Arrays.toString(soln));
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

    private static int[] solution(int[] nums) {
        // make a copy to avoid changing nums
        // needed to make the test comparison work
        int[] result = Arrays.copyOf(nums, nums.length);
        int temp = result[0];
        result[0] = result[1];
        result[1] = temp;
        return result;
    }

}