package com.example.baitap;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private ArrayList<XucXac> xucxacList = new ArrayList<>();
    private ArrayList<XucXac> xucxacList2 = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter XucxacAdapter, XucxacAdapter2;
    private RecyclerView recyclerView2;
    SensorManager sensorManager;
    private Sensor sensor;
    private float vibrate = 0;
    private float lastX, lastY, lastZ;
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void setSensor(){
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(sensor.TYPE_ACCELEROMETER) != null){
            sensor =  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
            vibrate = sensor.getMaximumRange() / 2;
        }
    }
    private void doiHinh(SensorEvent event) {
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            doiHinh(event);
        }
    }

    RadioButton r1,r2;
    ImageView imgs,imgx;
    Button btnNhap,btnThoat;
    ArrayList<Integer> arrayImg1;
    ArrayList<Integer> arrayImg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        addControl();
        setSensor();
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }
    public void setControl(){
        btnThoat = findViewById(R.id.thoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Thoát",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        imgs = (ImageView) findViewById(R.id.imgxucxac1);
        imgx = (ImageView) findViewById(R.id.imgxucxac2);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        r1 = (RadioButton) findViewById(R.id.tai);
        r2 = (RadioButton) findViewById(R.id.siu);

        arrayImg1 = new ArrayList<>();

        arrayImg1.add(R.drawable.x1);
        arrayImg1.add(R.drawable.x2);
        arrayImg1.add(R.drawable.x3);
        arrayImg1.add(R.drawable.x4);
        arrayImg1.add(R.drawable.x5);
        arrayImg1.add(R.drawable.x6);

        arrayImg2 = new ArrayList<>();

        arrayImg2.add(R.drawable.s1);
        arrayImg2.add(R.drawable.s2);
        arrayImg2.add(R.drawable.s3);
        arrayImg2.add(R.drawable.s4);
        arrayImg2.add(R.drawable.s5);
        arrayImg2.add(R.drawable.s6);
    }
    public void setEvent(){
        XucXac xucxac = new XucXac();


        Random random = new Random();

        int vitri1 = random.nextInt(arrayImg1.size());
        int vitri2 = random.nextInt(arrayImg2.size());

        if(r1.isChecked() || r2.isChecked()){
            if(vitri1 == 0 && vitri2 == 0 || vitri1 == 0 && vitri2 == 2 || vitri1 == 0 && vitri2 == 4 ||  vitri1 == 1 && vitri2 == 1 || vitri1 == 4 && vitri2 == 2 ||  vitri1 == 2 && vitri2 == 2 ||  vitri1 == 3 && vitri2 == 3 ||  vitri1 == 4 && vitri2 == 4 ||  vitri1 == 5 && vitri2 == 5  ||  vitri1 == 3 && vitri2 == 1 || vitri1 == 5 && vitri2 == 3 )
            {
                addControl();
                xucxac.setKetqua("THẮNG");
                xucxacList.add(xucxac);
                XucxacAdapter.notifyDataSetChanged();
            }else {
                addControl2();
                xucxac.setKetqua("THUA");
                xucxacList2.add(xucxac);
                XucxacAdapter2.notifyDataSetChanged();
            }
        }else if (r2.isChecked()){
            if(vitri1 == 0 && vitri2 == 0 || vitri1 == 0 && vitri2 == 2 || vitri1 == 0 && vitri2 == 4 ||  vitri1 == 1 && vitri2 == 1 ||  vitri1 == 2 && vitri2 == 2 ||  vitri1 == 3 && vitri2 == 3 ||  vitri1 == 4 && vitri2 == 4 ||  vitri1 == 5 && vitri2 == 5  ||  vitri1 == 3 && vitri2 == 1 || vitri1 == 5 && vitri2 == 3)
            {
                addControl2();
                xucxac.setKetqua("THUA");
                xucxacList2.add(xucxac);
                XucxacAdapter2.notifyDataSetChanged();
            }else {
                addControl();
                xucxac.setKetqua("THẮNG");
                xucxacList.add(xucxac);
                XucxacAdapter.notifyDataSetChanged();
            }
        }
        imgx.setImageResource(arrayImg1.get(vitri1));
        imgs.setImageResource(arrayImg2.get(vitri2));
        if(vitri1 == 0 && vitri2 == 0)
        {
            xucxac.setIcon1(R.drawable.s1);
            xucxac.setIcon2(R.drawable.x1);
        }
        else if(vitri1 == 0 && vitri2 == 1)
        {
            xucxac.setIcon1(R.drawable.s1);
            xucxac.setIcon2(R.drawable.x2);
        }else if(vitri1 == 0 && vitri2 == 2 )
        {
            xucxac.setIcon1(R.drawable.s1);
            xucxac.setIcon2(R.drawable.x3);
        }
        else if(vitri1 == 0 && vitri2 == 3 )
        {
            xucxac.setIcon1(R.drawable.s1);
            xucxac.setIcon2(R.drawable.x4);
        }
        else if(vitri1 == 0 && vitri2 == 4 )
        {
            xucxac.setIcon1(R.drawable.s1);
            xucxac.setIcon2(R.drawable.x5);
        }
        else if(vitri1 == 0 && vitri2 == 5 )
        {
            xucxac.setIcon1(R.drawable.s1);
            xucxac.setIcon2(R.drawable.x6);
        }
        else if(vitri1 == 1 && vitri2 == 0 )
        {
            xucxac.setIcon1(R.drawable.s2);
            xucxac.setIcon2(R.drawable.x1);
        }
        else if(vitri1 == 1 && vitri2 == 1 )
        {
            xucxac.setIcon1(R.drawable.s2);
            xucxac.setIcon2(R.drawable.x2);
        }
        else if(vitri1 == 1 && vitri2 == 2)
        {
            xucxac.setIcon1(R.drawable.s2);
            xucxac.setIcon2(R.drawable.x3);
        }
        else if(vitri1 == 1 && vitri2 == 3 )
        {
            xucxac.setIcon1(R.drawable.s2);
            xucxac.setIcon2(R.drawable.x4);
        }
        else if(vitri1 == 1 && vitri2 == 4 ) {
            xucxac.setIcon1(R.drawable.s2);
            xucxac.setIcon2(R.drawable.x5);

        }
        else if(vitri1 == 1 && vitri2 == 5 )
        {
            xucxac.setIcon1(R.drawable.s2);
            xucxac.setIcon2(R.drawable.x6);
        }
        else if(vitri1 == 2 && vitri2 == 0 )
        {
            xucxac.setIcon1(R.drawable.s3);
            xucxac.setIcon2(R.drawable.x1);
        }
        else if(vitri1 == 2 && vitri2 == 1 )
        {
            xucxac.setIcon1(R.drawable.s3);
            xucxac.setIcon2(R.drawable.x2);
        }
        else if(vitri1 == 2 && vitri2 == 2 )
        {
            xucxac.setIcon1(R.drawable.s3);
            xucxac.setIcon2(R.drawable.x3);
        }
        else if(vitri1 == 2 && vitri2 == 3 )
        {
            xucxac.setIcon1(R.drawable.s3);
            xucxac.setIcon2(R.drawable.x4);
        }
        else if(vitri1 == 2 && vitri2 == 4 )
        {
            xucxac.setIcon1(R.drawable.s3);
            xucxac.setIcon2(R.drawable.x5);
        }
        else if(vitri1 == 2 && vitri2 == 5 )
        {
            xucxac.setIcon1(R.drawable.s3);
            xucxac.setIcon2(R.drawable.x6);
        }
        else if(vitri1 == 3 && vitri2 == 0 )
        {
            xucxac.setIcon1(R.drawable.s4);
            xucxac.setIcon2(R.drawable.x1);
        }
        else if(vitri1 == 3 && vitri2 == 1 )
        {
            xucxac.setIcon1(R.drawable.s4);
            xucxac.setIcon2(R.drawable.x2);
        }
        else if(vitri1 == 3 && vitri2 == 2 )
        {
            xucxac.setIcon1(R.drawable.s4);
            xucxac.setIcon2(R.drawable.x3);
        }
        else if(vitri1 == 3 && vitri2 == 3 )
        {
            xucxac.setIcon1(R.drawable.s4);
            xucxac.setIcon2(R.drawable.x4);
        }
        else if(vitri1 == 3 && vitri2 == 4 )
        {
            xucxac.setIcon1(R.drawable.s4);
            xucxac.setIcon2(R.drawable.x5);
        }
        else if(vitri1 == 3 && vitri2 == 5 )
        {
            xucxac.setIcon1(R.drawable.s4);
            xucxac.setIcon2(R.drawable.x6);
        }
        else if(vitri1 == 4 && vitri2 == 0 )
        {
            xucxac.setIcon1(R.drawable.s5);
            xucxac.setIcon2(R.drawable.x1);
        }
        else if(vitri1 == 4 && vitri2 == 1 )
        {
            xucxac.setIcon1(R.drawable.s5);
            xucxac.setIcon2(R.drawable.x2);
        }
        else if(vitri1== 4 && vitri2 == 2 )
        {
            xucxac.setIcon1(R.drawable.s5);
            xucxac.setIcon2(R.drawable.x3);
        }
        else if(vitri1 == 4 &&vitri2 == 3 )
        {
            xucxac.setIcon1(R.drawable.s5);
            xucxac.setIcon2(R.drawable.x4);
        }
        else if(vitri1 == 4 && vitri2 == 4 )
        {
            xucxac.setIcon1(R.drawable.s5);
            xucxac.setIcon2(R.drawable.x5);
        }
        else if(vitri1 == 4 && vitri2 == 5 )
        {
            xucxac.setIcon1(R.drawable.s5);
            xucxac.setIcon2(R.drawable.x6);
        }
        else if(vitri1 == 5 && vitri2 == 0  )
        {
            xucxac.setIcon1(R.drawable.s6);
            xucxac.setIcon2(R.drawable.x1);
        }
        else if(vitri1 == 5 && vitri2 == 1  )
        {
            xucxac.setIcon1(R.drawable.s6);
            xucxac.setIcon2(R.drawable.x2);
        }
        else if(vitri1 == 5 && vitri2 == 2  )
        {
            xucxac.setIcon1(R.drawable.s6);
            xucxac.setIcon2(R.drawable.x3);
        }
        else if(vitri1 == 5 && vitri2 == 3  )
        {
            xucxac.setIcon1(R.drawable.s6);
            xucxac.setIcon2(R.drawable.x4);
        }
        else if (vitri1 == 5 && vitri2 == 4 )
        {
            xucxac.setIcon1(R.drawable.s6);
            xucxac.setIcon2(R.drawable.x5);
        }
        else if(vitri1 == 5 && vitri2 == 5){
            xucxac.setIcon1(R.drawable.s6);
            xucxac.setIcon2(R.drawable.x6);
        }


    }
    private void addControl() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        XucxacAdapter = new Adapter(this,xucxacList, R.layout.recyclerview_item);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(XucxacAdapter);
    }
    private void addControl2() {
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        XucxacAdapter2 = new Adapter(this,xucxacList2, R.layout.recyclerview_item);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView2.setLayoutManager(mLayoutManager);
        recyclerView2.setAdapter(XucxacAdapter2);
    }
    private void addEvent() {
        createData1();
    }
    public void createData1() {

    }
    public void reset(){
        imgx.setImageResource(R.drawable.s1);
        imgs.setImageResource(R.drawable.x1);
    }
}
