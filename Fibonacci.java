import java.util.Random;

/**
 * MaxNumbers
 */
public class Fibonacci {

    private static long fib(int n) {
        // when n < 2
        // fib(0) is 0
        // fib(1) is 1
        // when n >= 2
        // fib(2) is fib(1) + fib(0)
        //   ^         ^        ^
        //   |         |        |
        // fib(3) is fib(2) + fib(1)
        // fib(4) is fib(3) + fib(2)
        // . . .
        long[] fib = new long[3];

        fib[0] = 0;
        fib[1] = 1;
        if (n < 2){
            return fib[n];
        }
        //System.out.print(" [");
        for (int i = 2; i <= n; i++) {
            fib[2] = fib[1] + fib[0];
            //System.out.printf(", %d", fib[2]);
            fib[0] = fib[1];
            fib[1] = fib[2];
        }
        //System.out.print("]");
        return fib[2];
    }
    public static void main(String[] args) {

        System.out.println();
        for (int i = 0; i < 5; i++) {

            int n = getRandomIntegerWithinRange(0, 100);
            System.out.print(n);
            long result = fib(n);
            System.out.printf("  -> %d \n", result);
        }
        System.out.println();
    }

    private static int getRandomIntegerWithinRange(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }

}