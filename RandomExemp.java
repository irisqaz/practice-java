import java.util.Random;

/**
 * Random
 */
public class RandomExemp {

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int num = rand.nextInt(10);
            System.out.printf("Number between 0 and 9: %d \n", num);
            // Random Integer between Range not starting from 0
            int randomIntegerRange = getRandomIntegerWithinRange(10, 20);
            System.out.printf("number between 10 and 20 : %d \n\n", randomIntegerRange);
        }
    }

    private static int getRandomIntegerWithinRange(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }
}