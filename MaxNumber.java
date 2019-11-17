import java.util.Arrays;
import java.util.Random;

/**
 * MaxNumber
 */
public class MaxNumber {

    // findMax returns the largest value
    // in nums.  nums is at least length 1
    private static int findMax(int[] nums) {
        int res = 0;
        
        return res;
    }
    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            int N = getInt(1, 8);
            int[] nums = getNums(N, 100);
            String padded = String.format("%1$40s", Arrays.toString(nums));
            System.out.print(padded);

            int result = findMax(nums);
            int soln = solution(nums);

            System.out.printf(" -> %s ", result);
            if (result != soln){
                System.out.printf(" X expected: %s ", soln);
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
    private static int solution(int[] nums) {
        int result = 0;
        
        int last = nums.length -1;
        for (int i = 0; i <= last; i++) {
            result = Math.max(result, nums[i]);
        }

        return result;
    }
 
}