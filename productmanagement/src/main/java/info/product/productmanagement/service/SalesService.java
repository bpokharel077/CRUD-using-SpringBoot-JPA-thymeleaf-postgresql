package info.product.productmanagement.service;

import java.util.List;

import info.product.productmanagement.model.CustomerModel;
import info.product.productmanagement.model.ProductModel;
import info.product.productmanagement.model.SalesModel;

public interface SalesService {
	void saveSales(SalesModel sales);
	List<SalesModel>getAllSales();
	void saveSalesLogic(int quantity, ProductModel product, CustomerModel customer);

}
