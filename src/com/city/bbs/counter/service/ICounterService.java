package com.city.bbs.counter.service;

import com.city.bbs.counter.model.CounterModel;

public interface ICounterService {
	
	/*���ط��ʶ���*/
    CounterModel retTimes();
    void addMor();
    void addEve();
    void addNig();
    void addNoo();
}
