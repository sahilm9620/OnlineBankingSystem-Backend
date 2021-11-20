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
public class PayeeController {

	@Autowired
	PayeeService payeeService;
	
	//Show All Payee on bases of Account Number
	@GetMapping
	@RequestMapping(value = "payee/{accNo}")
	public List<Payee> getPayee(@PathVariable("accNo") int accNo) {
		System.out.println("Select Payee......................................called");
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
	@RequestMapping(value = "payee/{accNo}", consumes="application/json")
	public Payee addPayee(@PathVariable("accNo") int accNo , @RequestBody Payee payee) {
		System.out.println("addPayee()...method ");
		return payeeService.insertPayeeService(accNo,payee);
	}
	
	
	//Deleting of Payee
	@DeleteMapping
	@RequestMapping(value="payee/delete/{beneficiaryId}")
	public Payee deletePayee(@PathVariable("beneficiaryId") int beneficiaryId) {
		System.out.println("Delete payeeeeee...................... added");
		return payeeService.deletePayeeService(beneficiaryId);
	}
}
