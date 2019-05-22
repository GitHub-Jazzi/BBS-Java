package com.city.bbs.manage.service.impl;

import com.city.bbs.manage.dao.impl.ManageDaoImpl;
import com.city.bbs.manage.factory.DaoFactory;
import com.city.bbs.manage.service.IManageService;


public class ManageServiceImpl implements IManageService {

	private ManageDaoImpl pdo=null;
	
	public ManageServiceImpl() {
		try {
			this.pdo=(ManageDaoImpl) DaoFactory.createManageDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int PassIsTrue(String mail, String pass) {
		String ans=this.pdo.query(mail);
		if(ans!=null&&ans.equals(pass)){
            return 1;
        }
        return 0;
	}

}
