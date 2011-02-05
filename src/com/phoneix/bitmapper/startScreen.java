package com.phoneix.bitmapper;

import com.phoneix.bitmapper.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startScreen extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button newButton = (Button) findViewById(R.id.newButton);
        newButton.setOnClickListener(new View.OnClickListener() {
			
        	public void onClick(View view)
        	{
        		
        	}
		});
        
        Button oldButton = (Button) findViewById(R.id.oldButton);
        
        oldButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view)
        	{
        		
        	}
		});
        
        Button connectButton = (Button) findViewById(R.id.connectButton);
        
        connectButton.setOnClickListener(new View.OnClickListener() {
	     	public void onClick(View view)
        	{
        		
        	}
        });
    }
    
    /*
	private void startSearch()
    {
    	Intent iSearch = new Intent(this, SearchMenu.class);
    	startActivity(iSearch);
    }
    */
}