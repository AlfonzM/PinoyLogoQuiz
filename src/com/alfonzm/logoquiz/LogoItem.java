package com.alfonzm.logoquiz;

public class LogoItem {
	
	boolean answered;
	int id;
	String userAnswer;
	
	public LogoItem(int i){
		id = i;
		answered = false;
	}
}