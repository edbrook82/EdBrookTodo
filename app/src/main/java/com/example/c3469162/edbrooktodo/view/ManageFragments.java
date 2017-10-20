package com.example.c3469162.edbrooktodo.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * Created by c3469162 on 20/10/2017.
 */

public class ManageFragments {

    public static void loadFragmentIntoContainer(AppCompatActivity context, String fragmentClass, int container) {
        FragmentManager fm = context.getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(container);

        if (fragment == null) {
            try {
                Class<?> clazz = Class.forName(fragmentClass);
                Constructor<?> constructor = clazz.getConstructor();
                fragment = (Fragment) constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            fm.beginTransaction()
                    .add(container, fragment)
                    .commit();
        }
    }
}
