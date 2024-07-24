package home.loan.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.loan.app.entity.HomeLoan;

@Repository
public interface HomeLoanRepository extends JpaRepository<HomeLoan, Long> {
}

