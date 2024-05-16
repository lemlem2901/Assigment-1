/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private String status;
    private String receiverBankingInfo;

    private String insuredPersonId;

    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate,
                 List<String> documents, double claimAmount, String status, String receiverBankingInfo, String insuredPersonId) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
        this.insuredPersonId = insuredPersonId;
    }
    //getter
    public String getId() {
        return id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
    public String getInsuredPersonId() {
        return insuredPersonId;
    }
    public String getReceiverBankingInfo() {
        return receiverBankingInfo;
    }
}
