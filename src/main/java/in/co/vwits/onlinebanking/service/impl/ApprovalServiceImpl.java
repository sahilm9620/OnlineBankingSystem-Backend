package in.co.vwits.onlinebanking.service.impl;

import static in.co.vwits.onlinebanking.utils.Constants.YES;
import static in.co.vwits.onlinebanking.utils.Constants.NO;
import static in.co.vwits.onlinebanking.utils.Constants.ACCOUNT_VERIFICATION_EMAIL_TEMPLATE;
import static in.co.vwits.onlinebanking.utils.Constants.DEFAULT_ACCOUNT_TYPE;
import java.io.IOException;
import java.util.List;
import java.util.Random;
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
		return approvalRepo.findByisApproved(NO);
	}

	@Override
	public void approveAccount(Integer custId) {
		accountRepo.getById(custId).setAccountStatus(YES);
		accountRepo.flush();

	}

	@Override
	public Approval addApproval(Integer custId, Approval app, Integer adminId) {
		if (app.getIsApproved().equals(NO)) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Customer customer = customerRepo.getById(custId);
			app.setIsApproved(YES);

			approvalRepo.flush();

			Random randomPasswordGenerator = new Random();

			Account account = new Account();
			account.setLoginPassword(randomPasswordGenerator.nextInt(10000) + "");
			account.setAccountType(DEFAULT_ACCOUNT_TYPE);
			account.setCurrentBalance(customer.getInitialAmount());
			account.setCustomer(customer);
			account.setTransectionPassword(randomPasswordGenerator.nextInt(10000) + "");
			account.setUserid(custId);
			account.setAccountStatus(YES);
			accountRepo.saveAndFlush(account);
			customer.setAccount(account);
			customer.setApproval(app);
			customerRepo.flush();

			try {
				emailService.sendEmail(account, ACCOUNT_VERIFICATION_EMAIL_TEMPLATE,
						customer.getFname() + " Your Account is Verified", customer.getEmail());
			} catch (MessagingException | IOException | TemplateException e) {

				e.printStackTrace();
			}

			account.setLoginPassword(encoder.encode(account.getLoginPassword()));
			account.setTransectionPassword(encoder.encode(account.getTransectionPassword()));
			accountRepo.flush();
			
			return app;
		} else
			return null;

	}

	@Override
	public Approval isApprove(Integer custid) {
		Customer cust = customerRepo.findById(custid).get();
		return approvalRepo.findBycid(cust);
	}

}
