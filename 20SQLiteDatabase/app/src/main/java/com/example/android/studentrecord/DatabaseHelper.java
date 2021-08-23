package com.example.android.studentrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyStudent.db";
    public static final String TABLE_NAME = "MyStudent_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Email";
    public static final String COL_4 = "Course_Count";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+
                TABLE_NAME+
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "EMAIL TEXT," +
                "COURSE_COUNT INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+
                TABLE_NAME);
        onCreate(db);
    }

    //Not inserting ID coz it'll be automatically added bcoz of AUTOINCREMENT
    public boolean insertData(String name, String email, String courseCount){

        //Taking permission to write or perform operations data on database
        SQLiteDatabase database = this.getWritableDatabase();

        //ContentValues is a big object which can store multiple values
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,courseCount);

        //Getting the values displayed
        long result = database.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        return true;
    }

    //ID required coz ID is unique which will help us in identifying where to update
    public boolean updateData(String id, String name, String email, String courseCount){

        //Taking permission to write data or perform operations data on database
        SQLiteDatabase database = this.getWritableDatabase();

        //ContentValues is a big object which can store multiple values
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,courseCount);

        database.update(TABLE_NAME,contentValues,"ID=?",new String[]{id});
        return true;
    }

    public Cursor getData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "select * from "+TABLE_NAME+" where id='"+id+"'";
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where id='"+id+"'",null);
//        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[]{id});
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

    public Integer deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"",null);
    }
}
