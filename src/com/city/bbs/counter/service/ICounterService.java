package com.city.bbs.counter.service;

import com.city.bbs.counter.model.CounterModel;

public interface ICounterService {
	
	/*返回访问对象*/
    CounterModel retTimes();
    void addMor();
    void addEve();
    void addNig();
    void addNoo();
}
