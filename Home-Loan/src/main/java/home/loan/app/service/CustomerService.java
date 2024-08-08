package home.loan.app.service;

import java.util.List;

import home.loan.app.entity.Customer;

public interface CustomerService {

	Customer register(Customer customerList);

	List<Customer> findAll();

	Customer findById(int id);

}