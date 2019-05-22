package com.city.bbs.manage.factory;

import com.city.bbs.manage.service.IManageService;
import com.city.bbs.manage.service.impl.ManageServiceImpl;

public class ServiceFactory {
	public static IManageService createManageService() {
		return new ManageServiceImpl();
	}
}
