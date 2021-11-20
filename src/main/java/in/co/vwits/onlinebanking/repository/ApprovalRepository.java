package in.co.vwits.onlinebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.vwits.onlinebanking.entity.Approval;
import in.co.vwits.onlinebanking.entity.Customer;

public interface ApprovalRepository extends JpaRepository<Approval, Integer> {
	List<Approval> findByisApproved(String isApproved);
	Approval findBycid(Customer cust);
}
