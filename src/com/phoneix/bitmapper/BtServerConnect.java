package com.phoneix.bitmapper;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BtServerConnect extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_for_connection);
        
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);
        
     // Set up the button for Setting up a bluetooth connection
        Button connectButton = (Button) findViewById(R.id.broadcastCButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view)
        	{
        		((BitMapper)getApplicationContext()).start();
        		//Change the button so that you can escape connect loop
        		changeButtonToExit();
        		while(true) {
        			if(((BitMapper)getApplicationContext()).getState() == BitMapper.STATE_CONNECTED) {
        				break;
        			}
        		}
        		chooseMap();
        	}
		});
	}
	
	private void changeButtonToExit() {
		 Button connectButton = (Button) findViewById(R.id.broadcastCButton);
		 connectButton.setText("Press to stop broadcast");
	     connectButton.setOnClickListener(new View.OnClickListener() {
	       	public void onClick(View view)
	       	{
	       		((BitMapper)getApplicationContext()).stop();
	       		finish();
	       	}
		});
	}
	
	private void chooseMap() {
		
	}
}
