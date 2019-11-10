import java.util.Arrays;

/**
 * BinarySearch
 */
public class BinarySearch {

    private static boolean search2(int[] arr, int value) {
        boolean found = false;
        int last = arr.length - 1;
        int first = 0;
        int mid;
        while (first <= last){
            mid = first + (last - first) / 2;
            //System.out.printf("first: %d, mid: %d, last: %d \n", first, mid, last);
            if (arr[mid] == value){
                found = true;
                break;
            } else if (arr[mid] < value){
                first = mid + 1;
            } else {
                last = mid - 1;
            }
            //System.out.printf("first: %d, last: %d \n", first, last);
        }
        return found;
    }
    public static void main(String[] args) {
        System.out.println();

        int[] arr = new int[]{3, 9, 23, 44, 55};
        int value = 55 ;

        System.out.printf("%s , %d ",Arrays.toString(arr), value);
        System.out.print(" -> ");

        boolean found = search2(arr, value);
        System.out.println(found);


        System.out.println();
    }
    
}