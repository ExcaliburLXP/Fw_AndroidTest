package com.crown.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 适配器
 * Created by liuxipeng on 2016/11/3.
 */

public class MusicAdapter extends BaseAdapter {
    private List<Music> mMusics;
    private Context mContext;
    public MusicAdapter(Context context,List<Music> list) {
        this.mContext=context;
        this.mMusics=list;
    }

    @Override
    public int getCount() {
        return mMusics.size();
    }

    @Override
    public Object getItem(int position) {
        return mMusics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item,null);
            viewHolder.tv_singer= (TextView) convertView.findViewById(R.id.tv_singer);
            viewHolder.tv_song= (TextView) convertView.findViewById(R.id.tv_song);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_singer.setText(mMusics.get(position).getSinger());
        viewHolder.tv_song.setText(mMusics.get(position).getSong());
        return convertView;
    }
    static class  ViewHolder{
        private TextView tv_singer;
        private TextView tv_song;
    }
}
