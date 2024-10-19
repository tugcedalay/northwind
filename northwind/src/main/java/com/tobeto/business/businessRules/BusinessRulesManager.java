package com.tobeto.business.businessRules;

import org.springframework.stereotype.Service;

@Service
public class BusinessRulesManager implements BusinessRulesService{

	@Override
	public boolean passwordsCheck(String password, String confirmPassword) {
		// TODO Auto-generated method stub
		return password.equals(confirmPassword);
	}

	@Override
	public String splitDomainName(String email) {
		
		String[] parts = email.split("@");
		
		if (parts.length == 2) {
			return parts[1];
		}else {
			throw new IllegalArgumentException("Invalid email format");
		}
	}

}
