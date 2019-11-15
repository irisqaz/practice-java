import java.util.Random;

/**
 * Random
 */
public class RandomExemp {

    public static void main(String[] args) {
        // Random Integer between Range not starting from 0
        int randomIntegerRange = getRandomIntegerWithinRange(10, 20);
        System.out.println("randomIntegerRange: " + randomIntegerRange);
    }

    private static int getRandomIntegerWithinRange(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }
}