package in.co.vwits.onlinebanking.service.impl;

import static in.co.vwits.onlinebanking.utils.Constants.AMOUNT_CREDITED_EMAIL_TEMPLATE;
import static in.co.vwits.onlinebanking.utils.Constants.AMOUNT_DEBITED_EMAIL_TEMPLATE;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import freemarker.template.TemplateException;
import in.co.vwits.onlinebanking.entity.Account;
import in.co.vwits.onlinebanking.entity.Transaction;
import in.co.vwits.onlinebanking.repository.AccountRepository;
import in.co.vwits.onlinebanking.repository.TransactionRepository;
import in.co.vwits.onlinebanking.service.EmailService;
import in.co.vwits.onlinebanking.service.FundTransferService;

@CrossOrigin
@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	EmailService emailService;

	@Override
	public Transaction addTransaction(Integer toAccNo, Integer fromAccNo, Transaction tran, String tranPassword) {

		Account toAccount = accountRepo.getById(toAccNo);
		Account fromAccount = accountRepo.getById(fromAccNo);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// Validation -----> The Balance amount should be greater than the Amount
		// Transfered
		if (fromAccount.getCurrentBalance() >= tran.getAmounttransferred()
				&& encoder.matches(tranPassword, fromAccount.getTransectionPassword())) {
			tran.setAccountto(toAccount);
			tran.setAccountfrom(fromAccount);
			tran.setTransactiondate(LocalDateTime.now());
			transactionRepo.save(tran);
			// Taking the amount transfered
			int amt = tran.getAmounttransferred();
	

			// Also crediting and debiting the amount from the accounts
			toAccount.setCurrentBalance(toAccount.getCurrentBalance() + amt);
			fromAccount.setCurrentBalance(fromAccount.getCurrentBalance() - amt);
			accountRepo.flush();

			// Mailing the details of the transaction to the Respective Account Numbers

			try {
				emailService.sendEmail(tran, AMOUNT_CREDITED_EMAIL_TEMPLATE,
						tran.getAmounttransferred() + " is Credited", toAccount.getCustomer().getEmail());
			} catch (MessagingException | IOException | TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				emailService.sendEmail(tran, AMOUNT_DEBITED_EMAIL_TEMPLATE, tran.getAmounttransferred() + " is Debited",
						fromAccount.getCustomer().getEmail());
			} catch (MessagingException | IOException | TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return tran;
		}

		// If Balance is less than the Amount Transfered
		else if (fromAccount.getCurrentBalance() < tran.getAmounttransferred()) {
			return null;
		} else
			return null;

	}

}
