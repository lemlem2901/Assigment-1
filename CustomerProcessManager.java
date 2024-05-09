import java.util.*;
public interface CustomerProcessManager {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);
    void deleteCustomer(String customerId);
    Customer getCustomerById(String CustomerId);
    List<Customer> getAllCustomers();
}
