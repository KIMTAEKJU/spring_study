package com.douzone.springcontainer.soundsystem;

import javax.inject.Named;

import org.springframework.stereotype.Component;

//@Component("blueBlood")
@Named("blueBlood")
public class BlueBlood implements CompactDisc{

	private String title = "Endless Rain";
	private String artist = "X Japan";
	
	
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
	


}
