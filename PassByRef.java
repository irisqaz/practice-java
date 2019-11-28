import java.util.Arrays;

/**
 * PassByRef
 */
public class PassByRef {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = a;
        b[1] = 7;
        System.out.printf("a = %s, b = %s \n", a, b);
        System.out.printf("a = %s, b = %s \n", Arrays.toString(a), Arrays.toString(b));
    }
}