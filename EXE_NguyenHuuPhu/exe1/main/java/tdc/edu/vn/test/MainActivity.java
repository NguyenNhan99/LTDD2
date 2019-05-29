package tdc.edu.vn.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnKQ, btnOUT, btnDS;
    EditText txtTen;
    EditText txtSoThich;
    RadioButton r1, r2;
    String value1, value2;
    RecyclerView recyclerView, recyclerView2;
    RecyclerView.LayoutManager layoutManager, layoutManager2;
    RecyclerView.Adapter adapter, adapter2;

    ArrayList<SoThich> data = new ArrayList<>();
    ArrayList<SoThich> data2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setAdapter();
        setAdapter2();
        setEvent();


    }


    public void setAdapter() {
        recyclerView = findViewById(R.id.rl);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this, data, R.layout.listview_item_layout);
        recyclerView.setAdapter(adapter);

    }

    public void setAdapter2() {
        recyclerView2 = (RecyclerView) findViewById(R.id.r3);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        adapter2 = new Adapter(this, data2, R.layout.listview_item_layout);
        recyclerView2.setAdapter(adapter2);

    }


    public void setControl() {
        btnOUT = (Button) findViewById(R.id.out);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        btnKQ = (Button) findViewById(R.id.btnKQ);
        btnDS = (Button) findViewById(R.id.btnDS);
        txtTen = (EditText) findViewById(R.id.soA);
        txtSoThich = (EditText) findViewById(R.id.soB);
    }

    public void setEvent() {
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemtra()) return;
                value1 = txtTen.getText().toString();
                value2 = txtSoThich.getText().toString();
                SoThich pt = new SoThich();
                pt.setTxtTen("Họ và Tên : " + value1);
                pt.setTxtSoThich("Sở Thích: " + value2);

                Toast.makeText(getApplicationContext(), "Đã lưu thành công ! ", Toast.LENGTH_LONG).show();

                if (r1.isChecked()) {
                    pt.setIcon(R.drawable.boy);
                    pt.setTxtGT("Nam");
                    data.add(pt);
                    adapter.notifyDataSetChanged();
                } else if (r2.isChecked()) {
                    pt.setIcon(R.drawable.girl);
                    pt.setTxtGT("Nữ");
                    data2.add(pt);
                    adapter2.notifyDataSetChanged();
                }

            }

        });
        btnOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                Intent starMain = new Intent(Intent.ACTION_MAIN);
                starMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(starMain);
                finish();
            }
        });

        btnDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });


        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int position = viewHolder.getAdapterPosition();
                data.remove(position);
                Toast.makeText(getApplicationContext(), "Xóa thành công!!!", Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
            }
        });
        helper.attachToRecyclerView(recyclerView);


        ItemTouchHelper helper2 = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int position = viewHolder.getAdapterPosition();
                data2.remove(position);
                Toast.makeText(getApplicationContext(), "Xóa thành công!!!", Toast.LENGTH_LONG).show();
                adapter2.notifyDataSetChanged();
            }
        });
        helper2.attachToRecyclerView(recyclerView2);



    }


    public boolean kiemtra() {
        if (txtTen.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Mời bạn nhập tên!!!", Toast.LENGTH_LONG).show();
            txtTen.requestFocus();
            return true;
        }
        if (txtSoThich.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Mời bạn nhập sở thích!!!", Toast.LENGTH_LONG).show();
            txtSoThich.requestFocus();
            return true;
        }

        return false;

    }

    public void show() {
        String ten = txtTen.getText() + "";

        String st = txtSoThich.getText() + "";

        String gt = "";
        RadioGroup gr = (RadioGroup) findViewById(R.id.rd);

        int id = gr.getCheckedRadioButtonId();

        RadioButton radioButton = (RadioButton) findViewById(id);
        gt = radioButton.getText() + "";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        String tt = ten + "\n";
        tt += gt + "\n";
        tt += "--------------------------\n";
        tt += st;

        builder.setMessage(tt);
        builder.create().show();
    }

}
