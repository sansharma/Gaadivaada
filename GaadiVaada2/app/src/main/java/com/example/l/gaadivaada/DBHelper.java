package com.example.l.gaadivaada;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by l on 5/9/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "travelfare.db";
    public static final String USER_TABLE_NAME = "userinformation";
    public static final String ID = "id";
    public static final String STARTING_PLACE = "starting_place";
    public static final String FINAL_DESTINATION = "final_place";
    public static final String TOTAL_DISTANCE = "distance";
    public static final String TOTAL_PRICE = "price";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table faredetails " +
                        "(id integer primary key, starting_place text, final_place text, distance real,price real)"
        );
          ContentValues contentValues = new ContentValues();
          contentValues.put("id", 101);
          contentValues.put("starting_place", "Kathmandu");
          contentValues.put("final_place", "Hetauda");
          contentValues.put("distance", 220);
          contentValues.put("price", 412);

        db.insert("faredetails", null, contentValues);
        contentValues.put("id", 101);
        contentValues.put("starting_place", "Kathmandu");
        contentValues.put("final_place", "Birjung");
        contentValues.put("distance", 270);
        contentValues.put("price", 491);
        db.insert("faredetails", null, contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS faredetails");
        onCreate(db);
    }



    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor myresult =  db.rawQuery( "select * from faredetails", null );
        return myresult;
    }




}
