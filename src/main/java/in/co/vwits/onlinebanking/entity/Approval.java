package in.co.vwits.onlinebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Component
public class Approval {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer approvalid;
	@JsonIgnore
	@OneToOne
	private Customer cid;
	@Column(unique = true)
	private Integer SRN = (int) (Math.random() * 10000);

	@ManyToOne
	private Admin aid;

	private String isApproved = "N";

}
