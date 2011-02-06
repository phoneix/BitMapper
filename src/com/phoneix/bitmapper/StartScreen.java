package com.phoneix.bitmapper;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartScreen extends Activity {
	private final Context mContext = this;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        
        // Set up the button for Setting up a bluetooth connection
        Button connectButton = (Button) findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {

        	public void onClick(View view)
        	{
        		// Make sure Bluetooth is supported
        		if(BluetoothAdapter.getDefaultAdapter() == null) {
                	Toast.makeText(getApplicationContext(), "Device does not support Bluetooth", 
                			Toast.LENGTH_SHORT).show();
                	finish();
                } else {
                	Intent iServer = new Intent(mContext, BtServerConnect.class);
                	startNext(iServer);
                }
        	}
		});
        
        // Set up button for joining a current bluetooth connection
        Button joinButton = (Button) findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view)
        	{
        		// Make sure Bluetooth is supported
        		if(BluetoothAdapter.getDefaultAdapter() == null) {
                	Toast.makeText(getApplicationContext(), "Device does not support Bluetooth", 
                			Toast.LENGTH_SHORT).show();
                	finish();
                } else {
                	Intent iClient = new Intent(mContext, BtClientConnect.class);
                	startNext(iClient);
                }
        	}
		});
        
        // Set up button for working solo
        Button soloButton = (Button) findViewById(R.id.soloButton);
        soloButton.setOnClickListener(new View.OnClickListener() {
	     	public void onClick(View view)
        	{
	     		Intent iSelect = new Intent(mContext, SelectMap.class);
	     		iSelect.putExtra("BluetoothStatus", 0);
	     		startNext(iSelect);
        	}
        });
    }
    
    private void startNext(Intent I)
    {
    	startActivity(I);
    }
}