import java.lang.System.Logger.Level;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.*;

//import com.sun.tools.sjavac.Log.Level;

public class SendEmail {
	
	 static OTP key = new OTP();
	 static String ss=key.generateOTP();
	 
	 
	
   public static String sendMail(String recepient) throws MessagingException {
	
	Properties prop=new Properties();
	
	
    prop.put("mail.smtp.auth","true");
	prop.put("mail.smtp.starttls.enable","true");
	prop.put("mail.debug", "true");
	prop.put("mail.smtp.host","smtp.gmail.com");
	prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	prop.put("mail.smtp.port","587");
	// prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	// prop.put("mail.transport.protocol", "smtp");
	   // prop.put("mail.smtp.socketFactory.fallback", "false");
	
	 String MyAccount="emailid@gmail.com";
	 String password="yourpasswordforemail";
	
	Session session=Session.getInstance(prop,new Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(MyAccount,password);
	}
	});
	Message msg=prepareMessage(session,MyAccount,recepient);
	
	Transport.send(msg);
	//return null;
	
	return ss;
	
	
	}

	private static  Message prepareMessage(Session session, String myAccount, String recepient) {
		// TODO Auto-generated method stub
		try {
			Message msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(myAccount));
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
			msg.setSubject("Hey there,note down your secret key from File Security");
			msg.setText("key is "+ss);
			//msg.setText("testing....");
			return msg;
			
		}
		catch(Exception e) {
			Logger.getLogger(SendEmail.class.getName()).log(java.util.logging.Level.SEVERE,null,e);
		}
		return null;
	}
	

}
