package in.co.vwits.onlinebanking.service;

import org.springframework.stereotype.Service;

import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Admin;

@Service
public interface SetNewPasswordService {

	Account updatePassword(String loginpassword, Integer accountnumber);

	Admin updateAdminPassword(String loginpassword, Integer aid);

	Account updateTransactionPassword(String password, Integer user);

}
