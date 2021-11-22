package in.co.vwits.onlinebanking.service.impl;

import static in.co.vwits.onlinebanking.utils.Constants.WELCOME_EMAIL_TEMPLATE;
import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import freemarker.template.TemplateException;
import in.co.vwits.onlinebanking.entity.Admin;
import in.co.vwits.onlinebanking.entity.Approval;
import in.co.vwits.onlinebanking.entity.Customer;
import in.co.vwits.onlinebanking.repository.AdminRepository;
import in.co.vwits.onlinebanking.repository.ApprovalRepository;
import in.co.vwits.onlinebanking.repository.CustomerRepository;
import in.co.vwits.onlinebanking.service.CustomerService;
import in.co.vwits.onlinebanking.service.EmailService;

@CrossOrigin
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	EmailService emailService;

	@Autowired
	ApprovalRepository approvalRepo;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	Approval approval;

	@Override
	public Customer addCustomer(Customer customerToBeAdded) {

		Customer customer = customerRepo.saveAndFlush(customerToBeAdded);
		Admin admin = adminRepository.findById(1).get();
		approval.setAid(admin);
		approval.setCid(customer);
		Approval approvalSaved = approvalRepo.saveAndFlush(approval);
		customer.setApproval(approvalSaved);
		try {
			emailService.sendEmail(customerToBeAdded, WELCOME_EMAIL_TEMPLATE,
					"Welcome " + customerToBeAdded.getFname() + " To VW Bank", customerToBeAdded.getEmail());
		} catch (MessagingException | IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer getCustomer(Integer customerId) {

		return customerRepo.findById(customerId).get();
	}

	@Override
	public List<Customer> getAllCustomer() {

		return customerRepo.findAll();
	}

}
