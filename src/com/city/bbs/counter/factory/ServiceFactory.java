package com.city.bbs.counter.factory;

import com.city.bbs.counter.service.ICounterService;
import com.city.bbs.counter.service.impl.CounterServiceImpl;

public class ServiceFactory {
	public static ICounterService createCounterService() {
		return new CounterServiceImpl();
	}
}
