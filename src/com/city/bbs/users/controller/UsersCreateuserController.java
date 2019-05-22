package com.city.bbs.users.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.city.bbs.users.factory.ServiceFactory;
import com.city.bbs.users.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class UsersCreateuserController
 */
@WebServlet("/users/createuser.do")
public class UsersCreateuserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersCreateuserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		//1、创建一个DiskFileItemFactory工厂       
		DiskFileItemFactory factory = new DiskFileItemFactory();      
		//2、创建一个文件上传解析器       
		ServletFileUpload upload = new ServletFileUpload(factory);    
	
		try {			
			// 1. 得到 FileItem 的集合 items		
			RequestContext rc=new ServletRequestContext(request);
			
			List<FileItem> items = upload.parseRequest( rc); 			
			// 2. 遍历 items:	
			
			for (FileItem item : items) {		
				// 若是一个一般的表单域, 打印信息	
				if (item.isFormField()) {				
					String name = item.getFieldName();
					String value = item.getString("utf-8"); 
					request.setAttribute(name, value);
					//System.out.println(name + ": " + value);
				}				
				// 若是文件域则把文件保存到 e:\\files 目录下.		
				else {				
					String fileName = item.getName();	
					long sizeInBytes = item.getSize();
					
					//System.out.println(fileName);		
					//System.out.println(sizeInBytes); 	
					InputStream in = item.getInputStream();		
					byte[] buffer = new byte[1024];				
					int len = 0; 					
					fileName = "D:\\1.jpg";//文件最终上传的位置	
					//System.out.println(fileName);				
					OutputStream out = new FileOutputStream(fileName); 		
					while ((len = in.read(buffer)) != -1) {					
						out.write(buffer, 0, len);				
					} 		
					
					out.close();		
					in.close();				
				}		
			} 		
		} catch (FileUploadException e) {		
			e.printStackTrace();	
		}
		
			
		/********************************************/
		 byte[] buff = null;  
	        try {  
	            File file = new File("D://1.jpg");  
	            FileInputStream fis = new FileInputStream(file);  
	            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
	            byte[] b = new byte[1000];  
	            int n;  
	            while ((n = fis.read(b)) != -1) {  
	                bos.write(b, 0, n);  
	            }  
	            fis.close();  
	            bos.close();  
	            buff = bos.toByteArray();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        /*******************************/
		
	        
	        ServiceFactory.createUserService().add(
	        		request.getAttribute("mail").toString(), 
	        		request.getAttribute("password").toString(), buff);
		
	        //用于显示刚刚创建的账号
	        HttpSession session =request.getSession();
	        session.setAttribute("create_user",ServiceFactory.createUserService().objFromMail(request.getAttribute("mail").toString()) );
	        
	        
	        //从数据库重新载入图片
	        ServiceFactory.createUserService().loadAllPic();
	    
	        String mail=request.getAttribute("mail").toString();
	        String pass=request.getAttribute("password").toString();
	        
	        
	        
	        
	        
	        
	        /*********************************************/
	        try {
		        Properties properties = new Properties();
		        properties.put("mail.transport.protocol", "smtp");// 连接协议
		        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
		        properties.put("mail.smtp.port", 465);// 端口号
		        properties.put("mail.smtp.auth", "true");
		        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
		        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
		        // 得到回话对象
		        Session session1 = Session.getInstance(properties);
		        // 获取邮件对象
		        Message message = new MimeMessage(session1);
		        // 设置发件人邮箱地址
		       
					message.setFrom(new InternetAddress("815956033@qq.com"));
				
		        // 设置收件人邮箱地址 
		     
					message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(mail)});
				
		        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
		        // 设置邮件标题
		        message.setSubject("恭喜你创建了一个账号");
		        // 设置邮件内容
		        message.setText("密码："+mail+"  账号: "+pass);
		        // 得到邮差对象
		        Transport transport = session1.getTransport();
		        // 连接自己的邮箱账户
		        transport.connect("815956033@qq.com", "sitsohjwkgdabeea");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
		        // 发送邮件
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		  }
        catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        RequestDispatcher view =request.getRequestDispatcher("../users/showcreateuser.jsp");
			view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
