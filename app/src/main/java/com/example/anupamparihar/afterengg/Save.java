package com.example.anupamparihar.afterengg;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;

/**
 * Created by anupam parihar on 11-07-2018.
 */

public class Save {

    public static void save(Context ctx, String name,String value)
    {
        SharedPreferences s = ctx.getSharedPreferences("afterengg",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit= s.edit();
        edit.putString(name,value);
        edit.apply();
    }

    public static String read(FragmentActivity ctx, String name, String defaultvalue)
    {
        SharedPreferences s = ctx.getSharedPreferences("afterengg",Context.MODE_PRIVATE);
        return s.getString(name,defaultvalue);
    }
}
