package com.rahulkumar.soccerinfo.utilty;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by rahulkumar on 3/5/18.
 */

public class Utility {
    public static void log(String TAG,String s){
        Log.e(TAG, "log: " +s);
    }
    public static void toast(Context context, String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}
