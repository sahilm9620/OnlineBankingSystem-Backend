package in.co.vwits.onlinebanking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.onlinebanking.entity.Transaction;
import in.co.vwits.onlinebanking.service.TransactionService;


@CrossOrigin(origins="*")
@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	//Get All Transaction on the bases of Account Number
		@GetMapping
		@RequestMapping(value = "transaction/{accNo}")
		public List<Transaction> selectTrans(@PathVariable("accNo") int accNo) {
			return transactionService.selectTransService(accNo);
		}

		//Get all Transaction done in the Bank 
		@GetMapping
		@RequestMapping(value = "transaction")
		public List<Transaction> getAllTransactions() {
			return transactionService.selectAllTransactionsService();
		}
}
