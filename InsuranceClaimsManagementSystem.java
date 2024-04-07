/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.text.ParseException;
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
                    // Implement add claim functionality
                    System.out.println("Adding a new claim:");

                    // Prompt user for claim details
                    System.out.print("Enter claim ID: ");
                    String claimId = scanner.nextLine();
                    System.out.print("Enter claim date (yyyy-MM-dd): ");
                    String claimDateString = scanner.nextLine();
                    Date claimDate = null;
                    try {
                        claimDate = FileManager.dateFormat.parse(claimDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                        break;
                    }
                    System.out.print("Enter insured person: ");
                    String insuredPerson = scanner.nextLine();
                    System.out.print("Enter card number: ");
                    String cardNumber = scanner.nextLine();
                    System.out.print("Enter exam date (yyyy-MM-dd): ");
                    String examDateString = scanner.nextLine();
                    Date examDate = null;
                    try {
                        examDate = FileManager.dateFormat.parse(examDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                        break;
                    }
                    System.out.print("Enter claim amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter status (New/Processing/Done): ");
                    String status = scanner.nextLine();
                    System.out.print("Enter receiver banking info: ");
                    String receiverBankingInfo = scanner.nextLine();
                    System.out.print("Enter number of documents: ");
                    int numDocuments = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Prompt user for each document
                    List<String> documents = new ArrayList<>();
                    for (int i = 1; i <= numDocuments; i++) {
                        System.out.print("Enter document " + i + ": ");
                        String document = scanner.nextLine();
                        documents.add(document);
                    }

                    // Create the new claim object
                    Claim newClaim = new Claim(claimId, claimDate, insuredPerson, cardNumber,
                            examDate, documents, claimAmount, status, receiverBankingInfo);

                    // Add the claim to the claim process manager
                    claimProcessManager.addClaim(newClaim);
                    System.out.println("Claim added successfully.");
                    break;
                case 2:
                    // Implement update claim functionality
                    System.out.println("Updating a claim:");

                    // Prompt user for claim ID to update
                    System.out.print("Enter claim ID to update: ");
                    String updateClaimId = scanner.nextLine();

                    // Check if the claim ID exists
                    Claim claimToUpdate = claimProcessManager.getClaimById(updateClaimId);
                    if (claimToUpdate != null) {
                        // Prompt user for updated details
                        System.out.print("Enter new claim date (yyyy-MM-dd): ");
                        String newClaimDateString = scanner.nextLine();
                        Date newClaimDate = null;
                        try {
                            newClaimDate = FileManager.dateFormat.parse(newClaimDateString);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                            break;
                        }
                        System.out.print("Enter new insured person: ");
                        String newInsuredPerson = scanner.nextLine();
                        System.out.print("Enter new card number: ");
                        String newCardNumber = scanner.nextLine();
                        System.out.print("Enter new exam date (yyyy-MM-dd): ");
                        String newExamDateString = scanner.nextLine();
                        Date newExamDate = null;
                        try {
                            newExamDate = FileManager.dateFormat.parse(newExamDateString);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                            break;
                        }
                        System.out.print("Enter new claim amount: ");
                        double newClaimAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new status (New/Processing/Done): ");
                        String newStatus = scanner.nextLine();
                        System.out.print("Enter new receiver banking info: ");
                        String newReceiverBankingInfo = scanner.nextLine();
                        System.out.print("Enter new number of documents: ");
                        int newNumDocuments = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        // Prompt user for each new document
                        List<String> newDocuments = new ArrayList<>();
                        for (int i = 1; i <= newNumDocuments; i++) {
                            System.out.print("Enter new document " + i + ": ");
                            String newDocument = scanner.nextLine();
                            newDocuments.add(newDocument);
                        }

                        // Update the claim with new details
                        claimToUpdate = new Claim(claimToUpdate.getId(), newClaimDate, newInsuredPerson, newCardNumber,
                                newExamDate, newDocuments, newClaimAmount, newStatus, newReceiverBankingInfo);
                        claimProcessManager.updateClaim(claimToUpdate);
                        System.out.println("Claim updated successfully.");
                    } else {
                        System.out.println("Claim with ID " + updateClaimId + " does not exist.");
                    }
                    break;
                case 3:
                    // Implement delete claim functionality
                    System.out.println("Deleting a claim:");

                    // Prompt user for claim ID to delete
                    System.out.print("Enter claim ID to delete: ");
                    String deleteClaimId = scanner.nextLine();

                    // Check if the claim ID exists
                    Claim claimToDelete = claimProcessManager.getClaimById(deleteClaimId);
                    if (claimToDelete != null) {
                        // Delete the claim
                        claimProcessManager.deleteClaim(deleteClaimId);
                        System.out.println("Claim with ID " + deleteClaimId + " deleted successfully.");
                    } else {
                        System.out.println("Claim with ID " + deleteClaimId + " does not exist.");
                    }
                    break;
                case 4:
                case 5:
                case 6:
            }
        }while (choice != 6);
        scanner.close();
    }
}