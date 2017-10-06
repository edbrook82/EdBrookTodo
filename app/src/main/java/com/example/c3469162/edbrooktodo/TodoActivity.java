package com.example.c3469162.edbrooktodo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {

    // In case of state change, due to rotating the phone
    // store the mTodoIndex to display the same mTodos element post state change
    // N.B. small amounts of data, typically IDs can be stored as key, value pairs in a Bundle
    // the alternative is to abstract view data to a ViewModel which can be in scope in all
    // Activity states and more suitable for larger amounts of data
    public static final String TODO_INDEX = "todo_index";

    private static final String TAG = "TodoActivity";

    private String[] mTodos;
    private int mTodoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // call the super class onCreate to complete the creation of activity like
        // the view hierarchy
        super.onCreate(savedInstanceState);

        Log.d(TAG, " *** Just to say the PC is in onCreate!");

        // set the user interface layout for this Activity
        // the layout file is defined in the project res/layout/activity_todo.xml file
        setContentView(R.layout.activity_todo);

        // initialize member TextView so we can manipulate it later
        final TextView TodoTextView;
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);

        // read the todo array from res/values/strings.xml
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todo);
        // display the first task from mTodo array in the TodoTextView

        // check for saved state due to changes such as rotation or back button
        // and restore any saved state such as the todo index
        if (savedInstanceState != null) {
            Log.d(TAG, "Loading mTodoIndex from bundle in onCreate");
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }
        TodoTextView.setText(mTodos[mTodoIndex]);

        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        Button buttonPrev = (Button) findViewById(R.id.buttonPrev);

        // OnClick listener for the Next button
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mTodoIndex = (mTodoIndex + 1) % mTodos.length;
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });

        // OnClick listener for the Previous button
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTodoIndex = --mTodoIndex < 0 ? mTodos.length - 1 : mTodoIndex;
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "PC is in onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "PC is in onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "PC is in onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "PC is in onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "PC is in onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "PC is in onDestroy");
    }

    // Override to write the value of mTodoIndex into the Bundle with TODO_INDEX as its key
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "Saving mTodoIndex in onSaveInstanceState");
        outState.putInt(TODO_INDEX, mTodoIndex);
    }
}
