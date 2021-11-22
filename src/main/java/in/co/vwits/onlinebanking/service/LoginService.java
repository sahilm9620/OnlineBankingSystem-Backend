package in.co.vwits.onlinebanking.service;

import org.springframework.stereotype.Service;

import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Admin;

@Service
public interface LoginService {
	Account customerLogin(Integer userid, String pass);

	Admin adminLogin(Integer userid, String pass);
}
