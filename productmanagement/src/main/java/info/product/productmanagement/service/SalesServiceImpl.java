package info.product.productmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.product.productmanagement.model.CustomerModel;
import info.product.productmanagement.model.ProductModel;
import info.product.productmanagement.model.SalesModel;
import info.product.productmanagement.repository.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	private SalesRepository salesRepository;

	@Override
	public void saveSales(SalesModel sales) {
		this.salesRepository.save(sales);
		
	}

	@Override
	public List<SalesModel> getAllSales() {
		
		return salesRepository.findAll();
	}

	@Override
	public void saveSalesLogic(int quantity, ProductModel product, CustomerModel customer) {
		SalesModel sales =new SalesModel();
		sales.setCustomer(customer);
		sales.setProduct(product);
		sales.setQuantity(quantity);
		double totalproductprice= product.getProductPrice()*quantity;
		sales.setPrice(totalproductprice);
		sales.setDateOfSales(LocalDate.now());
		saveSales(sales);
		
	}

}
