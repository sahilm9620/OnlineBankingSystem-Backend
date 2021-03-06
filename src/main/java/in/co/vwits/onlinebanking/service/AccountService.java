package in.co.vwits.onlinebanking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.exception.AccountNotFoundException;

@Service
public interface AccountService {
	Account createAccount(Account accountToBeCreated, Integer custId);

	Account getAccount(Integer id) throws AccountNotFoundException;

	List<Account> getAllAccount();

}
