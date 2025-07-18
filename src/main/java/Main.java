import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FusionCalculator calculator = new FusionCalculator();
            PersonaSearch search = new PersonaSearch();
            Scanner scanner = new Scanner(System.in);

            boolean searchLoop = true;
            boolean fuseLoop = true;

            while (true) {
                System.out.println("Welcome! Enter a number or 'exit' to quit.");
                System.out.println("\n" +
                                    "1. List Persona\n" +
                                    "2. Find Persona\n" +
                                    "3. Fuse Persona\n" +
                                    "4. Quit");
                int option = scanner.nextInt();
                scanner.nextLine();

                System.out.println();


                if (option == 1) {
                    System.out.println("All Persona in the database (so far):");

                    Map<String, Persona> allPersonas = search.getAllPersonas();

                    for (String persona : allPersonas.keySet()){
                        System.out.println(persona);
                    }
                    System.out.println();

                    System.out.print("Return to main menu? (y/n): ");
                    String input = scanner.nextLine();

                    if (input.toLowerCase().charAt(0) != 'y') {
                        break;
                    }

                } else if (option == 2) {
                    while (searchLoop) {
                        System.out.print("Enter persona (or 'exit' to quit): ");
                        String input = scanner.nextLine();

                        if (input.equalsIgnoreCase("exit")) {
                            break;
                        }

                        Persona persona = search.find(input);
                        System.out.println();
                        System.out.println( search.getActualName(input) + persona.toString());
                        System.out.println();

                        System.out.print("Search another? (y/n): ");
                        String exit = scanner.nextLine();

                        if (exit.toLowerCase().charAt(0) != 'y') {
                            searchLoop = false;
                        }
                    }

                } else if (option == 3) {
                    while(fuseLoop) {
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

                        System.out.print("Fuse another? (y/n): ");
                        String exit = scanner.nextLine();

                        if (exit.toLowerCase().charAt(0) != 'y') {
                            fuseLoop = false;
                        }
                    }
                } else if (option == 4) {
                    System.out.println("Goodbye");
                    break;
                } else {
                    continue;
                }
            }
            //scanner.close();
        } catch (IOException e) {
            System.err.println("Error loading data files: " + e.getMessage());
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
