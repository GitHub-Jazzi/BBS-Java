package com.city.bbs.module.factory;

import com.city.bbs.module.service.IModuleService;
import com.city.bbs.module.service.impl.ModuleServiceImpl;

public class ServiceFactory {
	public static IModuleService createModuleService() {
		return new ModuleServiceImpl();
	}
}
