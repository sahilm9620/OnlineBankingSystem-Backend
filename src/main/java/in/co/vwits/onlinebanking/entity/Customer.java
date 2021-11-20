package in.co.vwits.onlinebanking.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerid;
	private String title;
	private String fname;
	private String mname;
	private String lname;
	private String mobileno;
	private String email;
	private String adharno;
	private LocalDate dob;
	private Double initialAmount;
	private String occupation;
	private String incomesource;
	private Integer grossAnualIncome;
	private String debitCard;
	private String optNetBank;
	private String city;
	private String landmark;
	private String line1;
	private String line2;
	private int pincode;
	private String state;
	
	@JsonIgnore
	@OneToOne
	Account account;
	
	@JsonIgnore
	@OneToOne
	Approval approval;
	
	
}
