package com.city.bbs.module.dao;

import java.util.List;

import com.city.bbs.module.model.ModuleModel;

public interface IModuleDao {

	 	List<ModuleModel> query();
	 	
	 	ModuleModel idOfModule(int id);
	 	
	    void  add(String module_name,String module_cont,String user_name,
	    		String cs_pic,String cs_color);
}
