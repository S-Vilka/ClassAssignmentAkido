import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AikidoTrainer aikidoTrainer;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your name: ");
            String playerName = sc.nextLine().trim();
            if (!playerName.isEmpty()) {
                aikidoTrainer = new AikidoTrainer(playerName);
                break;
            }
            System.out.println("Name cannot be empty. Please try again.");
        }

        while (true) {
            System.out.println("\n===== Aikido Practice Tracker =====");
            System.out.println("1. Add Practice Session");
            System.out.println("2. View Total Practice Time");
            System.out.println("3. Check Graduation Eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter session duration (minutes): ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input! Duration must be a number.");
                        sc.next();
                        continue;
                    }
                    int duration = sc.nextInt();
                    sc.nextLine();

                    aikidoTrainer.addSession(LocalDate.now(), duration);
                    System.out.println("Session added successfully!");
                    break;

                case 2:
                    System.out.println("Total sessions: " + aikidoTrainer.getTotalSessions() + " times");
                    System.out.println("Total practice time: " + aikidoTrainer.getTotalTrainingTime() + " minutes");
                    break;

                case 3:
                    if (aikidoTrainer.checkGraduation()) {
                        System.out.println("Congratulations! You are eligible for Kyu graduation.");
                    } else {
                        System.out.println("Not eligible for Kyu graduation yet. Keep training!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Aikido Practice Tracker. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}