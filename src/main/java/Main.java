import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FusionCalculator calculator = new FusionCalculator();
            PersonaSearch search = new PersonaSearch();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Welcome!");
                System.out.println("\n" +
                                    "1. Find Persona\n" +
                                    "2. Fuse Persona\n");
                int option = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                if (option == 1) {
                    System.out.print("Enter persona (or 'exit' to quit): ");
                    String input = scanner.nextLine();

                    Persona persona = search.find(input);
                    System.out.println();
                    System.out.println( search.getActualName(input) + persona.toString());
                    System.out.println();

                } else if (option == 2) {
                    System.out.print("Enter first persona (or 'exit' to quit): ");
                    String persona1 = scanner.nextLine();

                    if (persona1.equalsIgnoreCase("exit")) {
                        break;
                    }

                    System.out.print("Enter second persona: ");
                    String persona2 = scanner.nextLine();

                    String result = calculator.fuse(persona1, persona2);
                    System.out.println("Fusion result: " + result);
                    System.out.println();
                } else {
                    continue;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error loading data files: " + e.getMessage());
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
