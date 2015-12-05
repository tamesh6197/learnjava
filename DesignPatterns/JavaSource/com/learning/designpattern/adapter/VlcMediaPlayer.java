package com.learning.designpattern.adapter;

public class VlcMediaPlayer implements AdvancedMediaPlayer{

	@Override
	public void playMp4(String fileName) {
		
	}

	@Override
	public void playVLC(String fileName) {
		System.out.println("VlcMediaPlayer : Play VLC files.");
	}

}
