import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Neighbors1
 */
public class Neighbors1 {

    static int[] neighbors(int[] arr, int i) {
        List<Integer> result = new ArrayList<Integer>();

        if (isIndex(arr, i)) {
            if (isIndex(arr, i - 1)) {
                result.add(i - 1);
            }
            if (isIndex(arr, i + 1)) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 5, 8, 22 };
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int[] r = neighbors(arr, i);
            System.out.printf("index %d : neighbors %s \n", i, Arrays.toString(r));
        }
        for (int i : new int[] { -1, arr.length }) {
            int[] r = neighbors(arr, i);
            System.out.printf("index %d : neighbors %s \n", i, Arrays.toString(r));
        }

        arr = new int[] {};
        System.out.println(Arrays.toString(arr));
        for (int i : new int[] { -1, 0, 4 }) {
            int[] r = neighbors(arr, i);
            System.out.printf("index %d : neighbors %s \n", i, Arrays.toString(r));
        }
    }

    static boolean isIndex(int[] arr, int i) {

        return i >= 0 && i < arr.length;
    }
}