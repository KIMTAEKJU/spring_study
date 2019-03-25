package com.douzone.springcontainer.soundsystem;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @Named 아이디를 줄때사용 	스프링에서 지원하느게아니라 javaEE에서 지원  아이디없이 쓸꺼면 Component
public class CDPlayer 
{
	//와이어링 1
	//@Autowired
	private CompactDisc cd;
	
	//와이어링 2
	//@Autowired
	private CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}
	
	public CDPlayer() {
	}
	// 와이어링 3 기본생성자가 필요
	@Autowired
	public void setCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}
	
	// 와이어링 4
	//@Autowired
	@Inject
	public void insertCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}
	
	public void play()
	{
		cd.play();
	}
}
