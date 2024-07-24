package home.loan.app.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Data
public class HomeLoanRequest {
    private double loanAmount;
    private String loanType;
    private String nomineeDetails;
    private int loanTenure;
    private double rateOfInterest;

    // Getters and Setters
}
