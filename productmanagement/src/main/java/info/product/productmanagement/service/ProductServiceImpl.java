package info.product.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.product.productmanagement.model.ProductModel;
import info.product.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductModel> getAllProduct() {
		
		
		return productRepository.findAll();
	}

	@Override
	public void saveProduct(ProductModel product) {
		this.productRepository.save(product);
		
	}

	@Override
	public ProductModel getProductById(int id) {
		Optional<ProductModel> optional= productRepository.findById(id);
		ProductModel product=null;
		if (optional.isPresent())
		{
			product=optional.get();
		}else {
			throw new RuntimeException("Product with productid :"+id+" is not found");
		}
		return product;
	}

	@Override
	public void deleteCustomerById(int id) {
		this.productRepository.deleteById(id);
		
	}

}
