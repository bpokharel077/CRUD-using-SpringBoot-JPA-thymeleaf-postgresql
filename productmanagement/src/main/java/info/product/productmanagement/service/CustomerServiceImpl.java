package info.product.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.product.productmanagement.exception.BusinessException;
import info.product.productmanagement.model.CustomerModel;
import info.product.productmanagement.model.SalesDisplayModel;
import info.product.productmanagement.model.SalesModel;
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
		try {
			this.customerRepository.save(customer);
		} catch (ConstraintViolationException constraintViolationException) {
			throw new BusinessException("601", "Email and mobile number cannot be duplicate, please check");
		}
		catch(Exception e){
			throw new BusinessException("601", "Email and mobile number cannot be duplicate, please check"); 
		}
		
		
	}
	
	@Override
	public CustomerModel getCustomerById(int id) {
		Optional<CustomerModel> option=customerRepository.findById(id);
		CustomerModel customer= null;
		if(option.isPresent())
		{
			customer= option.get();
		}else {
			throw new RuntimeException("customer not found for id" +id);
		}
		return customer;
		
	}
	@Override
	public void deleteCustomerById(int id) {
		try {
		this.customerRepository.deleteById(id);
		}
		catch (Exception exception) {
			/* System.out.println(constraintViolationException.getMessage()); */
			throw new BusinessException("601", "You have dependencies with sales");
		}
	}
	@Override
	public void checkingCustomerRegularity(List<SalesModel> salesList ,SalesDisplayModel salesDisplay) {
				
		int customerCount=0;
		for(SalesModel item: salesList)
		{
			if(item.getCustomerId()==salesDisplay.getCustomerId())
			{
				customerCount++;
			}
		}
		if(customerCount>=20) {
			CustomerModel customer=getCustomerById(salesDisplay.getCustomerId());
			customer.setRegular(true);
			saveCustomer(customer);
		}
		
		
	}
	

}
