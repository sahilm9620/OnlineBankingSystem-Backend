package in.co.vwits.onlinebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Admin;
import in.co.vwits.onlinebanking.entity.Login;
import in.co.vwits.onlinebanking.service.SetNewPasswordService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class SetNewPasswordController {

	@Autowired
	SetNewPasswordService newPasswordService;

	@PutMapping
	@RequestMapping(value = "customer/login/password")
	public Account updatePassword(@RequestBody Login login) {
		return newPasswordService.updatePassword(login.getPassword(), login.getUser());
	}

	@PutMapping
	@RequestMapping(value = "customer/transaction/password")
	public Account updateTransactionPassword(@RequestBody Login login) {
		return newPasswordService.updateTransactionPassword(login.getPassword(), login.getUser());
	}

	@PutMapping
	@RequestMapping(value = "admin/login/password")
	public Admin updateAdminPassword(@RequestBody Login login) {
		return newPasswordService.updateAdminPassword(login.getPassword(), login.getUser());
	}
}
