package com.city.bbs.module.service.impl;

import java.util.List;

import com.city.bbs.module.dao.impl.ModuleDaoImpl;
import com.city.bbs.module.factory.DaoFactory;
import com.city.bbs.module.model.ModuleModel;
import com.city.bbs.module.service.IModuleService;

public class ModuleServiceImpl implements IModuleService {

	private ModuleDaoImpl pdo=null;
	public ModuleServiceImpl() {
		try {
			this.pdo=(ModuleDaoImpl) DaoFactory.createModuleDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int theNumOfModule() {
		return this.pdo.query().size();
	}

	@Override
	public List<ModuleModel> allOfModule() {
		return this.pdo.query();
	}

	@Override
	public ModuleModel idOfModule(int id) {
		return this.pdo.idOfModule(id);
	}

	@Override
	public void add(String module_name, String module_cont, String user_name, String cs_pic, String cs_color) {
		this.pdo.add(module_name, module_cont, user_name, cs_pic, cs_color);

	}

}
