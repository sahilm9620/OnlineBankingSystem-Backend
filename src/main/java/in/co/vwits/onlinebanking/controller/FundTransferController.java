package in.co.vwits.onlinebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.co.vwits.onlinebanking.entity.Transaction;
import in.co.vwits.onlinebanking.service.FundTransferService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;

	// Transferring of Money
	@PostMapping
	@RequestMapping(value = "transfer/{toAccNo}/{fromAccNo}/{transPassword}")
	public Transaction addTransaction(@PathVariable("toAccNo") int toAccNo, @PathVariable("fromAccNo") int fromAccNo,
			@RequestBody Transaction tran, @PathVariable("transPassword") String transPassword) {
		return fundTransferService.addTransaction(toAccNo, fromAccNo, tran, transPassword);
	}
}
