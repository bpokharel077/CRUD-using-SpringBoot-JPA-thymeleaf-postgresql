package info.product.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.product.productmanagement.model.CustomerModel;
import info.product.productmanagement.repository.CustomerRepository;
@Service

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<CustomerModel> getAllCustomer() {
		return customerRepository.findAll();
		
	}
	@Override
	public void saveCustomer(CustomerModel customer) {
		this.customerRepository.save(customer);
		
	}
	
	@Override
	public CustomerModel getCustomerById(int id) {
		Optional<CustomerModel> option=customerRepository.findById(id);
		CustomerModel customer= null;
		if(option.isPresent())
		{
			customer= option.get();
		}else {
			throw new RuntimeException("customer not found");
		}
		return customer;
		
	}
	@Override
	public void DeleteCustomerById(int id) {
		this.customerRepository.deleteById(id);
		
	}
	

}
