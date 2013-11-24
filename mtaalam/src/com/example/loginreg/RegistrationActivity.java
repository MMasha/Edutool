package com.example.loginreg;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends Activity {

	//progress dialog
	//private ProgressDialog pDialog;
	
	JSONParser jsonParser = new JSONParser ();
	EditText inputName;
	EditText inputPass;
	EditText inputEmail;
	
	//url to create new user
	private static String url_create_user = "http://localhost/register.php";
	
	//JSON Node names
	private static final String TAG_SUCCESS = "success";
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//set the view/ interface to the register.xml
		setContentView(R.layout.activity_registration);
		
		//EditText
		inputName = (EditText) findViewById(R.id.reg_username);
		inputPass = (EditText) findViewById(R.id.reg_password);
		inputEmail = (EditText) findViewById(R.id.reg_email);
		
		//create button
		Button btnRegister = (Button) findViewById(R.id.btnRegister);
		
		//create  button click event
		btnRegister.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) { //agr0
				// TODO Auto-generated method stub
				//creating a new user
				new CreateNewUser().execute();
				
			}
		});
	}
		//have a background async task to create the new user
	class CreateNewUser extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
	
	//	@Override
		protected void onPreExecute() {
			Context context = getApplicationContext();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, getText(100), duration);
			toast.show();
			/*super.onPreExecute();
			pDialog = new ProgressDialog(RegistrationActivity.this);
			pDialog.setMessage("Creating Product..");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);*/
			
		}

		/**
		 * Creating user
		 * */
		protected String doInBackground(String... args) {
			String name = inputName.getText().toString();
			String pass = inputPass.getText().toString();
			String Email = inputEmail.getText().toString();

			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("Username", name));
			params.add(new BasicNameValuePair("Pass", pass));
			params.add(new BasicNameValuePair("Email", Email));

			// getting JSON Object
			// Note that create product url accepts POST method
			JSONObject json = jsonParser.makeHttpRequest(url_create_user,
					"POST", params);
			
			
			//pDialog.show();
			// check log cat for response
			Log.d("Log me: ", "This is my first log");
			Log.d("Create Response", json.toString());

			// check for success tag
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					
					
					// successfully created product
					Intent i = new Intent(getApplicationContext(), SubjectListActivity.class);
					startActivity(i);
					
					// closing this screen
					finish();
				} else {
					// failed to create product
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			//pDialog.dismiss();
			
		

	
///should stop this part then....
		
		TextView loginScreen =(TextView) findViewById(R.id.link_to_login);
		//Button listbutton =(Button) findViewById(R.id.btnList);
		Button list = (Button) findViewById(R.id.btnList);
		
		//listen to the login screen link, so if someone has already registered
		//it can send you back to the login page/activity
		loginScreen.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//so it'll switch back to the login screen and close this one for registration
				
				finish();
			}
			
		});
		
	//	listbutton.setOnClickListener(new View.OnClickListener() {
		list.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//load list page
				Intent l = new Intent(getApplicationContext(), SubjectListActivity.class);
				
			}
		});
		}
		
			/*@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//go to the list page
				Intent l = new Intent(getApplicationContext(), SubjectsActivity.class);
				startActivity(l);
			}
		});
		
	}*/

	//@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

	}
}