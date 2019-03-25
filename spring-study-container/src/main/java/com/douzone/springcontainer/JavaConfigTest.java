package com.douzone.springcontainer;

import org.springframework.context.ApplicationContext; 
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.springcontainer.config.user.AppConfig01;
import com.douzone.springcontainer.soundsystem.CDPlayer;
import com.douzone.springcontainer.soundsystem.CompactDisc;
import com.douzone.springcontainer.user.User;
import com.douzone.springcontainer.videosystem.DVDPlayer;
import com.douzone.springcontainer.videosystem.DigitalVideoDisc;

import config.mixing.videosystem.DVDPlayerConfig;
import config.mixing.videosystem.VideoSystemConfig01;
import config.mixing.videosystem.VideoSystemConfig02;
import config.mixing.videosystem.VideoSystemConfig03;

public class JavaConfigTest {

	public static void main(String[] args) {
		//testJavaConfig01();
		//testJavaConfig02();
		//testJavaConfig03();
		//testJavaConfig04();
		//testJavaConfig05();
		//testJavaConfig06();
		//testJavaConfig07();
		testJavaConfig08();
	}


	// Java Config 01
	// 직접 설정 java 클래스를 전달하는 경우
	// 설정 자바 클래스에 @Configuration 필요없음   직접하니까 
	public static void testJavaConfig01()
	{
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(AppConfig01.class); // 어노테이션 컨피그
		
		User user = appCtx.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)appCtx).close();
	}

	// Java Config 02
	// 설정 자바 클래스가 있는 베이스 패키지를 지정하는 방법
	//어떤놈이 설정파일인지 @configuration을 스캐닝 해야함  @configuraion 반드시 필요하다
	
	// @Configuration이 달린놈이 여러개있으면 다 설정파일로 사용
	public static void testJavaConfig02()
	{
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.user"); // 어노테이션 컨피그
		
		User user = (User)appCtx.getBean("user");
	      System.out.println(user.getName());

	}
	
	// Java Config 03 - 자동설정
	// Componenet Scanning ( @Component, @Autuwired)
	public static void testJavaConfig03()
	{
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.soundsystem"); // 어노테이션 configuration 스캐닝
		
		CompactDisc cd = (CompactDisc)appCtx.getBean("blueBlood");
		System.out.println(cd);
		
		cd = (CompactDisc)appCtx.getBean("blueBlood");
		CDPlayer cdPlayer = appCtx.getBean(CDPlayer.class);
		cdPlayer.play();
	}
	
	

	// Java Config 04 - 명시적 설정
	// ComponenetScan을 사용하지않음
	// Java Config Class의 메소드 와 @Bean을 사용
	public static void testJavaConfig04()
	{
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.videosystem"); 
		
		DigitalVideoDisc dvd = appCtx.getBean( DigitalVideoDisc.class);
		System.out.println( dvd );
		
//		DVDPlayer dvdPlayer = appCtx.getBean( DVDPlayer.class);
//		dvdPlayer.play();
		
		DVDPlayer dvdPlayer = (DVDPlayer) appCtx.getBean( "dvdPlayer");
		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();

	}
	
	// Java Config 05 - mixing 01
	// Java Config(dvdPlayer) <- Java Config 2(dvd) 분리시키는 예제 dvd와 player를
	public static void testJavaConfig05()
	{
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(DVDPlayerConfig.class); // 하나만 정확하게 명시하는게 좋을수도있다
	
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();		
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 06 - mixing 02
	// Java Config(새로운 설정) <- Java Config(dvdPlayer 설정)  + Java Config(dvd설정)
	public static void testJavaConfig06()
	{
		// config.mixing.videosystem.VideoSystemConfig
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(VideoSystemConfig01.class); // 하나만 정확하게 명시하는게 좋을수도있다
				
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();		
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 07 - mixing 03
	// Java Config <- Java Config + XML Config
	public static void testJavaConfig07()
	{
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(VideoSystemConfig02.class);
				
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();		
		
		((ConfigurableApplicationContext)appCtx).close();			
	}
	
	// Java Config 08 - mixing 04
	// Java Config <- XML Config
	public static void testJavaConfig08()
	{
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(VideoSystemConfig03.class);
				
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();		
		
		((ConfigurableApplicationContext)appCtx).close();
	}
}
