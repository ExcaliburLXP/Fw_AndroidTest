package com.crown.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by liuxipeng on 2016/11/3.
 */

public class DBHelper extends SQLiteOpenHelper {

    private final static String DB_NAME ="music.db";//数据库名
    private final static int VERSION = 1;//版本号
    public DBHelper(Context context) {
        super(context,DB_NAME , null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table music(" +
                "id integer primary key autoincrement," +
                "singer varchar(20),song varchar(20)"+
                ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
