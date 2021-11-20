package in.co.vwits.onlinebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Admin;
import in.co.vwits.onlinebanking.entity.Login;
import in.co.vwits.onlinebanking.service.LoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@PostMapping
	@RequestMapping(value = "user/login")
	public Account checkCustomerLogin(@RequestBody Login login) {
	return loginService.customerLogin(login.getUser(), login.getPassword());
	 }


	@PostMapping
	@RequestMapping(value = "admin/login")
	public Admin checkAdminLogin(@RequestBody Login login) {
	return loginService.adminLogin(login.getUser(),login.getPassword());

	 }
}
