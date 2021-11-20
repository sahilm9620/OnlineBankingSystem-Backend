package in.co.vwits.onlinebanking.service.impl;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.TemplateException;
import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Admin;
import in.co.vwits.onlinebanking.entity.Customer;
import in.co.vwits.onlinebanking.entity.Transaction;
import in.co.vwits.onlinebanking.repository.AccountRepository;
import in.co.vwits.onlinebanking.repository.AdminRepository;

@RestController

public class TestService {

	@Autowired
	AdminRepository adminrepo;
	
	@Autowired
	AccountRepository repository;
	
	@Autowired
	ApprovalServiceImpl serviceImpl;
	
	
	@Autowired
	EmailServiceImpl emailService;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@GetMapping("admin")
	List<Admin> getAdmin()
	{
		Customer cust = new Customer();
		cust.setFname("Sahil");
		cust.setEmail("sahil.mulla@mmit.edu.in");
		Transaction tran= new Transaction();
		tran.setAmounttransferred(500);
		Account account = new Account();
		account.setCustomer(cust);
		account.setAccountnumber(101001123);
		account.setUserid(1001);
		account.setAccountType("saving");
		try {
			emailService.sendEmail(tran, "debited.ftlh", tran.getAmounttransferred()+"₹ is Credited", account.getCustomer().getEmail());
		} catch (MessagingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (TemplateException e) {
			
			e.printStackTrace();
		}
		return adminrepo.findAll();
	}
	
	@PostMapping("admin")
	Admin addAdmin(@RequestBody Admin admin)
	{
		String tempEncodedPassword = encoder.encode(admin.getPassword());
		admin.setPassword(tempEncodedPassword);
		Admin adminAdded = adminrepo.saveAndFlush(admin);
		return adminAdded;
	}
	
	@GetMapping("/customer/approve/{id}")
	Account approveAccount(@PathVariable("id") Integer custid)
	{
		serviceImpl.approveAccount(custid);
		
		return null;
		
	}
}
