package in.co.vwits.onlinebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.onlinebanking.entity.Payee;
import in.co.vwits.onlinebanking.service.PayeeService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("api")
public class PayeeController {

	@Autowired
	PayeeService payeeService;
	
	//Show All Payee on bases of Account Number
	@GetMapping
	@RequestMapping(value = "payee/{accNo}")
	public List<Payee> getPayee(@PathVariable("accNo") int accNo) {
		return payeeService.selectPayeeService(accNo);
	}

	//Get All Payees of the Bank
	@GetMapping
	@RequestMapping(value = "payee")
	public List<Payee> getAllPayees() {
		return payeeService.selectAllPayeeService();
	}

	//Adding of Payees
	@PostMapping
	@RequestMapping(value = "payee/add/{accNo}", consumes="application/json")
	public Payee addPayee(@PathVariable("accNo") int accNo , @RequestBody Payee payee) {
		return payeeService.insertPayeeService(accNo,payee);
	}
	
	
	//Deleting of Payee
	@DeleteMapping
	@RequestMapping(value="payee/delete/{beneficiaryId}")
	public Payee deletePayee(@PathVariable("beneficiaryId") int beneficiaryId) {
		return payeeService.deletePayeeService(beneficiaryId);
	}
}
