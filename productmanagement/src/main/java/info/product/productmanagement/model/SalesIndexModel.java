package info.product.productmanagement.model;

import java.time.LocalDate;

public class SalesIndexModel implements Comparable<SalesIndexModel> {
	private String customerName;
	private String productName;
	private double totalPrice;
	private int quantity;
	private LocalDate salesDate;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(LocalDate salesDate) {
		this.salesDate = salesDate;
	}
	@Override
	public int compareTo(SalesIndexModel o) {
		
		return o.getSalesDate().compareTo(getSalesDate());
	}
	
	

}
