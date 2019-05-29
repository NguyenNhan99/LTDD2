package tdc.edu.vn.test;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
