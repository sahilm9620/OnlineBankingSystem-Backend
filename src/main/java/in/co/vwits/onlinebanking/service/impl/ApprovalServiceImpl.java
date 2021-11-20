package in.co.vwits.onlinebanking.service.impl;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import freemarker.template.TemplateException;
import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Approval;
import in.co.vwits.onlinebanking.entity.Customer;
import in.co.vwits.onlinebanking.repository.AccountRepository;
import in.co.vwits.onlinebanking.repository.AdminRepository;
import in.co.vwits.onlinebanking.repository.ApprovalRepository;
import in.co.vwits.onlinebanking.repository.CustomerRepository;
import in.co.vwits.onlinebanking.service.ApprovalService;
import in.co.vwits.onlinebanking.service.EmailService;

@CrossOrigin
@Service
public class ApprovalServiceImpl implements ApprovalService {


	@Autowired
	AccountRepository accountRepo;

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	ApprovalRepository approvalRepo;

	@Autowired
	EmailService emailService;

	@Override
	public List<Approval> verifyAccount() {
		return approvalRepo.findByisApproved("N");
	}

	@Override
	public void approveAccount(Integer custId) {
		accountRepo.getById(custId).setAccountStatus("Y");
		accountRepo.flush();

	}

	@Override
	public Approval addApproval(Integer custId, Approval app, Integer adminId) {
		if(app.getIsApproved().equals("N"))
		{
			 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Customer customer = customerRepo.getById(custId);
			app.setIsApproved("Y");

			approvalRepo.flush();

			Account account=new Account();
			account.setLoginPassword("1234");
			account.setAccountType("saving");
			account.setCurrentBalance(customer.getInitialAmount());
			account.setCustomer(customer);
			account.setTransectionPassword("1234");
			account.setUserid(custId);
			account.setAccountStatus("Y");
			
			
			customer.setAccount(account);
			customer.setApproval(app);
			customerRepo.flush();

			try {
				emailService.sendEmail(account, "account_verify_email.ftlh",customer.getFname() + " Your Account is Verified", customer.getEmail());
			} catch (MessagingException | IOException | TemplateException e) {

				e.printStackTrace();
			}
			account.setLoginPassword(encoder.encode(account.getLoginPassword())); 
			account.setTransectionPassword(encoder.encode(account.getTransectionPassword())); 
			accountRepo.save(account);
			return app;
		}else
			return null;

			
	}

	@Override
	public Approval isApprove(Integer custid) {
		Customer cust =customerRepo.findById(custid).get();
		return approvalRepo.findBycid(cust);
	}

	

}
