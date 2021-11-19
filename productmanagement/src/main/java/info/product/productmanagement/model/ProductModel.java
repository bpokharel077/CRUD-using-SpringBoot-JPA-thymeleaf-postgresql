package info.product.productmanagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="tbl_product")
public class ProductModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable = false)
	private int id;
	
	
	@Column(name ="product_name",nullable=false)
	@Size(min = 3, max = 50, message = "Should be in the range of 3-50")
	private String productName;
	
	@Column(name="product_quantity", nullable = false)
	@Min(value = 0, message = "cannot be less than zero")
	@NotNull(message = "product quantity cannot be empty")
	private int productQuantity;
	
	@Column(name ="product_price",nullable = false)
	@Min(value = 20, message = "Product price should be more than 20 rupees")
	@NotNull(message = "price cannot be empty")
	private double productPrice;
	
	
	@Column(name="product_company_name")
	@Size(min = 3, max = 50, message = "Should be in the range of 3-99")
	private String productCompanyName;
	
	@Column(name="product_stock")
	private boolean productStock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCompanyName() {
		return productCompanyName;
	}

	public void setProductCompanyName(String productCompanyName) {
		this.productCompanyName = productCompanyName;
	}

	public boolean isProductStock() {
		return productStock;
	}

	public void setProductStock(boolean productStock) {
		this.productStock = productStock;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	

}
