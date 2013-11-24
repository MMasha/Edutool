package com.example.loginreg;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_information);

        setTitle("Information on : " + getIntent().getStringExtra("TITLE"));
        
        

        /*Assigns text to the text view*/
        ((TextView) findViewById(R.id.infoTextView)).setText(
                String.format("Have Quizzes, Videos, Notes\n%s,\n fill" +
                        " content o(*_*)o", getIntent().getStringExtra("SUBJECT"))); 
        
        Intent content = new Intent(getApplicationContext(), ContentLayoutActivity.class);
        startActivity (content);

    } //on Create

} //InformationActivity