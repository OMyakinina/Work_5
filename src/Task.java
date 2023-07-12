import java.util.*;

public class Task {
    public static void TelBook() {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        addEntry(phoneBook, "Ольга", "1234567890");
        addEntry(phoneBook, "Андрей", "9876543210");
        addEntry(phoneBook, "Ольга", "5555555555");
        addEntry(phoneBook, "Тимур", "1111111111");
        addEntry(phoneBook, "Андрей", "2222222222");
        addEntry(phoneBook, "Тимур", "3333333333");

        printPhoneBook(phoneBook);
    }

    public static void addEntry(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).add(phoneNumber);
    }

    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : entries) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
