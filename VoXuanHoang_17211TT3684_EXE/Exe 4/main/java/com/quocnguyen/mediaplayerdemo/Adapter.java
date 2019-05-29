package com.quocnguyen.mediaplayerdemo;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.util.AbstractCollection;
import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class Adapter extends BaseAdapter {
    Context context;
    ArrayList<Video> data;
    int layout;

    public Adapter(Context context, ArrayList<Video> data, int layout) {
        this.context = context;
        this.data = data;
        this.layout = layout;
    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyViewHolder viewHolder;
        if(convertView != null){
            viewHolder = new MyViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
            viewHolder.txtSoA = (TextView) convertView.findViewById(R.id.txtNames);
            viewHolder.txtSoB = (TextView) convertView.findViewById(R.id.txtTG);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        final Video video = data.get(position);

        viewHolder.txtSoA.setText(video.getName());
        viewHolder.txtSoB.setText(video.getSinger());




        return convertView;
    }

    public class MyViewHolder{
        TextView txtSoA, txtSoB;
    }


    public void hienThi(int position){
    }
}
