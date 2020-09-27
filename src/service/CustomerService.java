package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	
	private static final CustomerService instance = new CustomerService();
	
	private Map<String, Customer> customers;
	
	private CustomerService() {
		customers = new HashMap<String, Customer>();
		System.out.println("In CustomerService Constructor");
	}
	
	public static CustomerService getInstance() {
		return instance;
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
		customers.put(customer.getPassword(), customer);
		customers.put(customer.getName(), customer);
		customers.put(customer.getGender(), customer);
		customers.put(customer.getEmail(), customer);
	}
	
	public Customer findCustomer(String id) {
		if(id != null)
			return(customers.get(id.toLowerCase()));
		else
			return null;
	}
	
	public Customer register(String id, String password, String name, String gender, String email) {
		
		Customer customer = new Customer(id,password,name,gender,email);		
		addCustomer(customer);
		return customer;
	}
	public Customer login(String id, String password) {
		Customer customer = findCustomer(id);
	
		if(customer != null) {
			if( password.equals(customer.getPassword())  ) {
				System.out.println("login success");
				return customer;
			}
					
			else {
				System.out.println("login failed");
				return null;
			}
		}	
		return null;
	}
	
	
}
