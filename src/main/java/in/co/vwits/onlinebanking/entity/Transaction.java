package in.co.vwits.onlinebanking.entity;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionid;
	private Integer amounttransferred;
	private String modeoftransaction;
	private String remarks;
	private LocalDateTime transactiondate = LocalDateTime.now();

	@JsonIgnore
	@ManyToOne
	private Account accountto;
	
	@JsonIgnore
	@ManyToOne
	private Account accountfrom;
	
	
}
