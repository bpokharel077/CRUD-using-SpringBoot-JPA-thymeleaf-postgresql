package info.product.productmanagement.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SalesDisplayModel {
	
	private List<ProductModel> productList;
	private List<CustomerModel> customerList;
	
	@Min(value = 0, message = "quantity cannot be less than 0")
	private int quantity;
	
	@NotNull
	private int customerId;
	@NotNull
	private int productId;
	
	public List<ProductModel> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductModel> productList) {
		this.productList = productList;
	}
	public List<CustomerModel> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<CustomerModel> customerList) {
		this.customerList = customerList;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

}
