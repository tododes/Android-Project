package com.example.gx60.semiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by GX60 on 07/03/2017.
 */

public class Database extends SQLiteOpenHelper
{
    protected String DatabaseName;
    protected String TableName;
    protected int tableColumn;
    protected String[] attributeNames;
    protected String[] attributeTypes;

    private static Database singleton;

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public Database(Context context, String name, String[] an, String[] at)
    {
        super(context, name, null, 1);
        DatabaseName = name;
        attributeNames = an;
        attributeTypes = at;
        //singleton = this;
        //SQLiteDatabase db = getWritableDatabase();
    }

    public static Database getDB(Context c)
    {
        if(singleton == null)
            singleton = new Database(c, "UserDB", new String[]{"NAME", "PASSWORD", "GENDER", "EMAIL", "GETNOTIF", "NOTROBOT"}, new String[]{"TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"});
        return singleton;
    }

    public int Insert(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //db.execSQL("DROP TABLE "+DatabaseName);
        ContentValues values = new ContentValues();
        values.put(attributeNames[0], user.name);
        values.put(attributeNames[1], user.password);
        values.put(attributeNames[2], user.gender);
        values.put(attributeNames[3], user.email);
        values.put(attributeNames[4], user.getNotif);
        values.put(attributeNames[5], user.notRobot);
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
