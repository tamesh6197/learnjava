package com.learning.designpattern.adapter;

public class Mp4MediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playMp4(String fileName) {
		System.out.println("Mp4MediaPlayer : Play MP4 files.");

	}

	@Override
	public void playVLC(String fileName) {

	}

}
