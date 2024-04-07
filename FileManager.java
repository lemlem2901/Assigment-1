/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class FileManager {
    // File names
    private static final String CUSTOMERS_FILE = "customers.txt";
    private static final String INSURANCE_CARDS_FILE = "insurance_cards.txt";
    private static final String CLAIMS_FILE = "claims.txt";

    // Date format for parsing dates
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Read customers from file
    public static List<Customer> readCustomersFromFile() {
        List<Customer> customers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(CUSTOMERS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String id = parts[0];
                String fullName = parts[1];
                String cardNumber = parts[2];
                customers.add(new Customer(id, fullName, findInsuranceCard(cardNumber)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Read insurance cards from file
    public static List<InsuranceCard> readInsuranceCardsFromFile() {
        List<InsuranceCard> insuranceCards = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(INSURANCE_CARDS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String cardNumber = parts[0];
                String cardHolder = parts[1];
                String policyOwner = parts[2];
                Date expirationDate = dateFormat.parse(parts[3]);
                insuranceCards.add(new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate));
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        return insuranceCards;
    }

    // Read claims from file
    public static List<Claim> readClaimsFromFile() {
        List<Claim> claims = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(CLAIMS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String id = parts[0];
                Date claimDate = dateFormat.parse(parts[1]);
                String insuredPerson = parts[2];
                String cardNumber = parts[3];
                Date examDate = dateFormat.parse(parts[4]);
                double claimAmount = Double.parseDouble(parts[6]); // Update index to 6
                String status = parts[7]; // Status should be at index 7
                String receiverBankingInfo = parts[8]; // Receiver banking info should be at index 8
                List<String> documents = new ArrayList<>();
                for (int i = 5; i < parts.length - 3; i++) {
                    documents.add(parts[i]);
                }
                claims.add(new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, receiverBankingInfo));
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        return claims;
    }
    // Helper method to find insurance card by card number
    private static InsuranceCard findInsuranceCard(String cardNumber) {
        for (InsuranceCard card : readInsuranceCardsFromFile()) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }
}
