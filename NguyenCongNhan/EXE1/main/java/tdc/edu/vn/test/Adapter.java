package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<PhepTinh> data;
    int layout;

    public Adapter(Context context, ArrayList<PhepTinh> data, int layout) {
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

        myViewHolder.txtSoA.setText(data.get(i).getSoA());
        myViewHolder.txtSoB.setText(data.get(i).getSoB());
        myViewHolder.txtPhepTinh.setText(data.get(i).getpT());
        myViewHolder.txtKQ.setText(data.get(i).getkQ());
        myViewHolder.imKq.setImageResource(data.get(i).getIcon());

        myViewHolder.imKq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoveItem(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imKq;
        TextView txtSoA, txtSoB, txtPhepTinh, txtKQ;

        public MyViewHolder(final  View itemView){
            super(itemView);
            this.txtSoA = (TextView) itemView.findViewById(R.id.txtSA);
            this.txtSoB = (TextView) itemView.findViewById(R.id.txtSB);
            this.txtKQ = (TextView) itemView.findViewById(R.id.txtSC);
            this.txtPhepTinh = (TextView) itemView.findViewById(R.id.txtSD);
            this.imKq = (ImageView) itemView.findViewById(R.id.img);


        }


    }
    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }


}
