package com.example.loginreg;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class ContentLayoutActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_layout);

		Intent i = getIntent();
		
		TextView quiztext = (TextView) findViewById(R.id.Quizzes);
		// quiztext.setOnClickListener(new View.OnClickListener(){

		// TextView notestext = (TextView) findViewById(R.id.Notes);
		/*
		 * notestext.setOnClickListener(new View.OnClickListener(){
		 * 
		 * 
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub
		 * 
		 * switch (v.getId()) { case R.id.quiztext: // do something break; case
		 * R.id.buttonB: // do something else break; }
		 * 
		 * Intent i = new Intent(getApplicationContext(),
		 * Quiz_tab_Activity.class); startActivity(i);
		 * 
		 * }; }
		 */

		/*
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub //switch to the register screen..if someone has not registered
		 * yet Intent n = new Intent(getApplicationContext(),
		 * NotesActivity.class); startActivity(n);
		 * 
		 * }
		 */
		/*
		 * TabHost tabHost = getTabHost();
		 * 
		 * // Tab for Quizzes TabSpec quizzespec= tabHost.newTabSpec("Quizzes");
		 * // setting Title and Icon for the Tab
		 * quizzespec.setIndicator("Quizzes",
		 * getResources().getDrawable(R.drawable.icon_questions_tab)); Intent
		 * quizzesIntent = new Intent(this, Quiz_tab_Activity.class);
		 * quizzespec.setContent(quizzesIntent);
		 * 
		 * // Tab for Notes TabSpec notespec= tabHost.newTabSpec("Notes");
		 * notespec.setIndicator("Notes",
		 * getResources().getDrawable(R.drawable.notes_tab)); Intent notesIntent
		 * = new Intent(this, NotesActivity.class);
		 * notespec.setContent(notesIntent);
		 * 
		 * 
		 * 
		 * // Adding all TabSpec to TabHost tabHost.addTab(quizzespec); //
		 * Adding quizzes tab tabHost.addTab(notespec); // Adding notes tab
		 * 
		 * }
		 * 
		 * 
		 * 
		 * private TabHost getTabHost() { // TODO Auto-generated method stub
		 * return ; }
		 */

	}
	
	public boolean onQuizClicked (View v){
		Log.d("ContentLayoutActivity", "Quiz Clicked Bugger");
		
		Intent content = new Intent(getApplicationContext(), Quiz_tab_Activity.class);
		startActivity (content);
		
		return true;
	}

	public boolean onNotesClicked (View v){
		Log.d("ContentLayoutActivity", "Notes Clicked Bugger");
		Intent notesintent = new Intent(getApplicationContext(), AndroidXMLParsingActivity.class );
		//Intent contentN = new Intent(getApplicationContext(), NotesActivity.class);
		startActivity (notesintent);
		
		
		return true;
	}
}
