import java.time.LocalDate;
import java.util.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();

        // Read events
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate date = LocalDate.parse(dateStr);
            events.add(new Event(name, date));
        }

        // Read month
        int month = sc.nextInt();

        // 1. Sort events by date
        Collections.sort(events, Comparator.comparing(e -> e.date));

        // Print sorted events
        for (Event e : events) {
            System.out.print(e.name + " ");
        }
        System.out.println();

        // 2. Earliest event
        System.out.println(events.get(0).name);

        // 3. Latest event
        System.out.println(events.get(events.size() - 1).name);

        // 4. Events in given month
        for (Event e : events) {
            if (e.date.getMonthValue() == month) {
                System.out.print(e.name + " ");
            }
        }
    }
}
