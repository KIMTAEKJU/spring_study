package com.douzone.springcontainer.config.user;

import org.springframework.context.annotation.Bean;

import com.douzone.springcontainer.user.User;

//어노테이션을 달지않음
public class AppConfig01 {

	@Bean
	public User user()
	{
		return new User();
	}
}
