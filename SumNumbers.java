import java.util.Arrays;
import java.util.Random;

/**
 * SumNumbers
 */
public class SumNumbers {

    // SumN returns the sum in nums.
    // nums is at least length 0
    private static int SumN(int[] nums) {
        int sum = 0;
        
        return sum;
    }
    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            int N = getInt(0, 8);
            int[] nums = getNums(N, 100);
            String padded = String.format("%1$40s", Arrays.toString(nums));
            System.out.print(padded);

            int result = SumN(nums);
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
        int sum = 0;
        
        int last = nums.length -1;
        for (int i = 0; i <= last; i++) {
            sum = sum + nums[i];
        }

        return sum;
    }
 
}