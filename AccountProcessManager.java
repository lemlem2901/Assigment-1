/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public interface AccountProcessManager {
    void addAccount(Account account);
    void deleteAccount(String id);
    void changePassword(Account account, String newPassword);
    boolean checkAccount(String userName,String password);
    Account getAccountById(String id);
}
