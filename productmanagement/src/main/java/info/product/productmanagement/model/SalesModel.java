package info.product.productmanagement.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_sales")
public class SalesModel {
	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_customer_id")
	private CustomerModel customer;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_product_id")
	private ProductModel product;
	
	/*
	 * @Column(name = "product_id", nullable = false) private int productId;
	 */
	
	/*
	 * @Column(name="customer_id", nullable = false) private int customerId;
	 */
	
	@Column(name="date_of_sales")
	private LocalDate dateOfSales;
	
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Column(name="price", nullable = false)
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public int getProductId() { return productId; }
	 * 
	 * public void setProductId(int productId) { this.productId = productId; }
	 * 
	 * public int getCustomerId() { return customerId; }
	 * 
	 * public void setCustomerId(int customerId) { this.customerId = customerId; }
	 */

	public LocalDate getDateOfSales() {
		return dateOfSales;
	}

	public void setDateOfSales(LocalDate dateOfSales) {
		this.dateOfSales = dateOfSales;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}
	

}
