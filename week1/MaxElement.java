import java.util.Scanner;

public class MaxElement {

    public static int findMax(int[] arr) {
        int max = arr[0];   // assume first element is max

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = findMax(arr);

        System.out.println("Maximum element is: " + max);

        sc.close();
    }
}

    
