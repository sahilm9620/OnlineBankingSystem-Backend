package in.co.vwits.onlinebanking.service;

import org.springframework.stereotype.Service;

import in.co.vwits.onlinebanking.entity.Transaction;

@Service
public interface FundTransferService {

	Transaction addTransaction(Integer toAccNo, Integer fromAccNo, Transaction tran, String transPassword);
}
