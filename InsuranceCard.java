/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class InsuranceCard {
    private String cardNumber;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;

    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }
    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
