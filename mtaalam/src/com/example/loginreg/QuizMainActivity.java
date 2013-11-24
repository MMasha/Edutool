package com.example.loginreg;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuizMainActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		final Button startQuiz = (Button) findViewById(R.id.btn_start_quiz);
		startQuiz.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				// Set up Intent to launch QuizActivity
				final Intent i = new Intent(QuizMainActivity.this, QuizActivity.class);
				
				// Retrieve user input for number of questions
				final EditText numberOfQuestionsInput = (EditText) findViewById(R.id.input_number_of_questions);
				final int numberOfQuestions;
				try {
					numberOfQuestions = Integer.parseInt(numberOfQuestionsInput.getText().toString());
				} catch (final NumberFormatException e) {
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalid_number_of_questions), Toast.LENGTH_LONG).show();
					return;
				}
				
				// Check that the user has requested at least one question
				if (numberOfQuestions < 1) {
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalid_number_of_questions), Toast.LENGTH_LONG).show();
					return;
				}
				
				// Add number of questions to the Intent's extras
				i.putExtra("numberOfQuestions", numberOfQuestions);
				
				// Launch QuizActivity
				startActivity(i);
			}
		});
	}
}

