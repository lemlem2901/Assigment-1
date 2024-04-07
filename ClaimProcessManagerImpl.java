/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private List<Claim> claims;

    public ClaimProcessManagerImpl(List<Claim> claims) {
        this.claims = claims;
    }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    public void updateClaim(Claim claim) {
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claim.getId())) {
                claims.set(i, claim);
                break;
            }
        }
    }

    public void deleteClaim(String claimId) {
        claims.removeIf(claim -> claim.getId().equals(claimId));
    }

    public Claim getClaimById(String claimId) {
        for (Claim claim : claims) {
            if (claim.getId().equals(claimId)) {
                return claim;
            }
        }
        return null;
    }

    public List<Claim> getAllClaims() {
        return new ArrayList<>(claims);
    }
}
