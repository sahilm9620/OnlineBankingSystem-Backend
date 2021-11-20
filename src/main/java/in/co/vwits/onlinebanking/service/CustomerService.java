package in.co.vwits.onlinebanking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.vwits.onlinebanking.entity.Customer;

@Service
public interface CustomerService {
	Customer addCustomer(Customer customerToBeAdded);
	Customer getCustomer(Integer customerId);
	List<Customer> getAllCustomer();
}
