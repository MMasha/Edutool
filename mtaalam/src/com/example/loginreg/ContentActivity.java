package com.example.loginreg;

//this should give the actual content yes? 
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContentActivity extends ListActivity
{
    private String items[]; // holds items to be displayed

    private String title;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_content);

        /*The intent that launched the activity...should be launched from either quiz or notes activities*/
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

        Intent intent = new Intent(ContentActivity.this, InformationActivity.class); //the intent to be called when list item clicked

        intent.putExtra("TITLE", title);

        intent.putExtra("Quiz", "NO QUIZ");

        /*My implementation :: overwrites the subject string*/
        if (items != null)
            /*Pass on the subject name to the next activity*/
            intent.putExtra("Quiz", title + "->" + items[position]);

        startActivity(intent);

    } // on list item clicked in this list view activity

} 





/*package com.example.loginreg;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class ContentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		
		Intent i = getIntent();
		
		String content_name = i.getStringExtra("ContentName");
		
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.content, menu);
		return true;
	}

}*/
