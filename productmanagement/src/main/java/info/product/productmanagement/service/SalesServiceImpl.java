package info.product.productmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.product.productmanagement.model.SalesDisplayModel;
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
	public void saveSalesLogic(SalesDisplayModel salesDisplay, double productPrice) {
		SalesModel sales =new SalesModel();
		sales.setCustomerId(salesDisplay.getCustomerId());
		sales.setProductId(salesDisplay.getProductId());
		int productQuantity=salesDisplay.getQuantity();
		sales.setQuantity(productQuantity);
		double totalproductprice= productPrice*productQuantity;
		sales.setPrice(totalproductprice);
		sales.setDateOfSales(LocalDate.now());
		saveSales(sales);
		
	}

}
