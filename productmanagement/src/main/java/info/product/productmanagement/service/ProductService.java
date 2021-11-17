package info.product.productmanagement.service;

import java.util.List;


import info.product.productmanagement.model.ProductModel;
import info.product.productmanagement.model.SalesDisplayModel;
import info.product.productmanagement.model.SalesModel;

public interface ProductService {
	List<ProductModel> getAllProduct();
	void saveProduct(ProductModel product);
	ProductModel getProductById(int id);
	void deleteCustomerById(int id);
	void saveSalesQuantity (SalesDisplayModel salesDisplay);
	
	//for product stock flag
	void checkStockFlag(List<SalesModel> salesList,SalesDisplayModel salesDisplay);

}
