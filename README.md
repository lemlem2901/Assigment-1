# Assigment-1
Nguyen Dinh Lam s3990403 
Insurance Claims Management System

The Insurance Claims Management System is a Java application designed to manage insurance claims for customers. It allows users to add, update, delete, and view insurance claims. The system stores data in text files and provides a text-based user interface for interaction.
Features

    Add a New Claim: Users can add new insurance claims by providing relevant details such as claim ID, claim date, insured person, claim amount, etc.
    Update a Claim: Users can update existing claims with new information.
    Delete a Claim: Claims can be deleted from the system based on their claim ID.
    View a Claim: Users can view details of a specific claim by providing its claim ID.
    View All Claims: The system provides an option to view details of all existing claims.
    Data Persistence: Customer and claim data are stored in text files (customers.txt, insurance_cards.txt, claims.txt) and are loaded into memory when the application starts. Changes made during runtime are saved back to these files upon exiting the application.

Usage

    Compile the Java files using a Java compiler such as javac.
    Run the InsuranceClaimsManagementSystem class to start the application.
    Follow the on-screen prompts to interact with the system (add/update/delete/view claims).

File Structure

    Customer.java: Defines the Customer class with attributes and methods for managing customer information.
    InsuranceCard.java: Defines the InsuranceCard class representing insurance cards associated with customers.
    Claim.java: Defines the Claim class representing insurance claims.
    ClaimProcessManager.java: Defines the ClaimProcessManager interface specifying methods for claim management.
    ClaimProcessManagerImpl.java: Implements the ClaimProcessManager interface providing functionality for claim management.
    FileManager.java: Provides utility methods for reading/writing customer and claim data from/to text files.
    InsuranceClaimsManagementSystem.java: Contains the main method to run the application and user interface logic.

Dependencies

    Java 8 or higher

Contributors

    Nguyen Dinh Lam - s3990403
