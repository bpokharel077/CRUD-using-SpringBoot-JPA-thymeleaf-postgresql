package info.product.productmanagement.service;

import java.util.List;


import info.product.productmanagement.model.ProductModel;

public interface ProductService {
	List<ProductModel> getAllProduct();
	void saveProduct(ProductModel product);
	ProductModel getProductById(int id);
	void deleteCustomerById(int id);

}
