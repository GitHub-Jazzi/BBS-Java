package com.city.bbs.users.dao;

import java.util.List;

import com.city.bbs.users.model.UsersModel;

public interface IUsersDao {
	public void add(String mail,String passworld, byte[]pic);
    public void modify(String mail,String newPassworld);
    public void delete(String mail);
    
    /*返回指定mail的密码*/
    public String query(String mail);
    
    /*返回一个整数*/
    public int numOfUser();
    
    /*根据mail返回该用户对象*/
    public UsersModel mailToUser(String mail);
    
    /*返回所有用户对象数组*/
    public List<UsersModel> AllOfUser();
    
    public UsersModel objFromMail(String mail);
    
    public void update(String mail,String mm);
}
