package com.example.loginreg;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
		//so listen to the link for registering new accounts
		registerScreen.setOnClickListener(new View.OnClickListener() {
						
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//switch to the register screen..if someone has not registered yet
				Intent i = new Intent(getApplicationContext(), RegistrationActivity.class);
				startActivity(i);
				
			}
		});
		
		Button login = (Button) findViewById(R.id.btnLogin);
		///still need to have connection with DB to verify details
		//Get JSON link
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//click the button to send login details fro validation
				Intent m = new Intent(getApplicationContext(), ExampleListActivity.class);
				startActivity (m);
				
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
