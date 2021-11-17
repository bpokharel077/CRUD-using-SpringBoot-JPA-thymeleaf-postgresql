package info.product.productmanagement.controller;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import info.product.productmanagement.model.CustomerModel;
import info.product.productmanagement.model.ProductModel;
import info.product.productmanagement.model.SalesDisplayModel;
import info.product.productmanagement.model.SalesIndexModel;
import info.product.productmanagement.model.SalesModel;
import info.product.productmanagement.service.CustomerService;
import info.product.productmanagement.service.ProductService;
import info.product.productmanagement.service.SalesService;

@Controller
public class SalesController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SalesService salesService;
	
	
	@GetMapping("/addNewSales")
	public String addNewSales(Model model)
	{
		List<CustomerModel> customers=customerService.getAllCustomer();
		List<ProductModel> products= productService.getAllProduct();
		SalesDisplayModel salesDisplay= new SalesDisplayModel();
		salesDisplay.setCustomerList(customers);
		salesDisplay.setProductList(products);
		model.addAttribute("salesDisplay", salesDisplay);
		return "addSales";
	}
	//for saving sales record
	@PostMapping("/saveSales")
	public String saveSales(@Valid @ModelAttribute( "salesDisplay")SalesDisplayModel salesDisplay , BindingResult bindingResult)
	{
		salesDisplay.setCustomerList(customerService.getAllCustomer());
		salesDisplay.setProductList(productService.getAllProduct());
		if(bindingResult.hasErrors())
		{
			return("addSales");
		}
		
		double productPrice=productService.getProductById(salesDisplay.getProductId()).getProductPrice();
		
		/*
		 * SalesModel sales =new SalesModel();
		 * sales.setCustomerId(salesDisplay.getCustomerId());
		 * sales.setProductId(salesDisplay.getProductId()); int
		 * productQuantity=salesDisplay.getQuantity();
		 * sales.setQuantity(productQuantity); double totalproductprice=
		 * productPrice*productQuantity; sales.setPrice(totalproductprice);
		 * sales.setDateOfSales(LocalDate.now()); salesService.saveSales(sales);
		 */
		productService.saveSalesQuantity( salesDisplay);
		salesService.saveSalesLogic( salesDisplay,  productPrice);
		List<SalesModel> salesList = salesService.getAllSales();
		customerService.checkingCustomerRegularity( salesList , salesDisplay);
		productService.checkStockFlag( salesList, salesDisplay);
		
		//for product_sales flag and for is_regular flag
		
		/*
		 * int productCount=0; for(SalesModel item: salesList) {
		 * if(item.getProductId()==salesDisplay.getProductId()) { productCount++; } }
		 * if(productCount>=20) { ProductModel
		 * product=productService.getProductById(salesDisplay.getProductId());
		 * product.setProductStock(true); productService.saveProduct(product); }
		 * 
		 * 
		 * //for is_regular flag
		 * 
		 * int customerCount=0; for(SalesModel item: salesList) {
		 * if(item.getCustomerId()==salesDisplay.getCustomerId()) { customerCount++; } }
		 * if(customerCount>=20) { CustomerModel
		 * customer=customerService.getCustomerById(salesDisplay.getCustomerId());
		 * customer.setRegular(true); customerService.saveCustomer(customer); }
		 */
		
		return "redirect:/salesindex";
	}
	@GetMapping("/salesindex")
	public String salesIndex(Model model)
	{
		List<SalesModel>listOfSales= salesService.getAllSales();
		List<SalesIndexModel> salesIndexData =new ArrayList<SalesIndexModel>();		
		for(SalesModel sale: listOfSales)
		{
			SalesIndexModel salesIndexModel= new SalesIndexModel();
			salesIndexModel.setCustomerName(customerService.getCustomerById(sale.getCustomerId()).getFName());
			salesIndexModel.setProductName(productService.getProductById(sale.getProductId()).getProductName());
			salesIndexModel.setQuantity(sale.getQuantity());
			salesIndexModel.setSalesDate(sale.getDateOfSales());
			salesIndexModel.setTotalPrice(sale.getPrice());
			salesIndexData.add(salesIndexModel);
		}
		Collections.sort(salesIndexData);
		model.addAttribute("saleslist", salesIndexData);
		return"/salesindex";
	}
	

}
