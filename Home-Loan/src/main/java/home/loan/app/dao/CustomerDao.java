package home.loan.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.loan.app.entity.Customer;
import home.loan.app.entity.Loan;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	Loan save(Loan loan);
}	