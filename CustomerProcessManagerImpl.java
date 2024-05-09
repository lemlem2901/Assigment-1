import java.util.ArrayList;
import java.util.List;
public class CustomerProcessManagerImpl implements CustomerProcessManager {
    private List<Customer> customers;
    public CustomerProcessManagerImpl(List<Customer> customers) {
        this.customers = customers;
    }
    public void addCustomer(Customer customer) {customers.add(customer);}
    public void updateCustomer(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(customer.getId())) {
                customers.set(i, customer);
                break;
            }
        }
    }
    public void deleteCustomer(String customerId) {customers.removeIf(customer -> customer.getId().equals(customerId));}
    public Customer getCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }
}

