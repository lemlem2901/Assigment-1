/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class AccountProcessManagerImpl implements AccountProcessManager {
    private List<Account> accounts;

    public AccountProcessManagerImpl(List<Account> accounts) { this.accounts = accounts; }

    public void addAccount(Account account) {accounts.add(account);}

    public void removeAccount(Account userName) {accounts.removeIf(account -> account.getUserName().equals(userName));}

    public void filterAccount(Account account){

    }

    public void changePassword(Account account, String password){
        List<Account> accounts = FileManager.readAccountsFromFile();
    }
    public boolean checkAccount(String username, String password) {
        for (Account account : accounts) {
            if (account.getUserName().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
