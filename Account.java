/**
 * @author <Nguyen Dinh Lam - s3990403>
 */
public class Account {
    private String userName;
    private String password;
    private String role;
    public Account(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassword() {return this.password;}

    public String getRole(){return this.role;}
}
