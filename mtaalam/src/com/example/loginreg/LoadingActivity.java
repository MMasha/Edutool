package com.example.loginreg;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class LoadingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginlayout);
	
	
	Button login = (Button) findViewById(R.id.LoginButton);
	login.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//click the button to go to login page
			Intent m = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity (m);
			
		}
	});
	
	Button about =(Button) findViewById(R.id.AboutUs);
	about.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//show about text in a dialog box
			Intent a = new Intent(getApplicationContext(), AboutActivity.class);
			startActivity(a);
			
		}
	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
