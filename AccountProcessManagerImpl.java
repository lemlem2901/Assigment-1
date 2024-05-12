/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class AccountProcessManagerImpl implements AccountProcessManager {
    private List<Account> accounts;

    public AccountProcessManagerImpl(List<Account> accounts) { this.accounts = accounts; }

    public void addAccount(Account account) {accounts.add(account);}

    public void removeAccount(Account userName) {accounts.removeIf(account -> account.getUserName().equals(userName));}

    public void changePassword(Account account, String password){
        List<Account> accounts = FileManager.readAccountsFromFile()
    }

}
