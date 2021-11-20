package in.co.vwits.onlinebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.onlinebanking.entity.Customer;
import in.co.vwits.onlinebanking.service.CustomerService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping
	@RequestMapping(value = "customer/{CustId}")
	public Customer getCustomer(@PathVariable("CustId") int CustId) {
		return customerService.getCustomer(CustId);
	}
	
	

	@GetMapping
	@RequestMapping(value = "customer")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomer();
	}

	
	//Adds a customer
	@PostMapping
	@RequestMapping(value="customer/add", consumes="application/json")
	public Customer addCustomerService(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
}
