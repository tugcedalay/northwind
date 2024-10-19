package com.tobeto.business.businessRules;

public interface BusinessRulesService {
    boolean passwordsCheck(String password, String confirmPassword);
    
    String splitDomainName(String email);
}
