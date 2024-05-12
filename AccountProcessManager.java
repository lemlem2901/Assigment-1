/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public interface AccountProcessManager {
    void addAccount(Account account);
    void removeAccount(Account account);
    void changePassword(Account account, String newPassword);
    boolean checkAccount(String userName,String password);
}