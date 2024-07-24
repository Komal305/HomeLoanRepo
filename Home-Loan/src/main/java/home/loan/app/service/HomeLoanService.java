package home.loan.app.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.loan.app.entity.HomeLoan;
import home.loan.app.entity.HomeLoanOffering;
import home.loan.app.entity.HomeLoanRequest;
import home.loan.app.entity.User;
import home.loan.app.repo.HomeLoanOfferingRepository;
import home.loan.app.repo.HomeLoanRepository;
import home.loan.app.repo.UserRepository;

@Service
public class HomeLoanService {

    @Autowired
    private HomeLoanOfferingRepository homeLoanOfferingRepository;

    @Autowired
    private HomeLoanRepository homeLoanRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Get all home loan offerings.
     *
     * @return List of home loan offerings.
     */
    public List<HomeLoanOffering> getAllLoanOfferings() {
        return homeLoanOfferingRepository.findAll();
    }
    
    public HomeLoan getLoanDetails(Long loanId, String username) {
        Optional<HomeLoan> loan = homeLoanRepository.findById(loanId);
        if (loan.isPresent() && loan.get().getUser().getUsername().equals(username)) {
            return loan.get();
        } else {
            throw new IllegalArgumentException("Loan not found or not authorized to view this loan");
        }
    }

    
    public HomeLoan applyForLoan(HomeLoanRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        HomeLoan newLoan = new HomeLoan();
        newLoan.setUser(user);
        newLoan.setLoanAmount(request.getLoanAmount());
        newLoan.setLoanType(request.getLoanType());
        newLoan.setNomineeDetails(request.getNomineeDetails());
        newLoan.setLoanTenure(request.getLoanTenure());
        newLoan.setRateOfInterest(request.getRateOfInterest());
        newLoan.setPrincipalOutstanding(request.getLoanAmount());
        newLoan.setOutstandingEmiCount(calculateEmiCount(request.getLoanAmount(), request.getRateOfInterest(), request.getLoanTenure()));

        return homeLoanRepository.save(newLoan);
    }

    /**
     * Calculate EMI count based on loan amount, rate of interest, and tenure.
     *
     * @param loanAmount    Loan amount.
     * @param rateOfInterest Rate of interest.
     * @param loanTenure    Loan tenure.
     * @return Calculated EMI count.
     */
    public int calculateEmiCount(double loanAmount, double rateOfInterest, int loanTenure) {
        // Implement EMI calculation logic here
        // For simplicity, returning a fixed value
        return loanTenure * 12;
    }
}

