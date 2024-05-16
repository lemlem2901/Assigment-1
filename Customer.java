/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class Customer {
    private String id;
    private String fullName;
    private InsuranceCard insuranceCard;
    private String familyId;

    private  String phone;
    private  String address;
    private  String email;
    public Customer(String id, String fullName, InsuranceCard insuranceCard,String familyId, String phone, String address, String email) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.familyId = familyId;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
    // Getters and setters
    public String getId() {
        return id;
    }

    public String getFamilyId() { return familyId; }
    public String getFullName() {
        return fullName;
    }
    public String getPhone() { return phone; }
    public String getAddress() { return address;}
    public String getEmail() { return email;}

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }


}