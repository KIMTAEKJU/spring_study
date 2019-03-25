package com.douzone.springcontainer.user;

import org.springframework.stereotype.Component;

@Component
public class Friend 
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
	
}
