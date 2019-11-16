import java.util.Random;

/**
 * MaxNumbers
 */
public class EuclGCD {

    private static int gcd(int a, int b) {
        // gcd is a when b is 0
        // otherwise continue to find it

        int result = a; // default when b == 0
        if (b != 0){
            // re-compute result until remainder is 0
            int r = a % b;
            result = gcd(b, r);
        }
        return result;
    }
    private static int gcdIter(int a, int b) {
        // gcd is a when b is 0
        // otherwise continue to find it

        int result = a; // default when b == 0
        for ( ; b != 0; ){ // while (b != 0){
            // re-compute result when remainder is 0
            int r = a % b;
            a = b;
            b = r;
            result = a;
        }
        return result;
    }
    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            int a = getInteger(0, 100);
            int b = getInteger(0, 100);
            System.out.printf("(%d,%d)", a, b);
            int result1 = gcd(a, b);
            int result2 = gcdIter(a, b);
            System.out.printf("  -> rec: %d , iter: %d \n", result1, result2);
        }
        System.out.println();
    }

    private static int getInteger(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }

}