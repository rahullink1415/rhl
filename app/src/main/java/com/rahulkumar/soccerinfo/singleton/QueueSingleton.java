package com.rahulkumar.soccerinfo.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by rahulkumar on 3/5/18.
 */

public class QueueSingleton {
    private static QueueSingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private QueueSingleton(Context context) {
        mCtx =context;
        mRequestQueue = getRequestQueue();

    }
    public static synchronized QueueSingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new QueueSingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
