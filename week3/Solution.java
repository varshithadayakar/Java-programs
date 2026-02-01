import java.util.*;
import java.util.stream.*;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Static method for filtering by age
    public static boolean isOlderThan(Person p, int ageLimit) {
        return p.getAge() > ageLimit;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();
        sc.close();

        // 1. Sort alphabetically by name
        List<String> sortedNames = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", sortedNames));

        // 2. Filter persons older than ageLimit (static method reference)
        List<String> olderThanLimit = persons.stream()
                .filter(p -> Person.isOlderThan(p, ageLimit))
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", olderThanLimit));

        // 3. Convert all names to uppercase (instance method reference)
        List<String> upperCaseNames = persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", upperCaseNames));
    }
}
