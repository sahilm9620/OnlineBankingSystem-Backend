package in.co.vwits.onlinebanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.co.vwits.onlinebanking.entity.Transaction;
import in.co.vwits.onlinebanking.repository.TransactionRepository;
import in.co.vwits.onlinebanking.service.TransactionService;

@CrossOrigin
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepo;

	@Override
	public List<Transaction> selectTransService(Integer accNo) {

		List<Transaction> listOfTransaction = transactionRepo.findAll();
		List<Transaction> transactionOfAcc = new ArrayList<>();
		for (Transaction t : listOfTransaction) {
			if (t.getAccountto().getAccountnumber() == accNo || t.getAccountfrom().getAccountnumber() == accNo) {
				transactionOfAcc.add(t);
			}
		}
		return transactionOfAcc;
	}

	@Override
	public List<Transaction> selectAllTransactionsService() {

		return transactionRepo.findAll();
	}

}
