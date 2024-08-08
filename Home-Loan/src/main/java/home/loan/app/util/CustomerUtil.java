package home.loan.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import home.loan.app.dto.CustomerDetailsDto;
import home.loan.app.entity.Customer;

@Component
public class CustomerUtil {

	public CustomerDetailsDto toDetails(Customer customer) {
		return new CustomerDetailsDto(customer.getId(), customer.getName(), customer.getMobileNumber(), 
					customer.getEmaild(), customer.getDob(), customer.getGender(), customer.getNationality(), 
					customer.getAadharNumber(), customer.getPan());
	}

	public List<CustomerDetailsDto> toDetails(List<Customer> customers) {
		List<CustomerDetailsDto> custList = new ArrayList<>();
		for (Customer customer: customers) {
			CustomerDetailsDto details = toDetails(customer);
//			System.out.println(details);
			custList.add(details);
		}
		return custList;
	}

}