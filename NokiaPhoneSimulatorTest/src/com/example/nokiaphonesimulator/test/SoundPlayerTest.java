package com.example.nokiaphonesimulator.test;

import android.content.Context;
import android.media.AudioManager;
import android.test.ActivityInstrumentationTestCase2;

import com.example.nokiaphonesimulator.SoundPlayer;
import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.robotium.solo.Solo;

public class SoundPlayerTest extends ActivityInstrumentationTestCase2<NokiaPhoneActivity> 
{
	private Solo solo;
	
	public SoundPlayerTest() 
	{
		super(NokiaPhoneActivity.class);
	}
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		this.solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testConstructor() throws Throwable
	{
		SoundPlayer sound_player = new SoundPlayer(this.solo.getCurrentActivity().getApplicationContext());
	    assertNotNull(sound_player);
	}
	
	public void testPlayer() throws Throwable
	{
		SoundPlayer sound_player = new SoundPlayer(this.solo.getCurrentActivity().getApplicationContext());
		
	    AudioManager manager = (AudioManager)this.solo.getCurrentActivity().getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
	    sound_player.play("cell-phone-0.mp3");
	    
	    assertEquals("music must be playing", true, manager.isMusicActive());
	}
}