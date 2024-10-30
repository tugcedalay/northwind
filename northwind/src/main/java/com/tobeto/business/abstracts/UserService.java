package com.tobeto.business.abstracts;

import com.tobeto.core.entities.User;
import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	
	DataResult<User> findByEmail(String email);
	
	
}
