package com.phoneix.bitmapper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends Activity {
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
        		//startNext(CreateConnection.class);
        	}
		});
        
        // Set up button for joining a current bluetooth connection
        Button joinButton = (Button) findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view)
        	{
        		//startNext(JoinConnection.class);
        	}
		});
        
        // Set up button for working solo
        Button soloButton = (Button) findViewById(R.id.soloButton);
        soloButton.setOnClickListener(new View.OnClickListener() {
	     	public void onClick(View view)
        	{
	     		startNext(SelectMap.class);
        	}
        });
    }
    
    private void startNext(Class next)
    {
    	Intent iSearch = new Intent(this, next);
    	startActivity(iSearch);
    }
}