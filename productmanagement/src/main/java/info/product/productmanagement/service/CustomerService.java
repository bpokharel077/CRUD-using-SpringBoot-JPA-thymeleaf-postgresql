package info.product.productmanagement.service;

import java.util.List;

import info.product.productmanagement.model.CustomerModel;
import info.product.productmanagement.model.SalesDisplayModel;
import info.product.productmanagement.model.SalesModel;

public interface CustomerService {
	List<CustomerModel> getAllCustomer();
	void saveCustomer(CustomerModel customer);
	CustomerModel getCustomerById(int id);
	void deleteCustomerById(int id);
	void checkingCustomerRegularity(List<SalesModel> salesList,SalesDisplayModel salesDisplay);
	
}
