package info.product.productmanagement.service;

import java.util.List;

import info.product.productmanagement.model.CustomerModel;

public interface CustomerService {
	List<CustomerModel> getAllCustomer();
	void saveCustomer(CustomerModel customer);
	CustomerModel getCustomerById(int id);
	void DeleteCustomerById(int id);
}
