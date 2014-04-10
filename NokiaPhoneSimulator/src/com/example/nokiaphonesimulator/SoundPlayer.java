package com.example.nokiaphonesimulator;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;

public class SoundPlayer
{
	// member
	private Context context;
	private MediaPlayer mp;
	
	// call with ApplicationContext
	public SoundPlayer(Context context)
	{
		this.context = context;
		this.mp = new MediaPlayer();
		this.mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
	}
	
	// destructor
	protected void finalize ()  
	{
        mp.release();
    }

	public void play(String sound_name) 
	{
		if(mp.isPlaying())
			mp.stop();
		
		mp.reset();
		AssetFileDescriptor afd;
		try 
		{
		    afd = context.getAssets().openFd(sound_name);
		    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
		    mp.prepare();
		    mp.start();
		} 
		catch (IllegalStateException e) 
		{
		    e.printStackTrace();
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
}
