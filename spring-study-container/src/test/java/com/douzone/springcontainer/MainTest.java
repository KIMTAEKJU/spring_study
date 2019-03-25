package com.douzone.springcontainer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.springcontainer.config.user.AppConfig01;
import com.douzone.springcontainer.user.User;

/*
 * SpringJUnit4ClassRunner가 하는일
 * 
 * 1. ApplicationContext에 user와 maintest를 넣어줌
 * 2. @Test가 붙은애들을 하나씩 실행시켜줌
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 환경에서 사용하기위해서 
@ContextConfiguration(classes=AppConfig01.class) // ApplicationContext 컨테이너 만들어줌 AppConfig읽어서 User도 만듬
public class MainTest 
{
	@Autowired
	private User user;
	
	@Test
	public void testUserNotNull()
	{
		assertNotNull(user);
	}
	
	@Test
	public void testMethod()
	{
		assertTrue( 1 == 1);
	}

	@Test
	public void testMethod1()
	{
		fail();
	}
	
	@Test
	public void testMethod2()
	{
		//User user = dao.getUser("wpaltm12@naver.com", "1234");
		assertNotNull(user);
	}
}
