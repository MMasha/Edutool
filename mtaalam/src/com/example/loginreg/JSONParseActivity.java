package com.example.loginreg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

//public cl
//public class JSONParser {
	
//	static InputStream is = null;
//	static JSONObject jObj =null;
	
//}


public class JSONParseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jsonparse);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jsonparse, menu);
		return true;
	}

}
