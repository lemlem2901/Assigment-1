/** * @author <Nguyen Dinh Lam - s3990403> */import java.text.ParseException;import java.util.*;public class InsuranceClaimsManagementSystem {    public static void main(String[] args) {        // Read data from files        List<Customer> customers = FileManager.readCustomersFromFile();        List<Claim> claims = FileManager.readClaimsFromFile();        List<Account> accounts = FileManager.readAccountsFromFile();        // Initialize ClaimProcessManagerImpl with loaded claims        ClaimProcessManagerImpl claimProcessManager = new ClaimProcessManagerImpl(claims);        // Initialize ClaimProcessManagerImpl with loaded customers        CustomerProcessManagerImpl customerProcessManager = new CustomerProcessManagerImpl(customers);        // Initialize ClaimProcessManagerImpl with loaded account        AccountProcessManagerImpl accountProcessManager = new AccountProcessManagerImpl(accounts);        // Implement the text-based UI for interaction        Scanner loginScanner = new Scanner(System.in);        boolean isAuthenticated = false;        String userName,password = null;        do {            System.out.println("login to Insurance Claim Management System!");            System.out.print("Enter your account: ");            userName = loginScanner.nextLine();            System.out.print("Enter your password: ");            password = loginScanner.nextLine();            isAuthenticated = accountProcessManager.checkAccount(userName,password);            if (!isAuthenticated) {                System.out.println("Username or password is not correct!");            }        }  while (!isAuthenticated);                System.out.println("login successful!");        String role = FileManager.findAccount(userName).getRole();        System.out.println("You are " + role + "!, please wait for a second");        System.out.println("loading...");        switch (role) {            case "admin":                Scanner scanner = new Scanner(System.in);                int startChoice;                do {                    System.out.println("Welcome to the Insurance Claims Management System!");                    System.out.println("1. Customer");                    System.out.println("2. Claim");                    System.out.println("3. Exit");                    System.out.print("please enter your object: ");                    startChoice = scanner.nextInt();                    scanner.nextLine(); //Consume newline                    switch (startChoice) {                        case 1:                            Scanner scanner1 = new Scanner(System.in);                            int choice1;                            do {                                System.out.println("Insurance Claims Management System");                                System.out.println("1. Add a new Customer");                                System.out.println("2. Update a Customer");                                System.out.println("3. Delete a Customer");                                System.out.println("4. View a Customer");                                System.out.println("5. View all Customer");                                System.out.println("6.add customer account");                                System.out.println("7. Exit");                                System.out.print("Enter your choice: ");                                choice1 = scanner1.nextInt();                                scanner1.nextLine(); // Consume newline                                switch (choice1) {                                    case 1:                                        // Implement add customer functionality                                        System.out.println("Adding a new Customer:");                                        // Prompt user for customer details                                        System.out.print("Enter customer's name: ");                                        String name = scanner1.nextLine();                                        System.out.print("Enter customer's ID: ");                                        String id = scanner1.nextLine();                                        System.out.print("Enter insurance card number: ");                                        String cardNumber = scanner1.nextLine();                                        System.out.print("Enter card holder: ");                                        String cardHolder = scanner1.nextLine();                                        System.out.print("Enter policy owner: ");                                        String policyOwner = scanner1.nextLine();                                        System.out.print("Enter expiration date (yyyy-MM-dd): ");                                        String expirationDateString = scanner1.nextLine();                                        Date expirationDate = null;                                        try {                                            expirationDate = FileManager.dateFormat.parse(expirationDateString);                                        } catch (ParseException e) {                                            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");                                            break;                                        }                                        InsuranceCard newInsuranceCard = new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate);                                        //Create the new customer object;                                        Customer newCustomer = new Customer(id, name, newInsuranceCard);                                        customerProcessManager.addCustomer(newCustomer);                                        System.out.println("Customer added successfully.");                                        break;                                    case 2:                                        // Implement update customer functionality                                        System.out.println("Updating a customer:");                                        // Prompt user for customer ID to update                                        System.out.print("Enter customer ID to update: ");                                        String updateCustomerId = scanner1.nextLine();                                        // Check if the customer ID exists                                        Customer customerToUpdate = customerProcessManager.getCustomerById(updateCustomerId);                                        if (customerToUpdate != null) {                                            // Prompt user for updated details                                            System.out.print("Enter customer's name: ");                                            String newName = scanner1.nextLine();                                            System.out.print("Enter insurance card number: ");                                            String newCardNumber = scanner1.nextLine();                                            System.out.print("Enter card holder: ");                                            String newCardHolder = scanner1.nextLine();                                            System.out.print("Enter policy owner: ");                                            String newPolicyOwner = scanner1.nextLine();                                            System.out.print("Enter expiration date (yyyy-MM-dd): ");                                            String newExpirationDateString = scanner1.nextLine();                                            Date newExpirationDate = null;                                            try {                                                newExpirationDate = FileManager.dateFormat.parse(newExpirationDateString);                                            } catch (ParseException e) {                                                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");                                                break;                                            }                                            // Update the customer with new details                                            InsuranceCard anotherNewInsuranceCard = new InsuranceCard(newCardNumber, newCardHolder, newPolicyOwner, newExpirationDate);                                            customerToUpdate = new Customer(customerToUpdate.getId(), newName, anotherNewInsuranceCard);                                            customerProcessManager.updateCustomer(customerToUpdate);                                            System.out.println("Customer updated successfully.");                                        }                                        else {                                            System.out.println("Customer with ID " + updateCustomerId + " does not exist.");                                        }                                        break;                                    case 3:                                        // Implement delete customer functionality                                        System.out.println("Deleting a customer:");                                        // Prompt user for customer ID to delete                                        System.out.print("Enter customer ID to delete: ");                                        String deleteCustomerId = scanner1.nextLine();                                        // Check if the customer ID exists                                        Customer customerToDelete = customerProcessManager.getCustomerById(deleteCustomerId);                                        if (customerToDelete != null) {                                            // Delete the customer                                            customerProcessManager.deleteCustomer(deleteCustomerId);                                            System.out.println("Customer with ID " + deleteCustomerId + " deleted successfully.");                                        } else {                                            System.out.println("Customer with ID " + deleteCustomerId + " does not exist.");                                        }                                        break;                                    case 4:                                        // Implement view a customer functionality                                        System.out.println("Viewing a customer:");                                        // Prompt user for customer ID to view                                        System.out.print("Enter customer ID to view: ");                                        String viewCustomerId = scanner1.nextLine();                                        // Retrieve the customer by ID                                        Customer viewedCustomer = customerProcessManager.getCustomerById(viewCustomerId);                                        if (viewedCustomer != null) {                                            // Display customer details                                            System.out.println("Customer ID: " + viewedCustomer.getId());                                            System.out.println("Full Name: " + viewedCustomer.getFullName());                                            System.out.println("Insurance Card: " + viewedCustomer.getInsuranceCard());                                        } else {                                            System.out.println("Customer with ID " + viewCustomerId + " does not exist.");                                        }                                        break;                                    case 5:                                        // Implement view all customers functionality                                        System.out.println("Viewing all customers:");                                        // Retrieve all customers                                        List<Customer> allCustomers = customerProcessManager.getAllCustomers();                                        // Check if there are any customers                                        if (allCustomers.isEmpty()) {                                            System.out.println("No customers found.");                                        } else {                                            // Display details of all claims                                            for (Customer customer : allCustomers) {                                                System.out.println("Customer ID: " + customer.getId());                                                System.out.println("Full Name: " + customer.getFullName());                                                System.out.println("Insurance Card: " + customer.getInsuranceCard());                                            }                                        }                                        break;                                    case 6:                                    case 7:                                        // Save data before exiting                                        FileManager.saveCustomers(customers);                                        System.out.println("Exiting...");                                        // Exit the program                                        System.exit(0);                                        break;                                    default:                                        System.out.println("Invalid choice. Please enter a valid option.");                                }                            }while (choice1 != 7);                            scanner1.close();                        case 2:                            Scanner scanner2 = new Scanner(System.in);                            int choice2;                            do {                                System.out.println("Insurance Claims Management System");                                System.out.println("1. Add a new claim");                                System.out.println("2. Update a claim");                                System.out.println("3. Delete a claim");                                System.out.println("4. View a claim");                                System.out.println("5. View all claims");                                System.out.println("6. Exit");                                System.out.print("Enter your choice: ");                                choice2 = scanner2.nextInt();                                scanner2.nextLine(); // Consume newline                                switch (choice2) {                                    case 1:                                        // Implement add claim functionality                                        System.out.println("Adding a new claim:");                                        // Prompt user for claim details                                        System.out.print("Enter claim ID: ");                                        String claimId = scanner2.nextLine();                                        System.out.print("Enter claim date (yyyy-MM-dd): ");                                        String claimDateString = scanner2.nextLine();                                        Date claimDate = null;                                        try {                                            claimDate = FileManager.dateFormat.parse(claimDateString);                                        } catch (ParseException e) {                                            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");                                            break;                                        }                                        System.out.print("Enter insured person: ");                                        String insuredPerson = scanner2.nextLine();                                        System.out.print("Enter card number: ");                                        String cardNumber = scanner2.nextLine();                                        System.out.print("Enter exam date (yyyy-MM-dd): ");                                        String examDateString = scanner2.nextLine();                                        Date examDate = null;                                        try {                                            examDate = FileManager.dateFormat.parse(examDateString);                                        } catch (ParseException e) {                                            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");                                            break;                                        }                                        System.out.print("Enter claim amount: ");                                        double claimAmount = scanner2.nextDouble();                                        scanner2.nextLine(); // Consume newline                                        System.out.print("Enter status (New/Processing/Done): ");                                        String status = scanner2.nextLine();                                        System.out.print("Enter receiver banking info: ");                                        String receiverBankingInfo = scanner2.nextLine();                                        System.out.print("Enter number of documents: ");                                        int numDocuments = scanner2.nextInt();                                        scanner2.nextLine(); // Consume newline                                        // Prompt user for each document                                        List<String> documents = new ArrayList<>();                                        for (int i = 1; i <= numDocuments; i++) {                                            System.out.print("Enter document " + i + ": ");                                            String document = scanner2.nextLine();                                            documents.add(document);                                        }                                        // Create the new claim object                                        Claim newClaim = new Claim(claimId, claimDate, insuredPerson, cardNumber,                                                examDate, documents, claimAmount, status, receiverBankingInfo);                                        // Add the claim to the claim process manager                                        claimProcessManager.addClaim(newClaim);                                        System.out.println("Claim added successfully.");                                        break;                                    case 2:                                        // Implement update claim functionality                                        System.out.println("Updating a claim:");                                        // Prompt user for claim ID to update                                        System.out.print("Enter claim ID to update: ");                                        String updateClaimId = scanner2.nextLine();                                        // Check if the claim ID exists                                        Claim claimToUpdate = claimProcessManager.getClaimById(updateClaimId);                                        if (claimToUpdate != null) {                                            // Prompt user for updated details                                            System.out.print("Enter new claim date (yyyy-MM-dd): ");                                            String newClaimDateString = scanner2.nextLine();                                            Date newClaimDate = null;                                            try {                                                newClaimDate = FileManager.dateFormat.parse(newClaimDateString);                                            } catch (ParseException e) {                                                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");                                                break;                                            }                                            System.out.print("Enter new insured person: ");                                            String newInsuredPerson = scanner2.nextLine();                                            System.out.print("Enter new card number: ");                                            String newCardNumber = scanner2.nextLine();                                            System.out.print("Enter new exam date (yyyy-MM-dd): ");                                            String newExamDateString = scanner2.nextLine();                                            Date newExamDate = null;                                            try {                                                newExamDate = FileManager.dateFormat.parse(newExamDateString);                                            } catch (ParseException e) {                                                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");                                                break;                                            }                                            System.out.print("Enter new claim amount: ");                                            double newClaimAmount = scanner2.nextDouble();                                            scanner2.nextLine(); // Consume newline                                            System.out.print("Enter new status (New/Processing/Done): ");                                            String newStatus = scanner2.nextLine();                                            System.out.print("Enter new receiver banking info: ");                                            String newReceiverBankingInfo = scanner2.nextLine();                                            System.out.print("Enter new number of documents: ");                                            int newNumDocuments = scanner2.nextInt();                                            scanner2.nextLine(); // Consume newline                                            // Prompt user for each new document                                            List<String> newDocuments = new ArrayList<>();                                            for (int i = 1; i <= newNumDocuments; i++) {                                                System.out.print("Enter new document " + i + ": ");                                                String newDocument = scanner2.nextLine();                                                newDocuments.add(newDocument);                                            }                                            // Update the claim with new details                                            claimToUpdate = new Claim(claimToUpdate.getId(), newClaimDate, newInsuredPerson, newCardNumber,                                                    newExamDate, newDocuments, newClaimAmount, newStatus, newReceiverBankingInfo);                                            claimProcessManager.updateClaim(claimToUpdate);                                            System.out.println("Claim updated successfully.");                                        } else {                                            System.out.println("Claim with ID " + updateClaimId + " does not exist.");                                        }                                        break;                                    case 3:                                        // Implement delete claim functionality                                        System.out.println("Deleting a claim:");                                        // Prompt user for claim ID to delete                                        System.out.print("Enter claim ID to delete: ");                                        String deleteClaimId = scanner2.nextLine();                                        // Check if the claim ID exists                                        Claim claimToDelete = claimProcessManager.getClaimById(deleteClaimId);                                        if (claimToDelete != null) {                                            // Delete the claim                                            claimProcessManager.deleteClaim(deleteClaimId);                                            System.out.println("Claim with ID " + deleteClaimId + " deleted successfully.");                                        } else {                                            System.out.println("Claim with ID " + deleteClaimId + " does not exist.");                                        }                                        break;                                    case 4:                                        // Implement view a claim functionality                                        System.out.println("Viewing a claim:");                                        // Prompt user for claim ID to view                                        System.out.print("Enter claim ID to view: ");                                        String viewClaimId = scanner2.nextLine();                                        // Retrieve the claim by ID                                        Claim viewedClaim = claimProcessManager.getClaimById(viewClaimId);                                        if (viewedClaim != null) {                                            // Display claim details                                            System.out.println("Claim ID: " + viewedClaim.getId());                                            System.out.println("Claim Date: " + FileManager.dateFormat.format(viewedClaim.getClaimDate()));                                            System.out.println("Insured Person: " + viewedClaim.getInsuredPerson());                                            System.out.println("Card Number: " + viewedClaim.getCardNumber());                                            System.out.println("Exam Date: " + FileManager.dateFormat.format(viewedClaim.getExamDate()));                                            System.out.println("Claim Amount: " + viewedClaim.getClaimAmount());                                            System.out.println("Status: " + viewedClaim.getStatus());                                            System.out.println("Receiver Banking Info: " + viewedClaim.getReceiverBankingInfo());                                            System.out.println("Documents:");                                            for (String document : viewedClaim.getDocuments()) {                                                System.out.println("- " + document);                                            }                                        } else {                                            System.out.println("Claim with ID " + viewClaimId + " does not exist.");                                        }                                        break;                                    case 5:                                        // Implement view all claims functionality                                        System.out.println("Viewing all claims:");                                        // Retrieve all claims                                        List<Claim> allClaims = claimProcessManager.getAllClaims();                                        // Check if there are any claims                                        if (allClaims.isEmpty()) {                                            System.out.println("No claims found.");                                        } else {                                            // Display details of all claims                                            for (Claim claim : allClaims) {                                                System.out.println("Claim ID: " + claim.getId());                                                System.out.println("Claim Date: " + FileManager.dateFormat.format(claim.getClaimDate()));                                                System.out.println("Insured Person: " + claim.getInsuredPerson());                                                System.out.println("Card Number: " + claim.getCardNumber());                                                System.out.println("Exam Date: " + FileManager.dateFormat.format(claim.getExamDate()));                                                System.out.println("Claim Amount: " + claim.getClaimAmount());                                                System.out.println("Status: " + claim.getStatus());                                                System.out.println("Receiver Banking Info: " + claim.getReceiverBankingInfo());                                                System.out.println("Documents:");                                                for (String document : claim.getDocuments()) {                                                    System.out.println("- " + document);                                                }                                                System.out.println();                                            }                                        }                                        break;                                    case 6:                                        // Save data before exiting                                        FileManager.saveClaims(claims);                                        System.out.println("Exiting...");                                        // Exit the program                                        System.exit(0);                                        break;                                    default:                                        System.out.println("Invalid choice. Please enter a valid option.");                                }                            }while (choice2 != 6);                            scanner2.close();                    }                }while (startChoice !=3);                scanner.close();            case "insurance surveyvors":            case "insurance managers":            case "policy owner":            case "policy holder":            case "dependent":        }    }}