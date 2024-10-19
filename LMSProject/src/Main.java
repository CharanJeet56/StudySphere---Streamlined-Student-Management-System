import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LearningManagementSystem lms = new LearningManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Display Students (Anyone can see)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String regName = scanner.nextLine();  // Use nextLine for full name input
                    System.out.print("Enter email: ");
                    String regEmail = scanner.nextLine();  // Use nextLine for email
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();  // Use nextLine for password
                    lms.registerUser(regName, regEmail, regPassword);
                    break;
                case 2:
                    System.out.print("Enter email: ");
                    String loginEmail = scanner.nextLine();  // Use nextLine for email
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();  // Use nextLine for password
                    if (lms.loginUser(loginEmail, loginPassword)) {
                        System.out.println("Login successful! Hi, " + lms.getLoggedInUser() + "!");
                        int userChoice;
                        do {
                            System.out.println("1. Add Student");
                            System.out.println("2. Display Students");
                            System.out.println("3. Update Student");
                            System.out.println("4. Delete Student");
                            System.out.println("5. Exit");
                            System.out.print("Enter your choice: ");
                            userChoice = scanner.nextInt();
                            scanner.nextLine();  // Consume the newline character

                            switch (userChoice) {
                                case 1:
                                    System.out.print("Enter student name: ");
                                    String name = scanner.nextLine();  // Use nextLine for student name
                                    System.out.print("Enter student email: ");
                                    String email = scanner.nextLine();  // Use nextLine for student email
                                    lms.addStudent(name, email);
                                    break;
                                case 2:
                                    lms.displayStudents();
                                    break;
                                case 3:
                                    System.out.print("Enter student ID to update: ");
                                    int idToUpdate = scanner.nextInt();
                                    scanner.nextLine();  // Consume the newline character
                                    System.out.print("Enter new name: ");
                                    String newName = scanner.nextLine();  // Use nextLine for new name
                                    System.out.print("Enter new email: ");
                                    String newEmail = scanner.nextLine();  // Use nextLine for new email
                                    lms.updateStudent(idToUpdate, newName, newEmail);
                                    break;
                                case 4:
                                    System.out.print("Enter student ID to delete: ");
                                    int idToDelete = scanner.nextInt();
                                    scanner.nextLine();  // Consume the newline character
                                    lms.deleteStudent(idToDelete);
                                    break;
                                case 5:
                                    System.out.println("Exiting...");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } while (userChoice != 5);
                    } else {
                        System.out.println("Login failed! Invalid email or password.");
                    }
                    break;
                case 3:
                    lms.displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
