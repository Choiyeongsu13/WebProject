package com.mnu.sample.service.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.service.Action;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;



//회원가입 본인 sms 인증
public class UserWriteSMSService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String phone = request.getParameter("phone");
			      System.out.println("phone : " + phone);
			      
			      // 1. 랜덤 인증번호 생성 (1000 ~ 9999)
			        int randomCode = (int)(Math.random() * 8999) + 1000;
			        
			       // 2. 발송 로직 (CoolSMS)
			        DefaultMessageService messageService = 
			              NurigoApp.INSTANCE.initialize("NCS59JQNDELNIXJG", "R39J4DMZ3VG5NLBZH0QJUY1I4MBR3Z2I", "https://api.coolsms.co.kr");
			        
			        Message message = new Message();
			        message.setFrom("01093085092"); // [중요] 내 발신번호 (하이픈 제외)
			        message.setTo(phone.replaceAll("-", "")); 
			        message.setText("[exUser] 인증번호: " + randomCode);

			        // 실제 전송 (비용 발생)
			        messageService.sendOne(new SingleMessageSendingRequest(message));
			        System.out.println(">> [CoolSMS] 문자 전송 완료!");
			   
			        response.getWriter().append(String.valueOf(randomCode));
			   }


	}


