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
    private static final String ACCOUNTS_FILE = "accounts.txt";

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
                String cardHolder = parts[3];
                String policyOwner = parts[4];
                Date expirationDate = dateFormat.parse(parts[5]);
                InsuranceCard insuranceCard = new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate);
                customers.add(new Customer(id, fullName, insuranceCard));
            }
        } catch (FileNotFoundException | ParseException e) {
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
                double claimAmount = Double.parseDouble(parts[6]);
                String status = parts[7];
                String receiverBankingInfo = parts[8];
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
    // Read accounts from file
    public static List<Account> readAccountsFromFile(){
        List<Account> accounts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ACCOUNTS_FILE))) {
            while (scanner.hasNextLine()) {
                String [] parts = scanner.nextLine().split(",");
                String userName = parts[0];
                String password = parts[1];
                String role = parts[2];
                accounts.add(new Account(userName, password, role));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return accounts;
    }
    // Save customers to file
    public static void saveCustomers(List<Customer> customers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CUSTOMERS_FILE))) {
            for (Customer customer : customers) {
                writer.println(customer.getId() + "," + customer.getFullName() + "," + customer.getInsuranceCard().getCardNumber()
                        + "," + customer.getInsuranceCard().getCardHolder() + "," + customer.getInsuranceCard().getPolicyOwner()
                        + "," +dateFormat.format(customer.getInsuranceCard().getExpirationDate()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(INSURANCE_CARDS_FILE))) {
            for(Customer customer : customers) {
                writer.println(customer.getInsuranceCard().getCardNumber() + "," + customer.getInsuranceCard().getCardHolder()
                        + "," +customer.getInsuranceCard().getPolicyOwner() + "," + dateFormat.format(customer.getInsuranceCard().getExpirationDate()));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save claims to file
    public static void saveClaims(List<Claim> claims) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CLAIMS_FILE))) {
            for (Claim claim : claims) {
                writer.println(claim.getId() + "," +
                        dateFormat.format(claim.getClaimDate()) + "," +
                        claim.getInsuredPerson() + "," +
                        claim.getCardNumber() + "," +
                        dateFormat.format(claim.getExamDate()) + "," +
                        String.join(";", claim.getDocuments()) + "," + // Join documents with ";"
                        claim.getClaimAmount() + "," +
                        claim.getStatus() + "," +
                        claim.getReceiverBankingInfo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Account findAccount(String userName) {
        for (Account account : readAccountsFromFile()) {
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;
    }
    // Save Account to file
    public static void saveAccount(List<Account> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ACCOUNTS_FILE))) {
            for (Account account : accounts) {
                writer.println(account.getUserName() + "," + account.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
