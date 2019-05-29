package com.example.myexe;

import android.app.Dialog;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ArrayList<Integer> arrayImg1 = new ArrayList<>();
    SensorManager sensorManager;
    private Sensor sensor;
    private float vibrate = 0;
    RecyclerView recyclerView;
    ArrayList<XemBoi> data = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    ImageView img;
    private float lastX, lastY, lastZ;
    Button boilai;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setAdapter();
        setSensor();
        boilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEvent();
            }
        });
    }

    private void setSensor(){
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
            vibrate = sensor.getMaximumRange() / 2;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            doihinh(event);
        }
    }

    private void doihinh(SensorEvent event) {
        float DeltaX = Math.abs(lastX - event.values[0]);
        float DeltaY = Math.abs(lastY - event.values[1]);
        float DeltaZ = Math.abs(lastZ - event.values[2]);
        if (DeltaX > vibrate){
            setEvent();
        }
        if (DeltaY > vibrate){
            setEvent();
        }
        if (DeltaZ > vibrate){
            setEvent();
        }

        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];
    }

    private void setEvent() {
        XemBoi xemBoi = new XemBoi();
        //img.setImageResource(R.drawable.nen);
        Random random = new Random();
        int vitrri1 = random.nextInt(arrayImg1.size());
        img.setImageResource(arrayImg1.get(vitrri1));
        if(vitrri1 == 0){
            xemBoi.setIcon(R.drawable.foo);
            xemBoi.setTitle("The Fool");
        }else if (vitrri1 == 1){
            xemBoi.setIcon(R.drawable.mg);
            xemBoi.setTitle("The Magican");
        }else if (vitrri1 == 2){
            xemBoi.setIcon(R.drawable.te);
            xemBoi.setTitle("The Empress");
        }else if(vitrri1 == 3){
            xemBoi.setIcon(R.drawable.thp);
            xemBoi.setTitle("The High Priestess");
        }
        data.add(xemBoi);
        adapter.notifyDataSetChanged();
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int position = viewHolder.getAdapterPosition();
                final Dialog dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.dialog_custom);

                ImageView newhinh = (ImageView)findViewById(R.id.hinhmoi);
                TextView thongtin = (TextView)findViewById(R.id.chitiet);
                Button dongy = (Button)findViewById(R.id.dongy);
                if (data.get(position).getIcon() == R.drawable.foo){
                    newhinh.setImageResource( R.drawable.foo);
                    thongtin.setText("The Fool là lá bài về cơ hội, những khởi đầu mới và sự ngây thơ. Lá bài Tarot này thể hiện cơ hội cao nhất trong cuộc đời của bạn, tiến đến một trạng thái của sự đổi mới hay khởi đầu mới, nơi mà mỗi ngày là một cuộc phiêu lưu và là mỗi khoảnh khắc được sống trọn vẹn nhất. Lá The Fool đại diện cho mọi khả năng sáng tạo và mong muốn hoàn tất những mục tiêu mới (hay ít nhất là bắt đầu quá trình lao động để tiến đến những mục tiêu này). The Fool hàm ý bất kỳ điều gì có thể xảy ra và những cơ hội đang chờ thời cơ thuận lợi.");
                    adapter.notifyDataSetChanged();
                }else if(data.get(position).getIcon() == R.drawable.mg){
                    newhinh.setImageResource(R.drawable.mg);
                    thongtin.setText("The Magician thường xuất hiện trong một trải bài Tarot tại một thời điểm nào đó trong cuộc sống khi bạn có khả năng sáng tạo và nguồn năng lượng để tạo ra một chu kỳ sống mới cho chính mình. Bạn có khả năng tận dụng quyền năng của Vạn Vật và biểu lộ những gì mình mong muốn. Lá bài the Magician hàm ý bạn đã (hoặc sẽ sớm) gặp một tình huống trong đó mọi yếu tố cần thiết cho phép biểu lộ các mong muốn đều sẽ được đáp ứng. Những mong muốn này có thể là nhiệt huyết (lửa), vật chất (đất), cảm xúc (nước), hoặc tinh thần (khí), mỗi mong muốn trong số này đều liên kết với 4 yếu tố của Tarot. Bạn có khả năng khiến điều đó xảy ra!");
                    adapter.notifyDataSetChanged();
                }else if(data.get(position).getIcon() == R.drawable.te){
                    newhinh.setImageResource(R.drawable.te);
                    thongtin.setText("The Empress thể hiện sự một sự kết nối sâu sắc với yếu tố nữ tính của chúng ta. Nét nữ tính có thể hiểu theo nhiều cách – vẻ đẹp, sự đam mê khoái cảm, khả năng sinh nở, sáng tạo, việc chăm nom – và là một yếu tố vô cùng cần thiết trong việc tạo sự hòa hợp giữa nam và nữ. Lá bài The Empress gợi nhắc bạn hãy kết nối với năng lượng nữ tính trong bạn. Hãy tạo nên cái đẹp trong cuộc sống của bạn. Giữ liên hệ với đam mê khoái cảm của bạn qua các giác quan như vị giác, xúc giác, thính giác, khứu giác và thị giác. Hãy dựa vào những cảm nhận này để trải nghiệm niềm vui thích cùng sự thỏa mãn đủ đầy. Hãy dành cho bạn một ngày ở spa, học cách mát xa, tận hưởng một buổi tối tuyệt vời, hoặc đơn giản là dành nhiều thời gian hơn cho người bạn đời của bạn.");
                     adapter.notifyDataSetChanged();
                }else if (data.get(position).getIcon() == R.drawable.thp){
                    newhinh.setImageResource(R.drawable.thp);
                    thongtin.setText("The High Priestess đại diện cho sự khôn ngoan, thanh thản, kiến thức và sự hiểu biết. Nhân vật the High Priestess thường được mô tả như người giám hộ của tiềm thức. Nàng ngồi trước tấm màn mỏng của nhận thức, vốn chia cách chúng ta với chính bên trong con người chúng ta. The High Priestess biết bí mật của cách thức tiếp cận đến những lĩnh vực này. Nàng đại diện cho sự giác ngộ tâm linh và khai sáng tâm hồn, kiến thức tiên tri và sự khôn ngoan.");
                    adapter.notifyDataSetChanged();
                }
                dongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        helper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void setControl(){
        img = (ImageView)findViewById(R.id.hinh);
        title = (TextView)findViewById(R.id.title);
        boilai = (Button)findViewById(R.id.Chi);
        arrayImg1.add(R.drawable.foo);
        arrayImg1.add(R.drawable.mg);
        arrayImg1.add(R.drawable.te);
        arrayImg1.add(R.drawable.thp);
    }
    public  void setAdapter(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,data, R.layout.item_layout);
        recyclerView.setAdapter(adapter);
    }

}
