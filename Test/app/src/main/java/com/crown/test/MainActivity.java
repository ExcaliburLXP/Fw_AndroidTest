package com.crown.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 4.写一个android程序，把json文件插入数据库，并且设计一个列表，把所有数据展示出来
 */
public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MusicAdapter mMusicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        MusicDao dao=new MusicDao(this);
        List<Music> list=dao.queryDatas();
        mListView= (ListView) findViewById(R.id.lv_music);
        mMusicAdapter=new MusicAdapter(this,list);
        mListView.setAdapter(mMusicAdapter);

    }

    /**
     * 从文件中读取json字符串
     */
    public String readJsonFile(){
        StringBuilder stringBuilder=new StringBuilder("");
        try {
            InputStream in = getAssets().open("json.txt");  //获得AssetManger 对象, 调用其open 方法取得  对应的inputStream对象
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while( (line=reader.readLine())!=null) {
               stringBuilder.append(line);
            }

            in.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();


    }
    /**
     * 将json中数据插入数据库
     */
    public  void  addData(){
        String str=readJsonFile();
        Gson gson=new Gson();
        //Json字符串转List
        // TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换
        List<Music> musics = gson.fromJson(str, new TypeToken<List<Music>>() {
        }.getType());
        MusicDao dao=new MusicDao(this);
        dao.insertDatas(musics);

    }


}
