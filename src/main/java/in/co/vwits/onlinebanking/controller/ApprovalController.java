package in.co.vwits.onlinebanking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import in.co.vwits.onlinebanking.entity.Approval;
import in.co.vwits.onlinebanking.service.ApprovalService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class ApprovalController {

	@Autowired
	ApprovalService approvalService;

	@GetMapping
	@RequestMapping(value = "account/verify", method = RequestMethod.GET)
	public List<Approval> viewAccountToVerify() {
		return approvalService.verifyAccount();
	}

	@GetMapping
	@RequestMapping(value = "account/verify/{cid}", method = RequestMethod.GET)
	public Approval viewAccountToVerify(@PathVariable(name = "cid") Integer cid) {
		return approvalService.isApprove(cid);
	}

	@PostMapping
	@RequestMapping(value = "account/verify/{custId}/{adminId}", consumes = "application/json")
	public Approval approveAccount(@PathVariable(name = "custId") Integer custId,
			@PathVariable(name = "adminId") Integer adminId, @RequestBody Approval approval) {
		return approvalService.addApproval(custId, approval, adminId);
	}
}
