package com.lzsoft.aml.service.sendmail.main.impl;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.lzsoft.aml.dao.DAO;

@Configuration
@EnableScheduling
public class MailApp {

	public static void main(String[] args) {
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("spring-beans.xml");
	}
	
	@Inject
	private MailSender sender;

	@Resource(name = "dao")
	private DAO dao;
	
	/*@Scheduled(cron = "0 5 * * * ?")
	public void sendMail() {
		final List<Message> messages = messageDao.getByFlag();
		
		try {
			for(Message message:messages) {
				sender.send(message);
				message.setFlag("Y");
				message.setSendDate(new Date());
				messageDao.update(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}*/

}