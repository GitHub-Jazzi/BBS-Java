

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
		java.util.Date date = new java.util.Date();   // ��ȡ��ǰʱ��
		Timestamp timeStamp = new Timestamp(date.getTime());
		//java.sql.Date sql_date = new java.sql.Date(date.getTime()); //ת����java.sql.Date ����治������
		a.addReplyNote(id, "1", "11", timeStamp, "1@qq.com");*/
		
		  try {
		        Properties properties = new Properties();
		        properties.put("mail.transport.protocol", "smtp");// ����Э��
		        properties.put("mail.smtp.host", "smtp.qq.com");// ������
		        properties.put("mail.smtp.port", 465);// �˿ں�
		        properties.put("mail.smtp.auth", "true");
		        properties.put("mail.smtp.ssl.enable", "true");// �����Ƿ�ʹ��ssl��ȫ���� ---һ�㶼ʹ��
		        properties.put("mail.debug", "true");// �����Ƿ���ʾdebug��Ϣ true ���ڿ���̨��ʾ�����Ϣ
		        // �õ��ػ�����
		        Session session = Session.getInstance(properties);
		        // ��ȡ�ʼ�����
		        Message message = new MimeMessage(session);
		        // ���÷����������ַ
		       
					message.setFrom(new InternetAddress("815956033@qq.com"));
				
		        // �����ռ��������ַ 
		     
					message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("815956033@qq.com")});
				
		        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//һ���ռ���
		        // �����ʼ�����
		        message.setSubject("��ϲ�㴴����һ���˺�");
		        // �����ʼ�����
		        message.setText("�ʼ������ʼ������ʼ�����xmqtest");
		        // �õ��ʲ����
		        Transport transport = session.getTransport();
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

		
			

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
