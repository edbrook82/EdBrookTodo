package com.example.c3469162.edbrooktodo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.c3469162.edbrooktodo.view.TodoFragment;

public class TodoActivity extends SingleFragmentActivity {

    private static final String TAG = "TodoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // call the super class onCreate to complete the creation of activity like
        // the view hierarchy
        super.onCreate(savedInstanceState);

        Log.d(TAG, " *** Just to say the PC is in onCreate!");

        // set the user interface layout for this Activity
        // the layout file is defined in the project res/layout/activity_todo_fragment.xml file
        setContentView(R.layout.activity_todo_fragment);

//        loadFragmentIntoContainer(this, TodoFragment.class.getName(), R.id.fragment_container);
    }

    @Override
    Fragment getFragment() {
        return new TodoFragment();
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
}
