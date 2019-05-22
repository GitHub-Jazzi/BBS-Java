package com.city.bbs.module.service;

import java.util.List;

import com.city.bbs.module.model.ModuleModel;

public interface IModuleService {
	int theNumOfModule();
    List<ModuleModel> allOfModule();
    ModuleModel idOfModule(int id);
    void add(String module_name,String module_cont,String user_name,String cs_pic,String cs_color);
}
