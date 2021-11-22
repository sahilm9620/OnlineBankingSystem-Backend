package in.co.vwits.onlinebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Admin;
import in.co.vwits.onlinebanking.repository.AccountRepository;
import in.co.vwits.onlinebanking.repository.AdminRepository;
import in.co.vwits.onlinebanking.service.LoginService;

@CrossOrigin
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	AdminRepository adminRepo;

	@Override
	public Account customerLogin(Integer userId, String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Account account = accountRepo.findByuserid(userId);

		if (account == null)
			return null;
		else if (encoder.matches(pass, account.getLoginPassword()) && account.getAccountStatus().equals("Y"))
			return account;
		else
			return null;

	}

	@Override
	public Admin adminLogin(Integer adminId, String pass) {
		Admin admin = adminRepo.findById(adminId).get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (admin == null)
			return null;
		else if (encoder.matches(pass, admin.getPassword()))
			return admin;
		else
			return null;
	}

}
