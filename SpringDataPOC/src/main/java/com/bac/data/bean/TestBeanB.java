package com.bac.data.bean;

import org.springframework.stereotype.Component;

@Component(value = "testBean")
public class TestBeanB {
	 
	public void show() {
		System.out.println("Testing lookup");
	}

}
