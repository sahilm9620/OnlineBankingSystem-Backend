package in.co.vwits.onlinebanking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.vwits.onlinebanking.entity.Payee;

@Service
public interface PayeeService {
	Payee insertPayeeService(Integer accNo, Payee payee);

	List<Payee> selectPayeeService(Integer AccNo);

	List<Payee> selectAllPayeeService();

	Payee deletePayeeService(Integer BeneficiaryId);
}
