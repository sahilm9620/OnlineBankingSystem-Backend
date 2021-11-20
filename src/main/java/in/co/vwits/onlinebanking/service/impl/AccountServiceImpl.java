package in.co.vwits.onlinebanking.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Customer;
import in.co.vwits.onlinebanking.repository.AccountRepository;
import in.co.vwits.onlinebanking.repository.CustomerRepository;
import in.co.vwits.onlinebanking.service.AccountService;

@CrossOrigin
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Account createAccount(Account accountToBeCreated,Integer custId) {
		Customer customer = customerRepo.getById(custId);
		accountToBeCreated.setCustomer(customer);
		customer.setAccount(accountToBeCreated);
		customerRepo.flush();
		return accountRepo.saveAndFlush(accountToBeCreated);
	}

	@Override
	public Account getAccount(Integer id) {
		return accountRepo.findById(id).get();
	}

	@Override
	public List<Account> getAllAccount() {
		
		return accountRepo.findAll();
	}



}
