import java.util.*;
import java.util.Scanner;

@FunctionalInterface
interface PerformOperation {
    boolean check(int num);
}

public class LambdaTask {

    // Lambda to check if a number is odd
    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    // Lambda to check if a number is prime
    public static PerformOperation isPrime() {
        return n -> {
            if (n <= 1)
                return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
    }

    // Lambda to check if a number is palindrome
    public static PerformOperation isPalindrome() {
        return n -> {
            String s = Integer.toString(n);
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - 1 - i))
                    return false;
            }
            return true;
        };
    }

    // Method to apply operation and print result
    public static String checkNumber(PerformOperation op, int num, int type) {
        boolean result = op.check(num);
        switch (type) {
            case 1:
                return result ? "ODD" : "EVEN";
            case 2:
                return result ? "PRIME" : "COMPOSITE";
            case 3:
                return result ? "PALINDROME" : "NOT PALINDROME";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases

        for (int i = 0; i < t; i++) {
            int type = sc.nextInt(); // 1 = odd/even, 2 = prime, 3 = palindrome
            int num = sc.nextInt();

            PerformOperation op;

            if (type == 1)
                op = isOdd();
            else if (type == 2)
                op = isPrime();
            else
                op = isPalindrome();

            System.out.println(checkNumber(op, num, type));
        }

        sc.close();
    }
}
