package com.company.yedam.di;

import org.springframework.stereotype.Component;

@Component("sony") // 이름 지정 가능(default는 맨 처음 글자 소문자)
public class SonySpeaker implements Speaker{
	public SonySpeaker(){
		System.out.println("SonySpeaker 생성");
	}
	public void volumeUp(){
		System.out.println("SonySpeaker 소리 올림");
	}
	public void volumeDown(){
		System.out.println("SonySpeaker 소리 내림");
	}	
}
