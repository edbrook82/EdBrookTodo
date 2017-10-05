package com.example.c3469162.edbrooktodo.actions;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

/**
 * Created by edbrook on 05/10/2017.
 */

public class AddTodoEditorAction implements TextView.OnEditorActionListener {

    private final AddTodoEditorActionCallbacks mCallbacks;

    public interface AddTodoEditorActionCallbacks {
        void onEditorActionComplete(String text);
    }

    public AddTodoEditorAction(AddTodoEditorActionCallbacks callbacks) {
        mCallbacks = callbacks;
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            String newTodo = textView.getText().toString();
            if (newTodo.isEmpty()) {
                return true;
            }
            textView.setText("");
            mCallbacks.onEditorActionComplete(newTodo);
        }
        return false;
    }
}
