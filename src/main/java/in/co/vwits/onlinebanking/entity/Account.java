package in.co.vwits.onlinebanking.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountnumber;
	
	@OneToOne
	private Customer customer;
	@Column(unique = true)
	private Integer userid;
	private String accountType;
	private Double currentBalance;
	private String accountStatus;
	private String loginPassword;
	private String transectionPassword;
	private LocalDate createdOn = java.time.LocalDate.now();;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Payee> payees;

	@JsonIgnore
	@OneToMany(mappedBy = "accountto")
	private List<Transaction> transactionto;

	@JsonIgnore
	@OneToMany(mappedBy = "accountfrom")
	private List<Transaction> transactionfrom;

}
