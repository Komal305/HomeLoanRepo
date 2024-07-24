package home.loan.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.loan.app.entity.HomeLoanOffering;

@Repository
public interface HomeLoanOfferingRepository extends JpaRepository<HomeLoanOffering, Long> {
}

