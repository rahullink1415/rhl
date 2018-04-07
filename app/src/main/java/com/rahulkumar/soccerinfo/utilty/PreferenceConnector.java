package com.rahulkumar.soccerinfo.utilty;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.rahulkumar.soccerinfo.model.Search;
import com.rahulkumar.soccerinfo.model.Sports;

/**
 * The class PreferenceConnector is a class useful to
 * simplify you the interaction with your app preferences.
 * In fact it has methods that interact with the basical features
 * of SharedPreferences but still the possibility to obtain
 * preferences.
 */

public class PreferenceConnector {
    public static final int MODE = Context.MODE_PRIVATE;
    public static final String PREF_NAME = "APP_PREFERENCE";
    public static final String USER_INFO = "user_info";

    public static void writeBoolean(Context context, String key, boolean value) {
        getEditor(context).putBoolean(key, value).commit();
    }

    public static boolean readBoolean(Context context, String key, boolean defValue) {
        return getPreferences(context).getBoolean(key, defValue);
    }

    public static void writeInteger(Context context, String key, int value) {
        getEditor(context).putInt(key, value).commit();
    }

    public static int readInteger(Context context, String key, int defValue) {
        return getPreferences(context).getInt(key, defValue);
    }

    public static void writeString(Context context, String key, String value) {
        getEditor(context).putString(key, value).commit();
    }


    public static String readString(Context context, String key, String defValue) {
        return getPreferences(context).getString(key, defValue);
    }


    public static void writeFloat(Context context, String key, float value) {
        getEditor(context).putFloat(key, value).commit();
    }

    public static float readFloat(Context context, String key, float defValue) {
        return getPreferences(context).getFloat(key, defValue);
    }


    public static void writeLong(Context context, String key, long value) {
        getEditor(context).putLong(key, value).commit();
    }

    public static long readLong(Context context, String key, long defValue) {
        return getPreferences(context).getLong(key, defValue);
    }

    public static SharedPreferences getPreferences(Context context) {
        if (context == null) {
            return null;
        }

        return context.getSharedPreferences(PREF_NAME, MODE);
    }

    public static void clearSharePreferenceKey(Context context, String key) {
        getPreferences(context).edit().remove(key).commit();
    }

    public static Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    public static void writeSearch(Context context, String Key, Search search) {
        Gson gson = new Gson();
        String infoData = gson.toJson(search);
        getEditor(context).putString(Key, infoData).commit();
    }

    public static Search readSearch(Context context, String key) {
        Search search;
        if (getPreferences(context).contains(key)) {
            Gson gson = new Gson();
            String lookupJson = getPreferences(context).getString(key, null);
            search = gson.fromJson(lookupJson, Search.class);
        } else
            return null;
        return search;
    }
}