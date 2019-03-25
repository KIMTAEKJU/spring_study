package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController 
{
	@ResponseBody
	@RequestMapping("/write")
	public String write(@RequestParam("e") String email,
						@RequestParam(/* 2개이상을 넣으려할때*/value="name", required=false) String name, // name으로 파라미터가 들어오면 그값을 옆에 name에게 세팅
						@RequestParam String password,
			/*추천방식	*/	@RequestParam(value="content", required=true, defaultValue="") String content) 
														   // 파라미터를 주지않으면 에러   required를 false로하면 에러가 나지않음
	{
		System.out.println("e : " + email);
		System.out.println("name : " + name);
		System.out.println("password : " + password);
		System.out.println("content : " + content);
		return "BoardController:write()";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(@RequestParam(/* 2개이상을 넣으려할때*/value="no", required=false) Long no) // name으로 파라미터가 들어오면 그값을 옆에 name에게 세팅
														   // 파라미터를 주지않으면 에러   required를 false로하면 에러가 나지않음 Long은 되는데 long은 기본타입이라 null이오면 에러
														   // 그래서 파라미터타입은 왠만하면 객체타입
	{
		System.out.println(no);
		return "BoardController:delete()";
	}
	
	// 팁
	@ResponseBody
	@RequestMapping("/view")
	public String view(@RequestParam(value = "no", required = true, defaultValue = "") Long no) 
	// 어노테이션 안에서는 defaultValue = 0 이렇게 못줌 String값으로 줘야함 "0"
	{
		System.out.println("no : " + no);
		return "BoardController:view()";
	}
	
	@ResponseBody
	@RequestMapping("/view2/{no}")
	public String view2(@PathVariable("no") Long no) 
	// 어노테이션 안에서는 defaultValue = 0 이렇게 못줌 String값으로 줘야함 "0"
	{
		System.out.println("no : " + no);
		return "BoardController:view2()";
	}
	
	@ResponseBody
	@RequestMapping("/view3/{id}{no}")
	public String view3(@PathVariable("id") String id,
						@PathVariable("no") Long no) 
	// 어노테이션 안에서는 defaultValue = 0 이렇게 못줌 String값으로 줘야함 "0"
	{
		System.out.println("id : " + id);
		System.out.println("no : " + no);
		return "BoardController:view3()";
	}
}
