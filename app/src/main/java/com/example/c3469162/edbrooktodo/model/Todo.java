package com.example.c3469162.edbrooktodo.model;

import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.UUID;

/**
 * Created by c3469162 on 20/10/2017.
 */

public class Todo {
    public static final String KEY_UUID = "todo.uuid";
    public static final String KEY_TITLE = "todo.title";
    public static final String KEY_DETAIL = "todo.detail";
    public static final String KEY_DATE = "todo.date";
    public static final String KEY_COMPLETE = "todo.complete";

    private UUID mTodoId;
    private String mTodoTitle;
    private String mTodoDetail;
    private Date mTodoDate;
    private boolean mTodoIsComplete;

    public Todo() {
        mTodoId = UUID.randomUUID();
        mTodoDate = new Date();
    }

    public UUID getTodoId() {
        return mTodoId;
    }

    public void setTodoId(UUID mTodoId) {
        this.mTodoId = mTodoId;
    }

    public String getTodoTitle() {
        return mTodoTitle;
    }

    public void setTodoTitle(String mTodoTitle) {
        this.mTodoTitle = mTodoTitle;
    }

    public String getTodoDetail() {
        return mTodoDetail;
    }

    public void setTodoDetail(String mTodoDetail) {
        this.mTodoDetail = mTodoDetail;
    }

    public Date getTodoDate() {
        return mTodoDate;
    }

    public void setTodoDate(Date mTodoDate) {
        this.mTodoDate = mTodoDate;
    }

    public boolean isTodoIsComplete() {
        return mTodoIsComplete;
    }

    public void setTodoIsComplete(boolean mTodoIsComplete) {
        this.mTodoIsComplete = mTodoIsComplete;
    }

    public Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_UUID, getTodoId().toString());
        bundle.putString(KEY_TITLE, getTodoTitle());
        bundle.putString(KEY_DETAIL, getTodoDetail());
        bundle.putLong(KEY_DATE, getTodoDate().getTime());
        bundle.putBoolean(KEY_COMPLETE, isTodoIsComplete());
        return bundle;
    }

    public static Todo fromBundle(Bundle bundle) {
        Todo todo = new Todo();
        todo.setTodoId(UUID.fromString(bundle.getString(KEY_UUID)));
        todo.setTodoTitle(bundle.getString(KEY_TITLE));
        todo.setTodoDetail(bundle.getString(KEY_DETAIL));
        todo.setTodoDate(new Date(bundle.getLong(KEY_DATE)));
        todo.setTodoIsComplete(bundle.getBoolean(KEY_COMPLETE));
        return todo;
    }
}
