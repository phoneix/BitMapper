package com.phoneix.bitmapper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        
        Button connectButton = (Button) findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
			
        	public void onClick(View view)
        	{
        		//Intent iConnection = new Intent(this, StartConnection.class);
            	//startActivity(iConnection);
        	}
		});
        
        Button joinButton = (Button) findViewById(R.id.joinButton);
        
        joinButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view)
        	{
        		//Intent iJoin = new Intent(this, JoinConnection.class);
            	//startActivity(iJoin);
        	}
		});
        
        Button soloButton = (Button) findViewById(R.id.soloButton);
        
        soloButton.setOnClickListener(new View.OnClickListener() {
	     	public void onClick(View view)
        	{
	     		//Intent iSelectMap = new Intent(this, SelectMap.class);
	        	//startActivity(iSelectMap);
        	}
        });
    }
}