package com.phoneix.bitmapper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameNewMap extends Activity {
	private EditText mNameBox;
	static final int NO_NAME = 0;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_new_map);
        
        mNameBox = (EditText) findViewById(R.id.editName);
        // Button to return name
        Button okButt = (Button) findViewById(R.id.createButt);
        okButt.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view)
        	{
        		getNameAndFinish();
        	}
		});
        
    }
    
    private void getNameAndFinish() {
    	String result = mNameBox.getText().toString();
    	Intent data = new Intent();
    	data.putExtra("NameNewMap.mapName", result);
    	// If no name, SelectMap needs to know not to create a file
    	if(result.length() == 0) {
    		setResult(NO_NAME, data);
    	// If there is a name, it worked
    	} else {
    		setResult(RESULT_OK, data);
    	}
    	finish();
    }
}
