package com.example.loginreg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleMenuItemActivity  extends Activity {
	
	// XML node keys
	static final String KEY_NAME = "name";
	static final String KEY_CONTENT = "content";
	static final String KEY_DESC = "description";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get XML values from previous intent
        String name = in.getStringExtra(KEY_NAME);
        String content = in.getStringExtra(KEY_CONTENT);
        String description = in.getStringExtra(KEY_DESC);
        
        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblcontent = (TextView) findViewById(R.id.content_label);
        TextView lblDesc = (TextView) findViewById(R.id.description_label);
        
        lblName.setText(name);
        lblcontent.setText(content);
        lblDesc.setText(description);
    }
}
