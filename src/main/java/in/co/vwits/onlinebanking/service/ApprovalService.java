package in.co.vwits.onlinebanking.service;

import java.util.List;
import org.springframework.stereotype.Service;
import in.co.vwits.onlinebanking.entity.Approval;

@Service
public interface ApprovalService {
	List<Approval> verifyAccount();

	Approval isApprove(Integer custid);

	void approveAccount(Integer custId);

	Approval addApproval(Integer custId, Approval appId, Integer adminId);
}
