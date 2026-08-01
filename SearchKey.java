import java.util.Arrays;
import java.util.Scanner;
public class SearchKey {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.print("Enter the key element: ");
            int key = scanner.nextInt();
            Arrays.sort(arr);
            int idx = BinarySearch.binarySearch(arr, key);
            if (idx >= 0) {
                System.out.println("Key element is present in the list.");
            } else {
                System.out.println("Key element is not present in the list.");
            }
        }
    }
}