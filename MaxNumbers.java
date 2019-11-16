import java.util.Arrays;
import java.util.Random;

/**
 * MaxNumbers
 */
public class MaxNumbers {

    private static int[] find2Max(int[] nums) {
        int[] result = new int[2];
        int max1 = 0;
        int max2 = 0;
        int last = nums.length - 1;
        //System.out.println();
        for (int i = 0; i <= last; i++) {
            int curr = nums[i];
            if (curr > max1){
                max2 = max1;
                max1 = curr;
            } else {
                max2 = Math.max(max2, curr);
            }
            //System.out.printf("%d [%d,%d] ; ", curr, max1, max2);
        }
        //System.out.println();

        result[0] = max1;
        result[1] = max2;
        return result;
    }
    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            int N = getRandomIntegerWithinRange(2, 10);
            int[] nums = getNums(N, 100);
            System.out.print(Arrays.toString(nums));
            int[] result = find2Max(nums);
            System.out.printf(" -> %s \n", Arrays.toString(result));
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

    private static int getRandomIntegerWithinRange(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }

}