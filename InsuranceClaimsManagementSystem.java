/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class InsuranceClaimsManagementSystem {
    public static void main(String[] args) {
        // Read data from files
        List<Customer> customers = FileManager.readCustomersFromFile();
        List<Claim> claims = FileManager.readClaimsFromFile();

        // Initialize ClaimProcessManagerImpl with loaded claims
        ClaimProcessManagerImpl claimProcessManager = new ClaimProcessManagerImpl(claims);

        // Implement the text-based UI for interaction
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Insurance Claims Management System");
            System.out.println("1. Add a new claim");
            System.out.println("2. Update a claim");
            System.out.println("3. Delete a claim");
            System.out.println("4. View a claim");
            System.out.println("5. View all claims");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
            }
        }while (choice != 6);
        scanner.close();
    }
}