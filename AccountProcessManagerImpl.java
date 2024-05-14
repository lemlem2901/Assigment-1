/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
import java.util.*;
public class AccountProcessManagerImpl implements AccountProcessManager {
    private List<Account> accounts;

    public AccountProcessManagerImpl(List<Account> accounts) { this.accounts = accounts; }

    public void addAccount(Account account) {accounts.add(account);}

    public void deleteAccount(String id) {accounts.removeIf(account -> account.getUserName().equals(id));}

    public void changePassword(Account account, String password){
        List<Account> accounts = FileManager.readAccountsFromFile();
    }
    public Account getAccountById(String id) {
        for (Account account : accounts) {
            if (account.getUserName().equals(id)) {
                return account;
            }
        }
        return null;
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
