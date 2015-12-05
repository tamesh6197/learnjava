package com.learning.designpattern.adapter;

public class AdapterPatternDemo {
	
	public static void main(String [] args){
		AudioPlayer audioPlayer = new AudioPlayer();
		
		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "this is beautiful.mp4");
		audioPlayer.play("vlc", "chunri oodh ke naachunn.vlc");
		audioPlayer.play("aac", "lol.aac");
	}

}
