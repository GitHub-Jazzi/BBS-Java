package com.city.bbs.users.service;

import java.util.List;

import com.city.bbs.users.model.UsersModel;

public interface IUsersService {
	int UserIsExist(String mail);
    /*前提是该mail必须存在*/
    public int PassIsTrue(String mail,String pass) ;
    public int numOfUser();
    
    /*将数据库中所有用户头像以  xx@qq.com.jpg形式保存在默认目录下的pic文件夹下*/
    public void loadAllPic();
    
    /**/
    public void add(String mail,String passworld,byte[] pic);
    
    public UsersModel objFromMail(String mail);
    public List<UsersModel> AllOfUser();
    public void update(String mail,String mm);
}
