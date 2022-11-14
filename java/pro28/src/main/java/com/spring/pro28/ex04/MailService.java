package com.spring.pro28.ex04;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage preConfiguredMessage;

	@Async //동기식 비동기식 통신 관련
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage(); //MimeMessage 타입 객체 생성
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				//메일을 보내기 위해 MimeMessageHelper 객체를 생성함
				//messageHelper.setCc("dyj02159@naver.com");
				messageHelper.setFrom("dyj02159@naver.com", "이정규");
				messageHelper.setSubject(subject);
				messageHelper.setTo(to);
				messageHelper.setText(body,true); 
				//메일 내용이 html로 표시되게 하려면 반드시 MimeMessageHelper의 setText메서드의 두번째 인자값을 true로 설정해야함
				mailSender.send(message);
				//제목, 수신처, 내용등을 설정해 메일을 보냄
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	@Async
	public void sendPreConfiguredMail(String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	 }
	}