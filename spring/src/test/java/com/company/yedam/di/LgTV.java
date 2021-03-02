package com.company.yedam.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{

	@Autowired
	@Qualifier("appleSpeaker")  // 상속받은 speaker 중 골라 쓰고 싶을 때
	Speaker speaker;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV powerDown");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
