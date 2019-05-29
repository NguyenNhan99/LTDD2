package com.example.baitap;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.XucXacViewHolder> {
    private List<XucXac> xucxacList;
    private Activity activity;

    public Adapter(Activity activity,List<XucXac> xucxacList) {
        this.activity = activity;
        this.xucxacList = xucxacList;
    }
    public class XucXacViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon1;
        private TextView ketqua;

        public XucXacViewHolder(View itemView) {
            super(itemView);
            icon1 = (ImageView) itemView.findViewById(R.id.imgitem1);
            ketqua = (TextView) itemView.findViewById(R.id.ketqua);
        }
    }
    @Override
    public XucXacViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item,parent,false);
        return new XucXacViewHolder(view);
    }
    @Override
    public void onBindViewHolder(XucXacViewHolder holder, final  int i) {

        final XucXac xucXac = xucxacList.get(i);
        holder.icon1.setImageResource(xucXac.getIcon1());

        holder.ketqua.setText(xucXac.getKetqua());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoveItem(i);
                Toast.makeText(activity, "Đã Xóa", Toast.LENGTH_SHORT).show();
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
