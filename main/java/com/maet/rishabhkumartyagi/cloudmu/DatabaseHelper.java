package com.maet.rishabhkumartyagi.cloudmu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "TIME";
    public static final String COL_3 = "CITY";
    public static final String COL_4 = "TEMP";
    public static final String COL_5 = "HUMIDITY";
    public static final String COL_6 = "DESC";
    public static final String COL_7 = "TYPE";
    public static final String COL_8 = "EMOTION";
    public static final String COL_9 = "AGE";
    public static final String COL_10 = "GENDER";
    public static final String COL_11 = "SNAME";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (NAME TEXT,TIME TEXT,CITY TEXT,AGE INTEGER,GENDER TEXT,TEMP INTEGER,HUMIDITY INTEGER,DESC TEXT,TYPE TEXT,EMOTION TEXT,SNAME TEXT)");
        db.execSQL("create table USER (UNAME TEXT,PASSWORD TEXT,CITY TEXT,NAME TEXT,AGE INTEGER,GENDER TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(db);
    }



    public boolean pass(String UNAME,String PASSWORD){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from USER",null);
        if(res.getCount() == 0)
            return false;
        while(res.moveToNext()) {

            String tempun = res.getString(0);
            String tempps = res.getString(1);


            if (tempun.matches(UNAME)&&tempps.matches(PASSWORD)) {

                    return true;
            }

        }
        return false;
    }

    public int[] newUser(String UNAME,String PASSWORD,String NAME,int AGE,String GENDER){
        int fl[]=new int[]{0,0,0,0};


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select UNAME from USER",null);
        while(res.moveToNext()) {
            if (res.getString(0).matches(UNAME)) {
                fl[0]=1;
                break;
            }
        }

        if((AGE+0)<=0){
            fl[1]=1;
        }
        if(UNAME.matches("")){
            fl[2]=1;
        }
        if(PASSWORD.matches("")){
           fl[3]=1;
        }

        int sum=fl[0]+fl[1]+fl[3]+fl[3];

        if(sum==0)
        insertTABData( UNAME, PASSWORD, NAME, AGE, GENDER);

        return fl;

    }

    /*public boolean icusr(String uname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SNO",1);
        contentValues.put("UNAME",uname);
        long result = db.update("CUSER",contentValues,"SNO = 1",null);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor gcusr() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from CUSER",null);
        return res;
    }*/

    public boolean insertTABData(String UNAME,String PASSWORD,String NAME,int AGE,String GENDER) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UNAME",UNAME);
        contentValues.put("PASSWORD",PASSWORD);
        contentValues.put("NAME",NAME);
        contentValues.put("AGE",AGE);
        contentValues.put("GENDER",GENDER);

        long result = db.insert("USER",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertUSData(String name,String TIME,String CITY,int AGE,String GENDER,int TEMP ,int HUMIDITY,String DESC ,String TYPE ,String EMOTION,String SNAME) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,TIME);
        contentValues.put(COL_3,CITY);
        contentValues.put(COL_4,AGE);
        contentValues.put(COL_5,GENDER);
        contentValues.put(COL_6,TEMP);
        contentValues.put(COL_7,HUMIDITY);
        contentValues.put(COL_8,DESC);
        contentValues.put(COL_9,TYPE);
        contentValues.put(COL_10,EMOTION);
        contentValues.put(COL_11,SNAME);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public Cursor getAllDatau() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from USER",null);
        return res;
    }

    public int getUserCount(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCount= db.rawQuery("select count(*) from USER",null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }

    public Cursor getHOTSongCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCount;
        try {
        mCount= db.rawQuery ("select count(*) as cnt,SNAME from student_table where DESC >25  GROUP BY SNAME ORDER BY cnt DESC",null);
    }catch(Exception e){mCount=null;}
       ;
        return mCount;
    }

    public Cursor getCOLDSongCount(){
        SQLiteDatabase db = this.getReadableDatabase();
         Cursor mCount;
        try {
            mCount = db.rawQuery("select count(*) as cnt,SNAME from student_table where DESC <=25  GROUP BY SNAME ORDER BY cnt DESC", null);
        }catch(Exception e){mCount=null;}

        return mCount;
    }

    public int getUserAge(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        int dbgend =0;
        Cursor res = db.rawQuery("select * from USER", null);
        while(res.moveToNext()) {

            String dbname = res.getString(0);
            try {
                 dbgend = Integer.parseInt(res.getString(4));
            }catch(Exception e){}

            if (dbname.matches(name)) {

                return dbgend;
            }

        }

        return 0;
    }

    public String getUserGend(String name){
        SQLiteDatabase db = this.getWritableDatabase();


            Cursor res = db.rawQuery("select * from USER", null);
        while(res.moveToNext()) {

            String dbname = res.getString(0);
            String dbgend = res.getString(5);


            if (dbname.matches(name)) {

                return dbgend;
            }

        }

        return "";
    }

    public boolean deleteTitle(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String KEY_NAME = "UNAME";
        return db.delete("USER", KEY_NAME + "=" + name, null) > 0;
    }
}