import java.util.Scanner;
import java.util.TreeSet;

public class treeset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> uniqueNumbers = new TreeSet<>();

        System.out.println("Enter numbers (enter 'done' to finish):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                uniqueNumbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'done'.");
            }
        }

        System.out.println("Unique numbers in ascending order:");
        for (int number : uniqueNumbers) {
            System.out.println(number);
        }

        scanner.close();
    }
}
