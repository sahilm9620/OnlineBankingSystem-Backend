package in.co.vwits.onlinebanking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Payee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer beneficiaryid;

	private Integer baccountnumber;

	private String beneficiaryname;

	@JsonIgnore
	@ManyToOne
	Account account;
}
