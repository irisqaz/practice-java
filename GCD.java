import java.util.Random;

/**
 * MaxNumbers
 */
public class GCD {

    private static int gcd(int a, int b) {
        // gcd is a when b is 0
        // otherwise continue to find it
        // int result = 0; // default when b == 0
        
        // if(b == 0){
        //     return a;
        // }

        // int r = a % b;
        // return gcd(b, r);
        
        // int result = a; //b = 0
        
        // if (b != 0){
        //     int r = a % b;
        //     result = gcd(b, r);
        // }

        // return result;

        int result = a; // b = 0

        while (b != 0){
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
            int min = 0;
            int max = Integer.MAX_VALUE - 1 - min;

            int a = getInteger(min, max);
            int b = getInteger(min, max);            
            String ab = String.format("(%d,%d)", a, b);
            System.out.printf("%25s",ab);
            //System.out.printf("(%d,%d)", a, b);

            int result1 = gcd(a, b);
            int result2 = gcdIter(a, b);

            System.out.printf("  -> %2d ", result1);
            if (result1 != result2){
                System.out.printf(" X expected: %s ", result2);
            } else {
                System.out.print(" correct");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getInteger(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
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

}