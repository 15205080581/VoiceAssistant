package com.fjnu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.edu.viocesimple.R;

import java.util.List;

import bean.ChatBean;
import bean.ItemBean;



public class MyAdapter extends BaseAdapter {
    private List<ItemBean> list;
    private Context context;
    public MyAdapter(List<ItemBean>list, Context context){
        this.list=list;
        this.context=context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHoder hoder=null;

        if (convertView!=null){
            hoder= (ViewHoder) convertView.getTag();
        }else {
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_item,null);
            hoder=new ViewHoder();
            hoder.mTv= (TextView) convertView.findViewById(R.id.content_tv);
            convertView.setTag(hoder);
        }
        hoder.mTv.setText(list.get(position).getContent());
        return convertView;
    }

    class ViewHoder{
        private TextView mTv;

    }
}
