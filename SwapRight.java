import java.util.Arrays;
import java.util.Random;

/**
 * SwapRight
 */
public class SwapRight {

    // swalR returns the same array nums
    // shifted one position to the right
    // because nums is length 2, it is
    // a swap
    // [2, 4] -> [4, 2]
    private static int[] swalR(int[] nums) {

        return nums;
    }

    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            // int N = getInt(0, 6);
            int N = 2;
            int[] nums = getNums(N, 100);
            // String padded = String.format("%1$25s", Arrays.toString(nums));
            System.out.printf("%25s", Arrays.toString(nums));

            int[] copy = Arrays.copyOf(nums, nums.length);
            int[] result = swalR(copy);
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
        int temp = nums[1];
        {
            nums[1] = nums[0];
        }
        nums[0] = temp;
        return nums;
    }

}