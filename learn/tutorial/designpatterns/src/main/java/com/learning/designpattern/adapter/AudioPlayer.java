package com.learning.designpattern.adapter;

public class AudioPlayer implements MediaPlayer {

	public void play(String audioType, String fileName) {
		
		if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("Playing "+audioType+" Audio fileName : "+fileName);
		} else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
			MediaAdapter adapter = new MediaAdapter(audioType);
			adapter.play(audioType, fileName);
		} else{
			System.out.println("Invalid media format. AudioType : "+audioType);
		}

	}

}
