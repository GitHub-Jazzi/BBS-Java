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
	
		
		
		
		//1������һ��DiskFileItemFactory����       
		DiskFileItemFactory factory = new DiskFileItemFactory();      
		//2������һ���ļ��ϴ�������       
		ServletFileUpload upload = new ServletFileUpload(factory);    
	
		try {			
			// 1. �õ� FileItem �ļ��� items		
			RequestContext rc=new ServletRequestContext(request);
			
			List<FileItem> items = upload.parseRequest( rc); 			
			// 2. ���� items:	
			
			for (FileItem item : items) {		
				// ����һ��һ��ı���, ��ӡ��Ϣ	
				if (item.isFormField()) {				
					String name = item.getFieldName();
					String value = item.getString("utf-8"); 
					request.setAttribute(name, value);
					//System.out.println(name + ": " + value);
				}				
				// �����ļ�������ļ����浽 e:\\files Ŀ¼��.		
				else {				
					String fileName = item.getName();	
					long sizeInBytes = item.getSize();
					
					//System.out.println(fileName);		
					//System.out.println(sizeInBytes); 	
					InputStream in = item.getInputStream();		
					byte[] buffer = new byte[1024];				
					int len = 0; 					
					fileName = "D:\\1.jpg";//�ļ������ϴ���λ��	
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
		
	        //������ʾ�ոմ������˺�
	        HttpSession session =request.getSession();
	        session.setAttribute("create_user",ServiceFactory.createUserService().objFromMail(request.getAttribute("mail").toString()) );
	        
	        
	        //�����ݿ���������ͼƬ
	        ServiceFactory.createUserService().loadAllPic();
	    
	        String mail=request.getAttribute("mail").toString();
	        String pass=request.getAttribute("password").toString();
	        
	        
	        
	        
	        
	        
	        /*********************************************/
	        try {
		        Properties properties = new Properties();
		        properties.put("mail.transport.protocol", "smtp");// ����Э��
		        properties.put("mail.smtp.host", "smtp.qq.com");// ������
		        properties.put("mail.smtp.port", 465);// �˿ں�
		        properties.put("mail.smtp.auth", "true");
		        properties.put("mail.smtp.ssl.enable", "true");// �����Ƿ�ʹ��ssl��ȫ���� ---һ�㶼ʹ��
		        properties.put("mail.debug", "true");// �����Ƿ���ʾdebug��Ϣ true ���ڿ���̨��ʾ�����Ϣ
		        // �õ��ػ�����
		        Session session1 = Session.getInstance(properties);
		        // ��ȡ�ʼ�����
		        Message message = new MimeMessage(session1);
		        // ���÷����������ַ
		       
					message.setFrom(new InternetAddress("815956033@qq.com"));
				
		        // �����ռ��������ַ 
		     
					message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(mail)});
				
		        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//һ���ռ���
		        // �����ʼ�����
		        message.setSubject("��ϲ�㴴����һ���˺�");
		        // �����ʼ�����
		        message.setText("���룺"+mail+"  �˺�: "+pass);
		        // �õ��ʲ����
		        Transport transport = session1.getTransport();
		        // �����Լ��������˻�
		        transport.connect("815956033@qq.com", "sitsohjwkgdabeea");// ����ΪQQ���俪ͨ��stmp�����õ��Ŀͻ�����Ȩ��
		        // �����ʼ�
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
