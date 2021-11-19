package info.product.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.product.productmanagement.exception.BusinessException;
import info.product.productmanagement.model.ProductModel;
import info.product.productmanagement.model.SalesDisplayModel;
import info.product.productmanagement.model.SalesModel;
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
		
		
		try {
			this.productRepository.deleteById(id);
			}
			catch (Exception exception) {
				/* System.out.println(constraintViolationException.getMessage()); */
				throw new BusinessException("601", "You have dependencies with sales");
			}
		}
	

	@Override
	public void checkStockFlag(List<SalesModel> salesList, SalesDisplayModel salesDisplay) {
		int productCount=0;
		for(SalesModel item: salesList)
		{
			if(item.getProduct().getId()==salesDisplay.getProductId())
			{
				productCount++;
			}
		}
		if(productCount>=20) {
			ProductModel product=getProductById(salesDisplay.getProductId());
			product.setProductStock(true);
			saveProduct(product);
		}
		
	}

	@Override
	public void saveSalesQuantity(SalesDisplayModel salesDisplay) {
		try {
			ProductModel product=	getProductById(salesDisplay.getProductId());
			if(salesDisplay.getQuantity()<= product.getProductQuantity())
			{
		     int productQuantity=product.getProductQuantity()-salesDisplay.getQuantity();
			product.setProductQuantity(productQuantity);
			saveProduct(product);
			}
			else{
				throw new BusinessException();
			}
			
		} catch (BusinessException businessException) {
			throw new BusinessException("602", "Product out of Stock");
		}
	    
		
		
	}

}
