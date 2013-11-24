
//ok, now these things are getting very very confusing

package com.example.loginreg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class QuizEndActivity extends Activity {
	
	// Private Constants
	private static final String TAG = "QuizEndActivity";

	// Private member variables
	private int correctAnswers;
	private int incorrectAnswers;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get the values for correctAnswers and incorrectAnswers
		if (null != savedInstanceState && savedInstanceState.containsKey("correctAnswers") && savedInstanceState.containsKey("incorrectAnswers")) {
			correctAnswers = savedInstanceState.getInt("correctAnswers");
			incorrectAnswers = savedInstanceState.getInt("incorrectAnswers");
		} else if (null != getIntent().getExtras() && getIntent().getExtras().containsKey("correctAnswers") && getIntent().getExtras().containsKey("incorrectAnswers")) {
			correctAnswers = getIntent().getExtras().getInt("correctAnswers");
			incorrectAnswers = getIntent().getExtras().getInt("incorrectAnswers");
		} else {
			Log.w(TAG, "Data for the number of correct/incorrect answers was not provided. This indicates that this Activity was started incorrectly.");
			correctAnswers = 0;
			incorrectAnswers = 0;
		}

		// Display the end of quiz summary
		setContentView(R.layout.quiz_end_summary);

		// Set the values for correct and incorrect answers		final TextView correctAnswersText = (TextView) findViewById(R.id.quiz_end_correct_number);		correctAnswersText.setText(String.valueOf(correctAnswers));		final TextView incorrectAnswersText = (TextView) findViewById(R.id.quiz_end_incorrect_number);		incorrectAnswersText.setText(String.valueOf(incorrectAnswers));		// Set up the button to return to the main menu		final Button quizEndButton = (Button) findViewById(R.id.quiz_end_accept_button);		quizEndButton.setOnClickListener(new OnClickListener() {			public void onClick(final View v) {				QuizEndActivity.this.finish();			}		});
	}
	
	@Override
	protected void onSaveInstanceState(final Bundle outState) {
		outState.putInt("correctAnswers", correctAnswers);
		outState.putInt("incorrectAnswers", incorrectAnswers);
		super.onSaveInstanceState(outState);
	}
}