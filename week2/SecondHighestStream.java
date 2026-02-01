import java.util.*;
import java.util.stream.*;

public class SecondHighestStream {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int result = list.stream()
                .distinct()                          // remove duplicates
                .sorted(Collections.reverseOrder())   // descending order
                .skip(1)                             // skip highest
                .findFirst()                          // second highest
                .orElse(-1);                          // if not present

        System.out.println(result);

        sc.close();
    }
}
