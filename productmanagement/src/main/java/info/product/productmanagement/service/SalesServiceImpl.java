package info.product.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return salesRepository.findAll();
	}

}
