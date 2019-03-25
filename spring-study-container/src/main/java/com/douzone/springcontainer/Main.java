package com.douzone.springcontainer;

import java.time.temporal.JulianFields; 

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.springcontainer.user.Friend;
import com.douzone.springcontainer.user.User;
import com.douzone.springcontainer.user.User1;

public class Main 
{
	public static void main(String[] args)
	{
		//testBeanFactory();
		testApplicationContext();
	}

	public static void testBeanFactory()
	{
		// @설정인 경우 id가 자동으로  id가 만들어진다 User1 => user1
		BeanFactory bf1 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext2.xml"));
		User1 user1 = (User1)bf1.getBean("user1"); // 아이디로 받는건 캐스팅을 잘해줘야함

		System.out.println(user1.getName());

		// XML Bean 설정인 경우 id를 주지않으면 에러
		BeanFactory bf2 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext.xml"));
		// id 대신에 타입으로 빈을 가져올수있다.
		user1 = bf2.getBean(User1.class); // 아이디로 받는건 캐스팅을 잘해줘야함

		System.out.println(user1.getName());

	}

	public static void testApplicationContext()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/user/applicationContext2.xml");
	      User user = (User)ac.getBean("user");
	      System.out.println(user.getName());

		//User1 user1 = ac.getBean(User1.class); // 아이디로 받는건 캐스팅을 잘해줘야함
		//System.out.println(user1.getName());

		//User1 user1 = (User1)ac.getBean("user1"); // 아이디로 받는건 캐스팅을 잘해줘야함
		//System.out.println(user1.getName());

		// 빈설정은 id나 name 설정을 해야한다

		// name으로 가져오기
		//User user = (User)ac.getBean("user");

		//System.out.println(user.getName());

		// id로 가져오기
		//user = (User)ac.getBean("usr");

		//System.out.println(user.getName());
		
		// 오류 : 같은 타입의 빈이 2개이상 존재하면 타입으로 빈을 가져올수없다
		// ac.getBean(User.class);
		
		//User user2 = (User)ac.getBean("usr2");
		//System.out.println(user2.getName());
		
		//User user3 = (User)ac.getBean("usr3");
		//System.out.println(user3);
		
		//Friend friend = (Friend)ac.getBean("friend");
		//System.out.println(friend);
		
		//User user4 = (User)ac.getBean("usr4");
		//System.out.println(user4);
	}
}
