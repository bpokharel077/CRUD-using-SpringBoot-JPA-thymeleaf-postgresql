package info.product.productmanagement.service;

import java.util.List;

import info.product.productmanagement.model.SalesDisplayModel;
import info.product.productmanagement.model.SalesModel;

public interface SalesService {
	void saveSales(SalesModel sales);
	List<SalesModel>getAllSales();
	void saveSalesLogic(SalesDisplayModel salesDisplay, double productPrice);

}
