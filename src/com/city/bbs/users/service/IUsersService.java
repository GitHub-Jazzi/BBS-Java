package com.city.bbs.users.service;

import java.util.List;

import com.city.bbs.users.model.UsersModel;

public interface IUsersService {
	int UserIsExist(String mail);
    /*ǰ���Ǹ�mail�������*/
    public int PassIsTrue(String mail,String pass) ;
    public int numOfUser();
    
    /*�����ݿ��������û�ͷ����  xx@qq.com.jpg��ʽ������Ĭ��Ŀ¼�µ�pic�ļ�����*/
    public void loadAllPic();
    
    /**/
    public void add(String mail,String passworld,byte[] pic);
    
    public UsersModel objFromMail(String mail);
    public List<UsersModel> AllOfUser();
    public void update(String mail,String mm);
}
