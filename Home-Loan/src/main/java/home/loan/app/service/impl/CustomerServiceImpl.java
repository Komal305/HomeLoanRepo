package home.loan.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.loan.app.config.exception.CustomerAlreadyExistsException;
import home.loan.app.config.exception.CustomerNotFoundException;
import home.loan.app.config.exception.NoDataToDisplayException;
import home.loan.app.dao.CustomerDao;
import home.loan.app.entity.Customer;
import home.loan.app.service.CustomerService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;
	
	private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public Customer register(Customer customer) {
		logger.info("Adding Customer.....");
		boolean exists = customer.getId()!=null && dao.existsById(customer.getId());
		if(exists) {
			logger.error("Customer already exists for id = " + customer.getId());;
			throw new CustomerAlreadyExistsException("Customer already exists for id = " + customer.getId());
		}
		customer = dao.save(customer);
		logger.info("Customer added : " + customer);
		System.out.println("Returning saved value: " + customer);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		logger.info("Display all customers.......");
		System.out.println(dao.getClass().getName());
		List<Customer> list = dao.findAll();
		if(list.size() < 1) {
			logger.info("No Data");
			throw new NoDataToDisplayException("No Data");
		}
		logger.info("All customers displayed");
		return list;
	}

	@Override
	public Customer findById(int id) {
		logger.info("Finding customer by id : " + id);
		Optional<Customer> opt = dao.findById(id);
		if(!opt.isPresent()) {
			System.out.println("Error");
			logger.error("Customer Doesn't exist with id : " + id);
			throw new CustomerNotFoundException("Customer Doesn't exist with id : " + id);
		}
		logger.info("Found customer by id : " + id);
		Customer customer = opt.get();
		System.out.println(customer);
		return customer;
	}
	

}