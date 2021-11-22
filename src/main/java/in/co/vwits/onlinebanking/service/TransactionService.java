package in.co.vwits.onlinebanking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.vwits.onlinebanking.entity.Transaction;

@Service
public interface TransactionService {
	List<Transaction> selectTransService(Integer accNo);

	List<Transaction> selectAllTransactionsService();
}
