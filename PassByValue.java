/**
 * PassByValue
 */
public class PassByValue {

    public static void main(String[] args) {
        int a = 25;
        int b = a;
        b = 3;
        System.out.printf("a = %d, b = %d \n", a, b);
    }
}