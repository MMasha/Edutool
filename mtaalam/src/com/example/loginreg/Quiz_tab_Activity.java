package com.example.loginreg;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Quiz_tab_Activity extends Activity
{
    private ListView listView; // global list handle

    private Context _context; // global context handle

    private String mainListItems [] = {"Quiz 1", "Quiz 2","Quiz 3"};

    /*For quizzes...the items within*/
    private String quizItems[] = {"Load the quizzes here"};
    
    private String quiz2Items[] = {"Load the quizzes here"};
    
    private String quiz3Items[] = {"Load the quizzes here"};
    
    
    

    

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _context = getApplicationContext(); // get a handle of the apps context

        setContentView(R.layout.activity_quiz_tab); // set the layout

        listView = (ListView) findViewById(R.id.quizListView); // map list view from xml

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
            Intent intent = new Intent(_context, QuizMainActivity.class);

            /*Switches the position clicked
            * And passes the respective data:
            *   1. Activity's title
            *   2. List items array*/
            switch(position)
            {
                case 0: // first item on the list
                    intent.putExtra("TITLE", "Quiz 1");
                    intent.putExtra("ITEMS", quizItems);
                    break;

                case 1: // quizzes
                    intent.putExtra("TITLE", "Quiz 2");
                    intent.putExtra("ITEMS", quiz2Items);
                    break;

                case 2: // sciences
                    intent.putExtra("TITLE", "Quiz 3");
                    intent.putExtra("ITEMS", quiz3Items);
                    break;

                

            } // switch

            startActivity(intent);

        } // on item clicked

    } // my list listener class

} 
