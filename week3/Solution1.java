import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Event {
    private String name;
    private LocalDate date;

    Event(String name, String dateStr) {
        this.name = name;
        this.date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Event> events = new ArrayList<>();

        // Read events
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            events.add(new Event(parts[0], parts[1]));
        }

        int monthFilter = sc.nextInt(); // month to filter
        sc.close();

        // 1. Sort events chronologically
        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());

        // Print sorted event names
        System.out.println(sortedEvents.stream()
                .map(Event::getName)
                .collect(Collectors.joining(" ")));

        // 2. Earliest event
        Event earliest = sortedEvents.get(0);
        System.out.println(earliest.getName());

        // 3. Latest event
        Event latest = sortedEvents.get(sortedEvents.size() - 1);
        System.out.println(latest.getName());

        // 4. Filter events in a specific month
        List<String> eventsInMonth = sortedEvents.stream()
                .filter(e -> e.getDate().getMonthValue() == monthFilter)
                .map(Event::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", eventsInMonth));
    }
}
