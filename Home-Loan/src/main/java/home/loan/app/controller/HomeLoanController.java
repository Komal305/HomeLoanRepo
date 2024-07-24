package home.loan.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.loan.app.entity.HomeLoan;
import home.loan.app.entity.HomeLoanOffering;
import home.loan.app.entity.HomeLoanRequest;
import home.loan.app.service.HomeLoanService;

@RestController
@RequestMapping("/api/loans")
public class HomeLoanController {

    @Autowired
    private HomeLoanService homeLoanService;

    @GetMapping("/offerings")
    public List<HomeLoanOffering> getLoanOfferings() {
        return homeLoanService.getAllLoanOfferings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeLoan> getLoanDetails(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(homeLoanService.getLoanDetails(id, principal.getName()));
    }

    @PostMapping("/apply")
    public ResponseEntity<HomeLoan> applyForLoan(@RequestBody HomeLoanRequest request, Principal principal) {
        return ResponseEntity.ok(homeLoanService.applyForLoan(request, principal.getName()));
    }
}
