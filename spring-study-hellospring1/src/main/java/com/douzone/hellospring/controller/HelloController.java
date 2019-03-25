package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController 
{
	@RequestMapping("/hello") // 어떤요청을 이 url로 매핑한다  /hellospring(톰캣에있음)/hello 서블릿 컨텍스트path 이것도 기술이기때문에 배제
	public String hello(){
		return "/WEB-INF/views/hello.jsp";
	}
}
