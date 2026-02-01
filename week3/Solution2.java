import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int marks = Integer.parseInt(parts[1]);
            students.add(new Student(name, marks));
        }

        int K = sc.nextInt();
        sc.close();

        // Stream: sort by marks descending, then name ascending, limit K
        List<String> topK = students.stream()
                .sorted(Comparator
                        .comparingInt(Student::getMarks).reversed()
                        .thenComparing(Student::getName))
                .limit(K)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", topK));
    }
}
