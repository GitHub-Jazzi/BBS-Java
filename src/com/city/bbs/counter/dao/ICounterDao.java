package com.city.bbs.counter.dao;

import com.city.bbs.counter.model.CounterModel;

public interface ICounterDao {
	
	/*返回特定counter对象*/
    CounterModel query();
    /*设置某段时间访问量*/
    void updateMorning(int count);
    void updateNoon(int count);
    void updateEvening(int count);
    void updateNight(int count);
}
