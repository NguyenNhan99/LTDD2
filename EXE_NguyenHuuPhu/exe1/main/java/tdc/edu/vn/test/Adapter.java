package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<SoThich> data;
    int layout;

    public Adapter(Context context, ArrayList<SoThich> data, int layout) {
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
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i) {

        myViewHolder.txtTen.setText(data.get(i).getTxtTen());
        myViewHolder.txtSoThich.setText(data.get(i).getTxtSoThich());
        myViewHolder.txtGT.setText(data.get(i).getTxtGT());
        myViewHolder.icon.setImageResource(data.get(i).getIcon());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView txtTen, txtSoThich, txtGT;

        public MyViewHolder(final  View itemView){
            super(itemView);
            this.txtTen = (TextView) itemView.findViewById(R.id.txtTen);
            this.txtSoThich = (TextView) itemView.findViewById(R.id.txtSoThich);
            this.txtGT = (TextView) itemView.findViewById(R.id.txtKQ);

            this.icon = (ImageView) itemView.findViewById(R.id.img);

        }


    }
    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }



}
