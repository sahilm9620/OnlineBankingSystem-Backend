package in.co.vwits.onlinebanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Payee;
import in.co.vwits.onlinebanking.repository.AccountRepository;
import in.co.vwits.onlinebanking.repository.PayeeRepository;
import in.co.vwits.onlinebanking.service.PayeeService;

@CrossOrigin
@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	PayeeRepository payeeRepo;

	@Autowired
	AccountRepository accountRepo;

	@Override
	public Payee insertPayeeService(Integer accNo, Payee payee) {
		Account account = accountRepo.getById(accNo);
		payee.setAccount(account);
		payeeRepo.saveAndFlush(payee);
		return payee;
	}

	@Override
	public List<Payee> selectPayeeService(Integer AccNo) {
		List<Payee> list = payeeRepo.findAll();
		List<Payee> flist = new ArrayList<Payee>();
		for (Payee p : list) {
			if (p.getAccount().getAccountnumber() == AccNo) {
				flist.add(p);
			}
		}
		return flist;
	}

	@Override
	public List<Payee> selectAllPayeeService() {

		return payeeRepo.findAll();
	}

	@Override
	public Payee deletePayeeService(Integer BeneficiaryId) {
		Payee payeeToBeDeleted = payeeRepo.findById(BeneficiaryId).get();
		payeeRepo.delete(payeeToBeDeleted);
		payeeRepo.flush();
		return payeeToBeDeleted;
	}

}
