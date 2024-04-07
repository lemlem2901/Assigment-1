/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class Customer {
    private String id;
    private String fullName;
    private InsuranceCard insuranceCard;
    private List<Claim> claims;

    public Customer(String id, String fullName, InsuranceCard insuranceCard) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claims = new ArrayList<>();
    }
    // Getters and setters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }
}