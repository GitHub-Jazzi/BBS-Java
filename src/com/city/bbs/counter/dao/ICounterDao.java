package com.city.bbs.counter.dao;

import com.city.bbs.counter.model.CounterModel;

public interface ICounterDao {
	
	/*�����ض�counter����*/
    CounterModel query();
    /*����ĳ��ʱ�������*/
    void updateMorning(int count);
    void updateNoon(int count);
    void updateEvening(int count);
    void updateNight(int count);
}
