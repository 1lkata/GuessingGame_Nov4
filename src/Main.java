import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = (int)(Math.random() * 100 + 1);
        System.out.println("""
                Hello to the Improved Guessing Game!
                You have to input a number between 1 and 100
                and will receive feedback on your answer.
                You can press H for a hint or type 'quit' to exit.
                """);

        int attempts = 1;
        int hints = 3;
        while (true) {
            System.out.print("Attempt " + attempts++ + ": ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("H")) {
                switch (hints) {
                    case 3:
                        if (n <= 50) {
                            System.out.println("Hint: The number is 50 or less.");
                        } else {
                            System.out.println("Hint: The number is greater than 50.");
                        }
                        attempts--;
                        hints--;
                        continue;
                    case 2:
                        if(n%2==0){
                            System.out.println("Hint: The number is even.");
                        } else {
                            System.out.println("Hint: The number is odd.");
                        }
                        if(n%3==0){
                            System.out.println("Hint: The number is divisible by 3.");
                        } else{
                            System.out.println("Hint: The number is not divisible by 3.");
                        }
                        if(n%5==0){
                            System.out.println("Hint: The number is divisible by 5.");
                        } else{
                            System.out.println("Hint: The number is not divisible by 5.");
                        }
                        attempts--;
                        hints--;
                        continue;
                    case 1:
                        if (n >= 10) {
                            int firstDigit = n;
                            while (firstDigit >= 10) {
                                firstDigit /= 10;
                            }
                            System.out.println("Hint: The first digit of the number is " + firstDigit + ".");
                        } else {
                            System.out.println("Hint: The number is under 10.");
                        }
                        attempts--;
                        hints--;
                        continue;
                    case 0: System.out.println("You ran out of hints!"); continue;
                }
            }

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("You have exited the game. \n The correct number is "+n+".\n Goodbye!");
                break;
            }

            try {
                int guess = Integer.parseInt(input);

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess == n) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    break;
                } else if (guess < n) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number, 'H' for a hint, or 'quit' to exit.");
                attempts--;
            }
        }
    }
}
