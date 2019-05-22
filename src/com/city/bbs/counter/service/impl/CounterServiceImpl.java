package com.city.bbs.counter.service.impl;

import com.city.bbs.counter.dao.impl.CounterDaoImpl;
import com.city.bbs.counter.factory.DaoFactory;
import com.city.bbs.counter.model.CounterModel;
import com.city.bbs.counter.service.ICounterService;

public class CounterServiceImpl implements ICounterService {

	private CounterDaoImpl pdo=null;
	public CounterServiceImpl(){
		try {
			this.pdo=(CounterDaoImpl) DaoFactory.createCounterDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public CounterModel retTimes() {
		return this.pdo.query();
	}

	@Override
	public void addMor() {
		CounterModel obj=this.pdo.query();
		int a=obj.getMorning();
		this.pdo.updateMorning(a+1);

	}

	@Override
	public void addEve() {
		CounterModel obj=this.pdo.query();
		int a=obj.getEvening();
		this.pdo.updateEvening(a+1);


	}

	@Override
	public void addNig() {
		CounterModel obj=this.pdo.query();
		int a=obj.getNight();
		this.pdo.updateNight(a+1);


	}

	@Override
	public void addNoo() {
		CounterModel obj=this.pdo.query();
		int a=obj.getNoon();
		this.pdo.updateNoon(a+1);
	}

}
