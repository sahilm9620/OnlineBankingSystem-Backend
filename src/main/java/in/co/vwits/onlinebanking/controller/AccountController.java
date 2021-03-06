package in.co.vwits.onlinebanking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.exception.AccountNotFoundException;
import in.co.vwits.onlinebanking.service.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping
	@RequestMapping(value = "account/{acno}")
	public Account getAccount(@PathVariable("acno") Integer acno) {
		try {
			return accountService.getAccount(acno);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@GetMapping
	@RequestMapping(value = "account/")
	public List<Account> getAllAccount() {
		return accountService.getAllAccount();
	}

}
