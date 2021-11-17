package info.product.productmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import info.product.productmanagement.model.CustomerModel;
import info.product.productmanagement.service.CustomerService;

@Controller
public class CustomerController {
	//display list of customers
	@Autowired
	private CustomerService customerService;
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listCustomer", customerService.getAllCustomer());
		return "customerindex";
	}
	@GetMapping("/addNewCustomer")
	public String addNewCustomer(Model model) {
		CustomerModel customerModel = new CustomerModel();
		model.addAttribute("customer", customerModel);
		 return "AddCustomer";	
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer")CustomerModel customer, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return"AddCustomer";
		}
		//save customer to database
		customerService.saveCustomer(customer);
		return "redirect:/";
	}
	@GetMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable(value="id")int id,Model model) {
		//get customer from service
		CustomerModel customer =customerService.getCustomerById(id);
		//set customer as a modle attribute to pre-populate the update form
		model.addAttribute("customer", customer);
		return "AddCustomer";
	}
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value="id")int id) {
		//call delete customer
		this.customerService.deleteCustomerById(id);
		return "redirect:/";
	}


}