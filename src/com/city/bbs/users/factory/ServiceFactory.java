package com.city.bbs.users.factory;

import com.city.bbs.users.service.IUsersService;
import com.city.bbs.users.service.impl.UsersServiceImpl;

public class ServiceFactory {
	public static IUsersService createUserService() {
		return new UsersServiceImpl();
	}
}
