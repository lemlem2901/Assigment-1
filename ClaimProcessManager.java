/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public interface ClaimProcessManager {
    void addClaim(Claim claim);
    void updateClaim(Claim claim);
    void deleteClaim(String claimId);
    Claim getClaimById(String claimId);
    List<Claim> getAllClaims();
}
