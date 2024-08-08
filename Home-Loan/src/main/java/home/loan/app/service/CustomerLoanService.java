package home.loan.app.service;

import java.util.List;

import home.loan.app.entity.Loan;
import home.loan.app.entity.LoanTracker;

public interface CustomerLoanService {

	Loan findByCustId(int id, int appid);

	Loan register(Loan loan);

	void remove(int applicationid);

	List<Loan> findByCustId(int cid);

	LoanTracker loanTracker(Loan loan);

}
