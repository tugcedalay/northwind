package com.tobeto.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import com.tobeto.business.abstracts.UserService;
import com.tobeto.core.dataAccess.UserDao;
import com.tobeto.core.entities.User;
import com.tobeto.core.utilities.results.DataResult;
import com.tobeto.core.utilities.results.Result;
import com.tobeto.core.utilities.results.SuccessDataResult;
import com.tobeto.core.utilities.results.SuccessResult;


public class UserManager implements UserService {
    
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("user added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email)
				,"User find");
	}

}
