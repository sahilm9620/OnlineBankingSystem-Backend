package in.co.vwits.onlinebanking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.service.AccountService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api")
public class AccountController {

	@Autowired
	AccountService accountService;
	
		@GetMapping
		@RequestMapping(value = "account/{acno}")
		public Account getAccount(@PathVariable("acno") Integer acno) {
			return accountService.getAccount(acno);
		}

//		@PostMapping
//		@RequestMapping(value = "account/{custId}")
//		public Account addAccount(@PathVariable Integer custId ,@RequestBody Account accountToBeCreated) {
//			return accountService.createAccount(accountToBeCreated,custId);
//		}
		

		@GetMapping
		@RequestMapping(value = "account/")
		public List<Account> getAllAccount() {
			return accountService.getAllAccount();
		}
		
}
