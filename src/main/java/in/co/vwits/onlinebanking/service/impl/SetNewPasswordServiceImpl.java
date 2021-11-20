package in.co.vwits.onlinebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Admin;
import in.co.vwits.onlinebanking.repository.AccountRepository;
import in.co.vwits.onlinebanking.repository.AdminRepository;
import in.co.vwits.onlinebanking.service.SetNewPasswordService;

@CrossOrigin
@Service
public class SetNewPasswordServiceImpl implements SetNewPasswordService {

	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public Account updatePassword(String loginpassword, Integer accountnumber) {
		Account account =accountRepo.findById(accountnumber).get();
		account.setLoginPassword(loginpassword);
		accountRepo.flush();
		return account;
	}

	@Override
	public Admin updateAdminPassword(String loginpassword, Integer aid) {
		 Admin admin =adminRepo.findById(aid).get();
		 admin.setPassword(loginpassword);
		 adminRepo.flush();
		return admin;
	}

	@Override
	public Account updateTransactionPassword(String password, Integer user) {
		Account account =accountRepo.findById(user).get();
		account.setTransectionPassword(password);
		accountRepo.flush();
		return account;
	}

}
