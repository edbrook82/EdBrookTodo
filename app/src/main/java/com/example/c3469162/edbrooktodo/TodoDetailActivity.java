package com.example.c3469162.edbrooktodo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class TodoDetailActivity extends AppCompatActivity {

    public static final String TODO_INDEX_EXTRA = "com.example.todoIndex";
    private static final String IS_TODO_COMPLETE = "com.example.isTodoComplete";


    public static Intent newIntent(Context context, int todoIndex) {
        Intent intent = new Intent(context, TodoDetailActivity.class);
        intent.putExtra(TODO_INDEX_EXTRA, todoIndex);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        int todoIndex = getIntent().getIntExtra(TODO_INDEX_EXTRA, 0);
        TextView textView = (TextView) findViewById(R.id.textViewTodoDetail);
        String[] detailStrings = getResources().getStringArray(R.array.todo_detail);
        textView.setText(detailStrings[todoIndex]);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBoxIsComplete);
        checkBox.setOnClickListener(mTodoListener);
    }

    private View.OnClickListener mTodoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // get the clicked object and do something
            switch (view.getId() /*to get clicked view object id**/) {
                case R.id.checkBoxIsComplete:
                    CheckBox checkboxIsComplete = (CheckBox)findViewById(R.id.checkBoxIsComplete);
                    setIsComplete(checkboxIsComplete.isChecked());
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

    private void setIsComplete(boolean isChecked) {
        // celebrate with a static Toast!
        if(isChecked){
            Toast.makeText(TodoDetailActivity.this,
                    "Hurray, it's done!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(TodoDetailActivity.this,
                    "There is always tomorrow!", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent();
        intent.putExtra(IS_TODO_COMPLETE, isChecked);
        setResult(RESULT_OK, intent);
    }
}
