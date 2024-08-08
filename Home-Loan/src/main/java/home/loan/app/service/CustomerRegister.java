package home.loan.app.service;

import home.loan.app.dto.UserDetailsDto;
import home.loan.app.entity.UserDetails;

public interface CustomerRegister {
	UserDetails register(UserDetails uDetails);

	UserDetails findByName(UserDetailsDto userDetails);

	UserDetails findByName(String uName);

}
