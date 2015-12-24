package com.learning.designpattern.adapter;

public class MediaAdapter implements MediaPlayer {

	private AdvancedMediaPlayer advancedMediaPlayer;
	
	public MediaAdapter(String audioType){
		if(audioType.equalsIgnoreCase("vlc")){
			advancedMediaPlayer = new VlcMediaPlayer();
		}
		if(audioType.equalsIgnoreCase("mp4")){
			advancedMediaPlayer = new Mp4MediaPlayer();
		}
	}
	
	public void play(String audioType, String fileName) {
		if("vlc".equalsIgnoreCase(audioType)){
			advancedMediaPlayer.playVLC(fileName);
		}
		if("mp4".equalsIgnoreCase(audioType)){
			advancedMediaPlayer.playMp4(fileName);
		}
	}

}
