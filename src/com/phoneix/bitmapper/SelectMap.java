package com.phoneix.bitmapper;

import java.io.File;
import java.io.IOException;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class SelectMap extends ListActivity {
	// Constants
	private static final String MAP_DIR = "/BitMapper";
	private static final int GET_FILE_NAME = 0;
	private static final int DELETE_ID = Menu.FIRST;
	
	// Fields
	private File mDirectory;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_map);
        
        // Check if a BitMapper file exists and create one if not
        mDirectory = new File(Environment.getExternalStorageDirectory() + MAP_DIR);
        if(!mDirectory.exists() || !mDirectory.isDirectory()) {
        	mDirectory.mkdir();
        }
        
        // Fill the list with files
        fillData();
        registerForContextMenu(getListView());
        
        // Set up New Map button
        Button joinButton = (Button) findViewById(R.id.newButt);
        joinButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view)
        	{
        		getNewMapName();
        	}
		});
    }
    
    private void fillData() {
    	File[] maps = mDirectory.listFiles();
        ArrayAdapter<File> listAdp = new ArrayAdapter<File>(this, R.layout.map_list_item, maps);
        setListAdapter(listAdp);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETE_ID, 0, R.string.menu_delete);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case DELETE_ID:
                AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
                File[] maps = mDirectory.listFiles();
                maps[info.position].delete();
                fillData();
                return true;
        }
        return super.onContextItemSelected(item);
    }
 
    private void getNewMapName() {
    	Intent iGetName = new Intent(this,NameNewMap.class);
		startActivityForResult(iGetName, GET_FILE_NAME);
    }
    
    private void makeNewMap(String name) {
    	File map = new File(mDirectory + "/" + name + ".map");
    	try {
    		map.createNewFile();
    	} catch (IOException e) {
    		Toast.makeText(getApplicationContext(), "Unable to create .map file", Toast.LENGTH_SHORT).show();
    	}
    	fillData();
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(requestCode == GET_FILE_NAME) { // The Activity was providing a file name
    		if(resultCode == RESULT_OK) { // A name was provided
    			String mapName = data.getStringExtra("NameNewMap.mapName");
    			makeNewMap(mapName);
    		} else {
    			Toast.makeText(getApplicationContext(), "No name given. File not created", Toast.LENGTH_SHORT).show();
    		}
    	}
    }
    
}