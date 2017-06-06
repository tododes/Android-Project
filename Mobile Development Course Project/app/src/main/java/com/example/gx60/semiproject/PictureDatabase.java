package com.example.gx60.semiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GX60 on 31/03/2017.
 */

public class PictureDatabase extends Database
{
    protected String DatabaseName;
    protected String TableName;
    protected int tableColumn;
    protected String[] attributeNames;
    protected String[] attributeTypes;

    private static PictureDatabase singleton;

    public PictureDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public PictureDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public PictureDatabase(Context context, String name, String[] an, String[] at)
    {
        super(context, name, null, 1);
        DatabaseName = name;
        attributeNames = an;
        attributeTypes = at;
        singleton = this;
        //SQLiteDatabase db = getWritableDatabase();
    }

    public static PictureDatabase getDB()
    {
        return singleton;
    }

    public int Insert(String s)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //db.execSQL("DROP TABLE "+DatabaseName);
        ContentValues values = new ContentValues();
        values.put(attributeNames[0], s);
        db.insertOrThrow(DatabaseName, null, values);
        return 1;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor allData = db.rawQuery("SELECT * FROM "+DatabaseName, null);
        return allData;
    }

    public Cursor getQuery(String q)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(q, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String dbCreator = "CREATE TABLE " + DatabaseName;
        dbCreator += "(";
        for(int i=0;i<attributeNames.length;i++)
        {
            if(i == attributeNames.length - 1)
                dbCreator += attributeNames[i] + " " + attributeTypes[i];
            else
                dbCreator += attributeNames[i] + " " + attributeTypes[i] + ", ";
        }
        dbCreator += ")";
        System.out.println(dbCreator);
        db.execSQL(dbCreator);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS "+DatabaseName);
        onCreate(db);
    }

    public void Clear()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DatabaseName, null, null);
    }
}
