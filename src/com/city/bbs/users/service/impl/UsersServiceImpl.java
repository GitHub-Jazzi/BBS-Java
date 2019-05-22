package com.city.bbs.users.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.city.bbs.users.dao.impl.UsersDaoImpl;
import com.city.bbs.users.factory.DaoFactory;
import com.city.bbs.users.model.UsersModel;
import com.city.bbs.users.service.IUsersService;
import com.mysql.fabric.Response;

public class UsersServiceImpl implements IUsersService {

	private UsersDaoImpl dao=null;
	
	public UsersServiceImpl(){
		try {
			this.dao=(UsersDaoImpl) DaoFactory.createUsersDao();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int UserIsExist(String mail) {
		String pass=this.dao.query(mail);
		if(pass!=null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int PassIsTrue(String mail, String pass) {
		String pass2=this.dao.query(mail);
		
		if(pass2.equals(pass)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int numOfUser() {
		return this.dao.numOfUser();
	}

	@Override
	public void loadAllPic() {
		List<UsersModel> users=this.AllOfUser();
		File dir=new File("C:\\Users\\¿Ó–§—Ù\\Desktop\\pic");
		//System.out.println(dir.getAbsolutePath());
		if(!dir.exists()) {
			dir.mkdir();
		
		}
		for(UsersModel i: users) {
			try {
				//System.out.println(i.getMail());
				File file=new File("C:\\Users\\¿Ó–§—Ù\\Desktop\\pic\\"+i.getMail()+".jpg");
				if(!file.exists()){
					file.createNewFile();
					FileOutputStream o=new FileOutputStream(file);
					try {
						o.write(i.getPic());
						o.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		

	}

	@Override
	public void add(String mail, String passworld, byte[] pic) {
		this.dao.add(mail, passworld, pic);

	}

	@Override
	public UsersModel objFromMail(String mail) {
		return this.dao.objFromMail(mail);
	}

	@Override
	public List<UsersModel> AllOfUser() {
		return this.dao.AllOfUser();
	}

	@Override
	public void update(String mail, String mm) {
		this.dao.update(mail, mm);

	}

}
