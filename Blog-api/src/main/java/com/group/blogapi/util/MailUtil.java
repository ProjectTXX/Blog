package com.group.blogapi.util;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
 
/**
 * 发送邮件的工具类
 * @author duan ss
 *
 */
@Component
public class MailUtil {
 
	@Autowired
	private JavaMailSender javaMailSender;
 
	/**
	 * 发送邮件
	 * @param toUser	收件人
	 * @param code		激活码
	 * @return
	 */
	public String send(String toUser, String code) {
 
		// 建立邮件消息
		SimpleMailMessage mainMessage = new SimpleMailMessage();
 
		// 发送者
		mainMessage.setFrom("19720136955@163.com");
 
		// 接收者
		mainMessage.setTo(toUser);
 
		// 发送的标题
		mainMessage.setSubject("这是项目组博客的注册验证码");
 
		// 发送的内容
		mainMessage.setText("验证码为: " + code + ".其有效时间为五分钟");
 
		javaMailSender.send(mainMessage);
 
		return "验证码已成功发送";
	}
 
}