package info.product.productmanagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
public class ProductModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name ="product_name",length = 100,nullable=false)
	private String productName;
	
	@Column(name ="product_price",nullable = false)
	private double productPrice;
	
	@Column(name="product_company_name")
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
	
	

}
