import java.util.Arrays;
import java.util.Random;

/**
 * ShiftRight
 */
public class ShiftRight {

    // shiftR returns the same array nums
    // shifted one position to the right
    // because the last element is moved
    // to the beginning, it is a rotation
    // [2, 4, 1, 9] -> [9, 2, 4, 1]
    private static int[] shiftR(int[] nums) {

        return nums;
    }

    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            int N = getInt(0, 6);
            int[] nums = getNums(N, 100);
            // String padded = String.format("%1$25s", Arrays.toString(nums));
            System.out.printf("%25s", Arrays.toString(nums));

            int[] copy1 = Arrays.copyOf(nums, nums.length);
            int[] result = shiftR(copy1);
            int[] copy2 = Arrays.copyOf(nums, nums.length);
            int[] soln = solution(copy2);

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

        if (length > 1) {
            int last = length - 1;
            int temp = nums[last];

            for (int i = last-1; i >= 0; i--) {
                nums[i+1] = nums[i];
            }

            nums[0] = temp;
        }
        return nums;
    }

}