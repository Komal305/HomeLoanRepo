package home.loan.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import home.loan.app.dto.LoanDetailsDto;
import home.loan.app.entity.Loan;

@Component
public class LoanUtil {

	public LoanDetailsDto toDetails(Loan loan) {
		return new LoanDetailsDto(loan.getApplicationid(), loan.getDate(), loan.getApplyamount(), loan.getApproveamount(),
				loan.isLandverify(), loan.isFinanceverify(), loan.isAdminapprove(), loan.getStatus(), loan.getId());
	}

	public List<LoanDetailsDto> toDetails(List<Loan> loans) {
		List<LoanDetailsDto> loanList = new ArrayList<>();
		for (Loan loan : loans) {
			LoanDetailsDto details = toDetails(loan);
			loanList.add(details);
		}
		return loanList;
	}

}
