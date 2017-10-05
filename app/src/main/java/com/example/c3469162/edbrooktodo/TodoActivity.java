package com.example.c3469162.edbrooktodo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.c3469162.edbrooktodo.actions.AddTodoEditorAction;

import java.util.ArrayList;
import java.util.Arrays;

public class TodoActivity extends AppCompatActivity
        implements AddTodoEditorAction.AddTodoEditorActionCallbacks {

    private ArrayList<String> mTodos;
    private TextView mTodoTextView;

    private int mTodoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // call the super class onCreate to complete the creation of activity like
        // the view hierarchy
        super.onCreate(savedInstanceState);

        // set the user interface layout for this Activity
        // the layout file is defined in the project res/layout/activity_todo.xml file
        setContentView(R.layout.activity_todo);

        // initialize member TextView so we can manipulate it later
        mTodoTextView = (TextView) findViewById(R.id.textViewTodo);

        // read the todo array from res/values/strings.xml
        Resources res = getResources();
        mTodos = new ArrayList<>();
        mTodos.addAll(Arrays.asList(res.getStringArray(R.array.todo)));

        // display the first task from mTodo array in the TodoTextView
        mTodoTextView.setText(mTodos.get(mTodoIndex));

        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        Button buttonPrev = (Button) findViewById(R.id.buttonPrev);

        // OnClick listener for the  Next button
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mTodoIndex = (mTodoIndex + 1) % mTodos.size();
                mTodoTextView.setText(mTodos.get(mTodoIndex));
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTodoIndex = --mTodoIndex < 0 ? mTodos.size() - 1 : mTodoIndex;
                mTodoTextView.setText(mTodos.get(mTodoIndex));
            }
        });

        EditText newTodoText = (EditText) findViewById(R.id.newTodoText);
        newTodoText.setOnEditorActionListener(new AddTodoEditorAction(this));
    }

    @Override
    public void onEditorActionComplete(String text) {
        mTodos.add(text);
        mTodoIndex = mTodos.size() - 1;
        mTodoTextView.setText(mTodos.get(mTodoIndex));
    }
}
