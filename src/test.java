

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.bbs.counter.dao.impl.CounterDaoImpl;
import com.city.bbs.counter.model.CounterModel;
import com.city.bbs.counter.service.impl.CounterServiceImpl;
import com.city.bbs.manage.dao.impl.ManageDaoImpl;
import com.city.bbs.manage.service.impl.ManageServiceImpl;
import com.city.bbs.module.dao.impl.ModuleDaoImpl;
import com.city.bbs.module.service.impl.ModuleServiceImpl;
import com.city.bbs.note.dao.impl.NoteDaoImpl;
import com.city.bbs.note.service.impl.NoteServiceImpl;
import com.city.bbs.users.dao.impl.UsersDaoImpl;
import com.city.bbs.users.model.UsersModel;
import com.city.bbs.users.service.impl.UsersServiceImpl;





import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 /*
		int id=12;
		java.util.Date date = new java.util.Date();   // 获取当前时间
		Timestamp timeStamp = new Timestamp(date.getTime());
		//java.sql.Date sql_date = new java.sql.Date(date.getTime()); //转换成java.sql.Date 这个存不进毫秒
		a.addReplyNote(id, "1", "11", timeStamp, "1@qq.com");*/
		
		  try {
		        Properties properties = new Properties();
		        properties.put("mail.transport.protocol", "smtp");// 连接协议
		        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
		        properties.put("mail.smtp.port", 465);// 端口号
		        properties.put("mail.smtp.auth", "true");
		        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
		        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
		        // 得到回话对象
		        Session session = Session.getInstance(properties);
		        // 获取邮件对象
		        Message message = new MimeMessage(session);
		        // 设置发件人邮箱地址
		       
					message.setFrom(new InternetAddress("815956033@qq.com"));
				
		        // 设置收件人邮箱地址 
		     
					message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("815956033@qq.com")});
				
		        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
		        // 设置邮件标题
		        message.setSubject("恭喜你创建了一个账号");
		        // 设置邮件内容
		        message.setText("邮件内容邮件内容邮件内容xmqtest");
		        // 得到邮差对象
		        Transport transport = session.getTransport();
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

		
			

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
