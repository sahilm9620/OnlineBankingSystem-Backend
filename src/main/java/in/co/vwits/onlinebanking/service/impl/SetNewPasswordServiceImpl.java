package in.co.vwits.onlinebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		account.setLoginPassword(encoder.encode(loginpassword));
		accountRepo.flush();
		return account;
	}

	@Override
	public Admin updateAdminPassword(String loginpassword, Integer aid) {
		 Admin admin =adminRepo.findById(aid).get();
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 admin.setPassword(encoder.encode(loginpassword));
		 adminRepo.flush();
		return admin;
	}

	@Override
	public Account updateTransactionPassword(String password, Integer user) {
		Account account =accountRepo.findById(user).get();
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		account.setTransectionPassword(encoder.encode(password));
		accountRepo.flush();
		return account;
	}

}
