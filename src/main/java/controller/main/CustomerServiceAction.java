package controller.main;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.ActionForward;

public class CustomerServiceAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		//Notice.jsp의 form태그 파라미터값
		final String userMessage = request.getParameter("message"); //문의 내용
		final String userName = request.getParameter("name"); //발신자 이름
		final String userEmail = request.getParameter("email"); // 발신자 이메일주소
		
		
		String host = "smtp.naver.com"; // 사용할 사이트
		final String fromEmail = "jdaaaaun1@naver.com"; // 이메일api사용할 네이버ID
		final String password = "jung000422"; // 이메일api사용할 비밀번호
		
		final String toEmail = "berean2000@naver.com";// 이메일 발송 시 수신할 이메일
				
		
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// Subject
			message.setSubject(userName+"님의 문의가 도착했습니다"); 

			// Text
			message.setText("문의자 : "+userName+"\n문의 내용 : "+userMessage);

			// send the message
			Transport.send(message);
			System.out.println("이메일 전송 성공!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		Properties props1 = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session1 = Session.getDefaultInstance(props1, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session1);
			message.setFrom(new InternetAddress(fromEmail));				 //발신자 이메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

			// Subject
			message.setSubject("문의가 접수되었습니다."); //이메일 제목

			// Text
			message.setText("문의사항 확인 후 빠르게 답변 드리겠습니다. 감사합니다:)");

			// send the message
			Transport.send(message);
			System.out.println("이메일 전송 성공!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		ActionForward forward=new ActionForward();
		forward.setPath("main.do");

		forward.setRedirect(true);

		return forward;
	}

}