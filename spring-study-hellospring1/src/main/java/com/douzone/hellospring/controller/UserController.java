package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVo;

/*
 * request mapping : type + method
 */

@Controller
@RequestMapping("/user") // 반복되는 부분은 이렇게 밖에다

public class UserController 
{
	@RequestMapping(value = "/join", method = RequestMethod.GET) // GET방식
	public String join() 
	{
		return "/WEB-INF/views/join.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/join", method = RequestMethod.POST) // get, post방식도 구분할수있음
	public String join(@ModelAttribute UserVo userVo) // vo가 매개변수로오면 셋터 필요 vo의 필드정보를 최대한 채워서 그 vo를 넣어줌 vo안의 필드와 join안의 변수이름과 같으면 편하다
	{					// uservo에 맞는값이있는지 검사해야함 그렇기에 modelAttribute가 필요함 
		
						// 기술을 안에 넣어서는안된다  그렇기에 필터를 제공해줌
		
			
		System.out.println(userVo); // 화면과 관련된것일때는 DTO
		return "UserController:join()";
	}
	
	@ResponseBody
	@RequestMapping("/loginform")
	public String loginform()
	{
		return "UserController:loginform()";
	}
}
