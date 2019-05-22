package com.city.bbs.users.dao;

import java.util.List;

import com.city.bbs.users.model.UsersModel;

public interface IUsersDao {
	public void add(String mail,String passworld, byte[]pic);
    public void modify(String mail,String newPassworld);
    public void delete(String mail);
    
    /*����ָ��mail������*/
    public String query(String mail);
    
    /*����һ������*/
    public int numOfUser();
    
    /*����mail���ظ��û�����*/
    public UsersModel mailToUser(String mail);
    
    /*���������û���������*/
    public List<UsersModel> AllOfUser();
    
    public UsersModel objFromMail(String mail);
    
    public void update(String mail,String mm);
}
