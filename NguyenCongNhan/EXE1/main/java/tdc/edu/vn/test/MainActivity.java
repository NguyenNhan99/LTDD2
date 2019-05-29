package tdc.edu.vn.test;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCong, btnTru, btnNhan, btnChia;
    EditText soA;
    EditText soB;
    EditText ketqua;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    ArrayList<PhepTinh> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setAdapter();
        setEvent();
    }


    public void setAdapter(){
        recyclerView = findViewById(R.id.rl);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,data, R.layout.listview_item_layout);
        recyclerView.setAdapter(adapter);

    }
    public void setControl()
    {
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        soA = (EditText) findViewById(R.id.soA);
        soB = (EditText) findViewById(R.id.soB);
        ketqua = (EditText) findViewById(R.id.ketqua);
    }
    public void setEvent(){
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kiemtra()) return;
               int temp = Integer.parseInt(soA.getText().toString()) + Integer.parseInt(soB.getText().toString());
               int temps = Integer.parseInt(ketqua.getText().toString());

               PhepTinh pt = new PhepTinh();
               pt.setSoA(soA.getText().toString());
                pt.setSoB(soB.getText().toString());
                pt.setkQ(ketqua.getText().toString());
                pt.setpT("+");



               if (temp == temps){
                   pt.setIcon(R.drawable.aa);
               }else
                   pt.setIcon(R.drawable.ic_android_black_24dp);
               data.add(pt);
               adapter.notifyDataSetChanged();
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kiemtra()) return;
                int temp = Integer.parseInt(soA.getText().toString()) - Integer.parseInt(soB.getText().toString());
                int temps = Integer.parseInt(ketqua.getText().toString());
                PhepTinh pt = new PhepTinh();
                pt.setSoA(soA.getText().toString());
                pt.setSoB(soB.getText().toString());
                pt.setkQ(ketqua.getText().toString());
                pt.setpT("-");



                if (temp == temps){
                    pt.setIcon(R.drawable.aa);
                }else
                    pt.setIcon(R.drawable.ic_android_black_24dp);
                data.add(pt);
                adapter.notifyDataSetChanged();
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kiemtra()) return;
                int temp = Integer.parseInt(soA.getText().toString()) * Integer.parseInt(soB.getText().toString());
                int temps = Integer.parseInt(ketqua.getText().toString());

                PhepTinh pt = new PhepTinh();
                pt.setSoA(soA.getText().toString());
                pt.setSoB(soB.getText().toString());
                pt.setkQ(ketqua.getText().toString());
                pt.setpT("*");



                if (temp == temps){
                    pt.setIcon(R.drawable.aa);
                }else
                    pt.setIcon(R.drawable.ic_android_black_24dp);
                data.add(pt);
                adapter.notifyDataSetChanged();
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kiemtra()) return;
                int temp = Integer.parseInt(soA.getText().toString()) / Integer.parseInt(soB.getText().toString());
                int temps = Integer.parseInt(ketqua.getText().toString());

                PhepTinh pt = new PhepTinh();
                pt.setSoA(soA.getText().toString());
                pt.setSoB(soB.getText().toString());
                pt.setkQ(ketqua.getText().toString());
                pt.setpT("/");



                if (temp == temps){
                    pt.setIcon(R.drawable.aa);
                }else
                    pt.setIcon(R.drawable.ic_android_black_24dp);
                data.add(pt);
                adapter.notifyDataSetChanged();
            }
        });

    }
    public boolean kiemtra() {
        if(soA.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Nhập số A",Toast.LENGTH_LONG).show();
            soA.requestFocus();
            return true;
        }
        else if(soB.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Nhập số B",Toast.LENGTH_LONG).show();
            soB.requestFocus();
            return true;
        }
        else if (ketqua.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Nhập kết quả",Toast.LENGTH_LONG).show();
            ketqua.requestFocus();
            return true;
        }
        return false;

    }

}
