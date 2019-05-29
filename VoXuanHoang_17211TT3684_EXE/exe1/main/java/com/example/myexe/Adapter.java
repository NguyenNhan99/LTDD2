package com.example.myexe;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView
        .Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<XemBoi> data;
    int layout;

    public Adapter(Context context, ArrayList<XemBoi> data, int layout) {
        this.context = context;
        this.data = data;
        this.layout = layout;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layout, viewGroup, false);

        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        myViewHolder.title.setText(data.get(i).getTitle());
        myViewHolder.img.setImageResource(data.get(i).getIcon());
        myViewHolder.img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                RemoveItem(i);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;

        public MyViewHolder(final  View itemView){
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.img = (ImageView) itemView.findViewById(R.id.imgHinh);


        }


    }
    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void hienThi(int position){
    }
}

