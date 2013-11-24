package com.example.loginreg;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExampleListActivity extends Activity
{
    private ListView listView; // global list handle

    private Context _context; // global context handle

    private String mainListItems [] = {"Maths", "Languages", "Sciences", "Social Sciences"};

    /*For maths*/
    private String mathItems[] = {"Algebra", "Calculus", "Geometry", "Mathematical Induction"};

    /*Languages*/
    private String langItems[] = {"English", "Swahili", "French", "German"}; //these subjects should go straight to content

    /*Sciences*/
    private String sciItems[] = {"Biology", "Physics", "Chemistry"}; //have subjects within

    /*Social Sciences*/
    private String socialItems[] = {"Geography", "Judaism", "C.R.E.", "Hygiene"};

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _context = getApplicationContext(); // get a handle of the apps context

        setContentView(R.layout.activity_example_list); // set the layout

        listView = (ListView) findViewById(R.id.listView); // map list view from xml

        listView.setOnItemClickListener(new Listener());

        listView.setAdapter(new ArrayAdapter<String>(_context, android.R.layout.simple_list_item_1, mainListItems));

    } //on Create

    private class Listener implements AdapterView.OnItemClickListener
    {
        /*When an item is clicked on the list, this function is run*/
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            /*Intent to pass data to new activity*/
            Intent intent = new Intent(_context, SubjectListActivity.class);

            /*Switches the position clicked
            * And passes the respective data:
            *   1. Activity's title
            *   2. List items array*/
            switch(position)
            {
                case 0: // first item on the list
                    intent.putExtra("TITLE", "Mathematics");
                    intent.putExtra("ITEMS", mathItems);
                    break;

                case 1: // languages
                    intent.putExtra("TITLE", "Languages");
                    intent.putExtra("ITEMS", langItems);
                    break;

                case 2: // sciences
                    intent.putExtra("TITLE", "Sciences");
                    intent.putExtra("ITEMS", sciItems);
                    break;

                case 3: // list item
                    intent.putExtra("TITLE", "Social Sciences");
                    intent.putExtra("ITEMS", socialItems);
                    break;

            } // switch

            startActivity(intent);

        } // on item clicked

    } // my list listener class

} //ExampleListActivity
