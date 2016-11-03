package com.crown.test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxipeng on 2016/11/3.
 * 数据库操作
 */

public class MusicDao {
    DBHelper mDBHelper=null;

    public MusicDao(Context context) {
        mDBHelper=new DBHelper(context);
    }
    // 插入操作
    public void insertData(Music music) {
        String sql = "insert into music (singer,song)values(?,?)";
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        db.execSQL(sql, new Object[] { music.getSinger(), music.getSong() });
    }
    //批量插入操作
    public void insertDatas(List<Music> musics) {
        String sql = "insert into music (singer,song)values(?,?)";
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        for(Music music:musics) {
            db.execSQL(sql, new Object[]{music.getSinger()==null?"":music.getSinger(), music.getSong()==null?"":music.getSong()});
        }
    }
    // 删除操作
    public void deleteData(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        //删除SQL语句
        String sql = "delete from music where id ="+id;
        //执行SQL语句
        db.execSQL(sql);
    }
    //查询操作
    public List<Music> queryDatas() {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        List<Music> musics=new ArrayList<>();
        //查询获得游标
        Cursor cursor = db.query ("music",null,null,null,null,null,null);
        Music music=null;
        //判断游标是否为空
        if(cursor.moveToFirst()) {
            //遍历游标
                while (cursor.moveToNext()){
                //获得歌手名字
                String singer = cursor.getString(cursor.getColumnIndex("singer"));
                //获得歌曲名字
                String song = cursor.getString(cursor.getColumnIndex("song"));
                music=new Music(singer,song);
                musics.add(music);
            }
        }
        cursor.close();
        return musics;
    }
}