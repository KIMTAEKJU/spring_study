package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * request mapping : type 단독 
 */

@Controller
@RequestMapping("/guestbook/*") // 위에 해줬다고해서 핸들러 메소드에 매핑안해주면 안됨
								// * : 뒤에있는 url을 핸들러 이름으로 하겠다
								// 핸들러 메소드에는 반드시 @RequestMapping이 붙어있어야한다
public class GuestbookController 
{
	public void commonFunction()
	{
		
	}
	
	@ResponseBody
	@RequestMapping
	public String list()
	{
		return "GuestbookController:list()";
	}
	
	@ResponseBody
	@RequestMapping
	public String add()
	{
		return "GuestbookController:add()";
	}
	
	
	@ResponseBody
	@RequestMapping
	public String delete()
	{
		return "GuestbookController:delete()";
	}
}
