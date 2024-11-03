import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate a random number between 1 and 100
        int n = (int)(Math.random() * 100 + 1);

        // Welcome message with instructions for the user
        System.out.println("""
                Hello to the Improved Guessing Game!
                You have to input a number between 1 and 100
                and will receive feedback on your answer.
                You can press H for a hint or type 'quit' to exit.
                """);

        // Track the number of attempts and hints remaining
        int attempts = 1;
        int hints = 3; // The user starts with 3 hints

        // Start the game loop
        while (true) {
            System.out.print("Attempt " + attempts++ + ": ");
            String input = scanner.nextLine().trim(); // Get user input and trim whitespace

            // Check if the user requested a hint by typing 'H'
            if (input.equalsIgnoreCase("H")) {
                switch (hints) {
                    case 3:
                        // First hint: tell if the number is 50 or less, or greater than 50
                        if (n <= 50) {
                            System.out.println("Hint: The number is 50 or less.");
                        } else {
                            System.out.println("Hint: The number is greater than 50.");
                        }
                        attempts--; // Don't count hints as an attempt
                        hints--; // Decrease the number of available hints
                        continue; // Skip the rest of the loop and ask for input again

                    case 2:
                        // Second hint: check if the number is even/odd, divisible by 3 or 5
                        if(n % 2 == 0) {
                            System.out.println("Hint: The number is even.");
                        } else {
                            System.out.println("Hint: The number is odd.");
                        }
                        if(n % 3 == 0) {
                            System.out.println("Hint: The number is divisible by 3.");
                        } else {
                            System.out.println("Hint: The number is not divisible by 3.");
                        }
                        if(n % 5 == 0) {
                            System.out.println("Hint: The number is divisible by 5.");
                        } else {
                            System.out.println("Hint: The number is not divisible by 5.");
                        }
                        attempts--; // Don't count hints as an attempt
                        hints--; // Decrease the number of available hints
                        continue; // Skip the rest of the loop and ask for input again

                    case 1:
                        // Third hint: if the number is greater than or equal to 10, show its first digit
                        if (n >= 10) {
                            int firstDigit = n;
                            // Extract the first digit of the number
                            while (firstDigit >= 10) {
                                firstDigit /= 10;
                            }
                            System.out.println("Hint: The first digit of the number is " + firstDigit + ".");
                        } else {
                            // If the number is below 10, simply state that
                            System.out.println("Hint: The number is under 10.");
                        }
                        attempts--; // Don't count hints as an attempt
                        hints--; // Decrease the number of available hints
                        continue; // Skip the rest of the loop and ask for input again

                    case 0:
                        // If no hints are left, notify the user
                        System.out.println("You ran out of hints!");
                        continue; // Skip the rest of the loop and ask for input again
                }
            }

            // Check if the user decided to quit the game
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("You have exited the game. \n The correct number is " + n + ".\n Goodbye!");
                break; // Exit the game loop
            }

            try {
                // Attempt to parse the user's input into an integer
                int guess = Integer.parseInt(input);

                // Check if the guess is within the valid range (1 to 100)
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue; // Skip the rest of the loop and ask for input again
                }

                // Check if the guess is correct
                if (guess == n) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    break; // Exit the loop if the guess is correct
                } else if (guess < n) {
                    // If the guess is lower than the number, give feedback
                    System.out.println("Too low!");
                } else {
                    // If the guess is higher than the number, give feedback
                    System.out.println("Too high!");
                }

            } catch (NumberFormatException e) {
                // Handle invalid input (non-numeric input) and give feedback
                System.out.println("Invalid input. Please enter a valid number, 'H' for a hint, or 'quit' to exit.");
                attempts--; // Don't count invalid input as an attempt
            }
        }
    }
}
