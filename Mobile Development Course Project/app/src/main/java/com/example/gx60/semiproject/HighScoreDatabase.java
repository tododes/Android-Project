package com.example.gx60.semiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GX60 on 09/03/2017.
 */

public class HighScoreDatabase extends Database
{
    private static HighScoreDatabase singleton;

    public static HighScoreDatabase getDB()
    {
        return singleton;
    }

    public HighScoreDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public HighScoreDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public HighScoreDatabase(Context context, String name, String[] an, String[] at) {
        super(context, name, an, at);
    }

    public void Insert(UserScore us)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(attributeNames[0], us.user.name);
        cv.put(attributeNames[1], us.score);
        cv.put(attributeNames[2], us.user.email);
        db.insert(DatabaseName, null, cv);
    }
}
