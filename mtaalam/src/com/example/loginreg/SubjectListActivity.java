package com.example.loginreg;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubjectListActivity extends ListActivity
{
    private String items[]; // holds items to be displayed

    private String title;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subject_list);

        /*The intent that launched the activity*/
        Intent intent = getIntent();

        title = intent.getStringExtra("TITLE");

        setTitle(title);

        items = intent.getStringArrayExtra("ITEMS");

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

    } //on Create

    /*I have to override this to access the items in the list*/
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        /*Call the superclass to work out logistics
        * such as painting the selection correctly*/
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(SubjectListActivity.this, ContentLayoutActivity.class); //the intent to be called when list item clicked

        intent.putExtra("TITLE", title);

        intent.putExtra("SUBJECT", "NO SUBJECT");

        Log.d("SubjectListActivity", "Getting on to ContentLayoutActiviy");
        
        /*My implementation :: overwrites the subject string*/
        if (items != null)
            /*Pass on the subject name to the next activity*/
            intent.putExtra("SUBJECT", title + "->" + items[position]);

        startActivity(intent);

    } // on list item clicked in this list view activity

} //SubjectListActivity