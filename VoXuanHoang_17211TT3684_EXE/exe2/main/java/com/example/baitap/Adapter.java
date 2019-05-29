package com.example.baitap;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.XucXacViewHolder> {
    private List<XucXac> xucxacList;
    private Context context;
    private int Layout;

    public Adapter(Context context, ArrayList<XucXac> xucxacList, int layout) {
        this.context = context;
        this.xucxacList = xucxacList;
        this.Layout = layout;
    }
    public class XucXacViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon1,icon2;
        private TextView ketqua;

        public XucXacViewHolder(View itemView) {
            super(itemView);
            icon1 = (ImageView) itemView.findViewById(R.id.imgitem1);
            icon2 = (ImageView) itemView.findViewById(R.id.imgitem2);
            ketqua = (TextView) itemView.findViewById(R.id.ketqua);
        }
    }
    @Override
    public XucXacViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(Layout, parent, false);
        return new XucXacViewHolder(row);
    }
    @Override
    public void onBindViewHolder(XucXacViewHolder holder, final  int i) {
        holder.icon1.setAnimation(AnimationUtils.loadAnimation( context, R.anim.fade_aa_layout));
        holder.icon2.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_aa_layout));
        holder.ketqua.setAnimation(AnimationUtils.loadAnimation( context,R.anim.fade_ss_layout));
        final XucXac xucXac = xucxacList.get(i);
        holder.icon1.setImageResource(xucXac.getIcon1());
        holder.icon2.setImageResource(xucXac.getIcon2());
        holder.ketqua.setText(xucXac.getKetqua());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoveItem(i);
                Toast.makeText(context, "Đã Xóa", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return xucxacList.size();
    }
    public void RemoveItem(int i)
    {
        xucxacList.remove(i);
        notifyItemRemoved(i);
    }
}
