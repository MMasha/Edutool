package com.example.loginreg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

//use JSON and php to load content from the server

public class NotesActivity extends Activity {

	TextView stuff;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes);

		StrictMode.enableDefaults(); // strictmode is used to help find accidental errors
		stuff = (TextView) findViewById(R.id.stuff);

		//getData(); // this method si to
	}

	/*public void getData() {
		String result = "";*/
		//InputStream inputstream = null; // inputstream reads data from a file
		// try catch for easier error detection
	/*	try {

			HttpClient httpClient = new DefaultHttpClient();
			// HttpPost httpPost = new HttpPost
			// ("http://localhost/getSubjects.php"); //the address of the php
			// script where ever it is
			HttpPost httpPost = new HttpPost(
					"http://192.168.0.10/root/api/getSubjects.php"); // the address of the php script where-ever it is
			HttpResponse irespond = httpClient.execute(httpPost); // the response which is in JSON?
			HttpEntity entity = irespond.getEntity(); // storing the response into entity
			irespond = (HttpResponse) entity.getContent();
			inputstream = entity.getContent();
			Log.d("NotesActivity", inputstream.toString());
		} catch (Exception e) { // if there are any errors in connection, should show
			// Log.e(tag, msg)
			Log.e("log_tag", "This thing is not connecting!! :-(" + e.toString());
			stuff.setText(e.toString());
		}

		// now we change the response to a string
		try {
			BufferedReader toread = new BufferedReader(new InputStreamReader(
					inputstream, "iso-8859-1"), 8);
			StringBuilder build_a_string = new StringBuilder();
			String line = null; // these ones have passed me nyweee
			while ((line = toread.readLine()) != null) {
				build_a_string.append(line + "\n"); // creates the string output
			}

			inputstream.close();

			result = build_a_string.toString();
		}

		catch (Exception e) {
			Log.e("log_tag", "Error  converting result " + e.toString());
		}

		// now should PARSE the JSON data..remember the data i want to show is
		// stored in JSON format
		try {
			String s = "";
			// use a JSONarray to read the many details as such
			JSONArray iamJson = new JSONArray(result); // want the JSON to take from the result that was read above
			for (int i = 0; i < iamJson.length(); i++) {

				JSONObject jsonobject = iamJson.getJSONObject(i);

				// show in a string
				s = s + "Name of Subject :"
						+ jsonobject.getString("SubjectName") + "\n\n";
			}
			stuff.setText(s);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("log_tag", "Error Parsing Data " + e.toString());
		}

	}
*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notes, menu);
		return true;
	}

}
