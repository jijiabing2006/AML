package com.lzsoft.aml.service.sendmail.main.impl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lzsoft.aml.common.Constants;

@Service
public class MailSender {

	public void send(String[] receiptaddress, String subject, String message)
			throws IOException, MessagingException {

		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(Constants.eMAIL_HOST);
		sender.setPort(Constants.eMAIL_PORT);

		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,"utf-8");
		helper.setFrom(Constants.eMAIL_FROM);
		helper.setTo(receiptaddress);
		helper.setSubject(subject);
	//	helper.setCc(new String[]{"hsiensay24@cathaybk.com.tw","nt60243@cathaybk.com.tw"});
		helper.setText(message, true);
		sender.send(mimeMessage);
	}

	/**
	 * 得到根目录
	 * 
	 * @return
	 */
	protected String getRootPath() {
		String rootPath = this.getClass().getProtectionDomain().getCodeSource()
				.getLocation().getFile();
		rootPath = rootPath.substring(1);
		if (rootPath.indexOf("WEB-INF") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
		else if (rootPath.indexOf("bin") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("bin"));
		else if (rootPath.indexOf("classes") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("classes"));
		rootPath = rootPath.replaceAll("/", "\\\\");
		return rootPath.replaceAll("%20", " ");
	}

}
