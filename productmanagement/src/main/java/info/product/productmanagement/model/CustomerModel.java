package info.product.productmanagement.model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
(name ="tbl_customer")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name ="full_name" )
	@Size(min= 3, max= 50, message = "Size must be between 3-50")
	@NotNull
	private String FName;
	
	@Column(name ="email_address",unique = true)
	@Email(message = "E-mail you entered is not valid")
	@NotNull
	private String emailAddress;
	
	@Column(name="mobile_number",unique = true)
	@NotNull(message = "must not be blank")
	private String mobileNumber;
	
	@Column(name="is_regular")
	private boolean isRegular;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_of_birth")
	@NotNull(message = "must not be blank")
	private LocalDate dateOfBirth;
	
	@Column(name="address",nullable = false)
	@Size(min= 3, max= 50, message = "Size must be between 3 -50")
	@NotNull
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isRegular() {
		return isRegular;
	}
	public void setRegular(boolean isRegular) {
		this.isRegular = isRegular;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}
