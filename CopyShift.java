import java.util.Arrays;
import java.util.Random;

/**
 * CopyShift
 */
public class CopyShift {

    // shift returns a new array
    // with the elements from nums
    // shifted one position to the right
    // if available
    // [2, 4, 1, 9]
    // | | |
    // V V V
    // [0, 0, 0, 0] -> [0, 2, 4, 1]
    private static int[] shift(int[] nums) {
        int[] res = new int[nums.length];

        return res;
    }

    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            int N = getInt(0, 6);
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

    private static int getInt(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }

    private static int[] solution(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        if (length > 1) {
            int last = nums.length - 1;
            for (int i = last; i >= 1; i--) {
                res[i] = nums[i - 1];
            }
        }
        return res;
    }

}