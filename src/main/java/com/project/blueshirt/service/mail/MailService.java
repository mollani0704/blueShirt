package com.project.blueshirt.service.mail;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MailService {
	
	private final  JavaMailSender emailSender;
	private int authNumber;
	
	public void makeRandomNumber() {
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		log.info("인증번호 = {}", checkNum);
		authNumber = checkNum;
	}
	
	public String joinEmail(String email) {
		makeRandomNumber();
		String setFrom = "smtp.naver.com";
		String toEmail = email;
		String title = "비밀번호 찾기 인증 이메일입니다.";
		String content = 
				"청남방 비밀번호 찾기 메일입니다." +
				"<br>" +
				"인증 번호는 " + authNumber + "입니다.";
		mailSend(setFrom, toEmail, title, content);
		return Integer.toString(authNumber);
	}
	
	private void mailSend(String setFrom, String toEmail, String title, String content) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toEmail);
			helper.setSubject(title);
			helper.setText(content, true);
			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

