package com.example.sqldemopractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    // called the first time you try to access database object. Code to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableStatement ="CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT, " + COLUMN_ACTIVE_CUSTOMER + " BOOL)";
        db.execSQL(CreateTableStatement);
    }

    //called if the app version number changes, it prevents previous users app from breaking down
    // when the database design changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CustomerModel customerModel){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    cv.put(COLUMN_CUSTOMER_NAME, customerModel.getName());
    cv.put(COLUMN_CUSTOMER_AGE, customerModel.getAge());
    cv.put(COLUMN_ACTIVE_CUSTOMER, customerModel.isActive());

    long insert = db.insert(CUSTOMER_TABLE, null, cv);
    if (insert==-1){
        return false;
    }else {
        return true;
    }
    }
}
