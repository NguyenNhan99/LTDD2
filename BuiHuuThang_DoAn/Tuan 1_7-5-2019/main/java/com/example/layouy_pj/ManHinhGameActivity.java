package com.example.layouy_pj;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ManHinhGameActivity extends AppCompatActivity {

    int a, b;
    ArrayList<CauHoi> data;
    Button cautl01,cautl02,cautl03,cautl04;
    TextView CauHoi,tv, txtSC;
    ImageView imggame;
    CountDownTimer w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_game);
        setCauHoi();
        setControl();
        setEvent();
        w = new CountDownTimer(60000, 1000) {
            public void onTick(long mil) {
                tv.setText("Seconds remaining: " + mil / 1000);
            }

            public void onFinish() {
                tv.setText("Seconds remaining: 0");
            }
        }.start();
        txtSC.setText("Tổng câu hỏi: " + data.size());
    }
    private void setCauHoi() {
        data = new ArrayList<>();
        data.add(new CauHoi("1+1","99","100","200","2","2","thì bằng 2 chứ bằng mấy","ăn lol r !! ",R.drawable.anhmenu02));
        data.add(new CauHoi("a + b","a","b","abc","ab","ab","sao hay quá v","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Đâu là tên một truyện ngắn của nhà văn Thạch Lam","Một đứa trẻ","Ba đứa trẻ","Hai đứa trẻ","Bốn đứa trẻ","Hai đứa trẻ","Hai đứa trẻ chứ gì nữa :v","Nên đi học lại đi cưng",R.drawable.anhmenu03));
        data.add(new CauHoi("Môn thi nào học sinh khó quay cop nhất","Thể dục","Trắc nghiệm","Vấn đáp","Mình thích thì quay thôi","Vấn đáp","Thi vấn đáp thì quay cop kiểu méo gì được","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Trên cây có 1 con chim, sau đó có ba con chim bay tới rồi có tỷ tỷ con chim bay tới. Hỏi trên cây có mấy con chim","Nhiều quá đếm k nỗi","3","4","1","3","1 con chim + bố của con chim + chị của con chim = 3 con chim","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Cái gì lắc nhẹ đâu đâu cũng rền","Cái miệng","Cái mõ","Cái loa","Cái chuông","Cái chuông","Chuông kêu khẻ đánh bên thành cũng kêu :V ","Bạn ngu vãi shitttt",R.drawable.anhmenu01));
        data.add(new CauHoi("Loài chim nào lớn nhất nhưng óc lại bé nhất","Con cú","Lạc đà","Chim cu","Đà điểu","Đà điểu","Mình thích thì mình cho đúng thôi","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Người phụ nữa đầu tiên vào không gian là người nước nào ","Trung Quốc","Không có đáp án đúng","Hoa kỳ","Liên xô","Liên xô","Bạn rất tỉnh và đẹp trai","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Làm thế nào để khiến một người không thể mở mắt trong thời gian dài","Tiêm cho liều thuốc ngủ","Nhắm mắt hay không liên quan gì đến tao?","Đánh cho bất tỉnh","Đơn giả là cho anh ta ngủ một giất dài","Đơn giả là cho anh ta ngủ một giất dài","Nếu không phải đã chết thì chỉ có khi ngủ thì mới nhắm mắt thôi :3","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Nhà Nam có 4 anh chị em, 3 người lớn là Xuân, Hạ, Thu. Đố bạn người em út tên gì?","Đông","Nam","Tây","Bắt","Nam","Đây là nhà Nam thì tất nhiên phải có Nam rồi, 3 người tên, Xuân, Hạ, Thu rồi thì tất nhiên phải là Nam","M ngu thế",R.drawable.anhmenu01));
        data.add(new CauHoi("Con gì gần gũi với con người nhất","Con mèo","Con gà","Con chấy","Con chó","Con chấy","Á mày có bị chấy không hả chó?","Nên chơi lại đi ",R.drawable.anhmenu01));
        data.add(new CauHoi("Chổ nào hồng hồng, mềm mềm, ướt ướt ^^","Chổ ấy","Cái lưỡi","Cái mũi","Cái môi dưới","Cái lưỡi","Hihi các bạn đừng có nghĩ bậy nhaaa","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Càng chơi càng ra nước","Chơi ABCXYZ :v ","Trò chơi cảm giác mạnh","Chơi nước","Chơi cờ","Chơi cờ","Đã bao giờ chơi cờ chưa :v Đi từng nước cờ chứ không phải nước ấy đâu nhé. Nghiêm cấm nghĩ bậy dưới mọi hình thức Hahaaaaa","vậy cug sai",R.drawable.anhmenu04));
        data.add(new CauHoi("Ai ngu nhất?","Admin","Thằng ngu","Thằng trộm","Con bò","Thằng ngu","Thằng ngu thì tât nhiên phải ngu nhất rồi, From admin: có đứa nào chọn t không thế :3","vậy cug sai",R.drawable.anhmenu02));
        data.add(new CauHoi("Có một ngôi nhà mà không ai muốn ở. Là nhà nàooooo","Nhà tù","Thà gái","Nhà ma","Nhà chồng","Nhà tù","Hihi nhà tù thì đương nhiên không ai muốn ở rồi","vậy cug sai",R.drawable.anhmenu03));
        data.add(new CauHoi("Một người đang đi thì dính mưa, nhìn thấy 1 con cò, hỏi tại sao người đó lại về","Sợ con cò nên về","Về trú mưa","Không có dù","Thích thì về","Thích thì về","Thích thì về thôi, hỏi gì lắm thế","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Cái gì 1 tháng có 1 lần, 1 ngày là hết","Lương","Chịu","Trăng rằm","Máu","Trăm rằm","Giải thích là cái gì nhỉ, có ăn được không :v ","vậy cug sai",R.drawable.anhmenu01));
        data.add(new CauHoi("Khi 2 người bắt đầu yêu nhau thì họ sẽ làm gì đầu tiên?","Không quan tâm câu này","Hôn nhau","làm chuyện ấy ấy","Bắt đầu tỏ lời yêu","Bắt đầu tỏ lời yêu","Không cần lời giải thích chắc bạn vẫn hiểu chứ :v Chúc bạn may mắn với câu hỏi tiếp theo","Ái chà chà",R.drawable.anhmenu01));
        data.add(new CauHoi("Tháng nào ngăn nhất trong năm","12","2","5","1","1","Thích thế á, được k nào","Ái chà chà",R.drawable.anhmenu01));
        data.add(new CauHoi("Thứ gì giống móng tay của bạn nhất","Móng chân","Móng lợn","Móng gà","Không giống gì","Móng chân","Trên cơ thể người thì chả có móng tay và móng chân là giống nhau thôi","Ái chà chà",R.drawable.anhmenu01));
        data.add(new CauHoi("Con nào khác nhất trong các con còn lại","Con gấu","Con dê","con heo","Con gà","Con gấu","Con gấu là người yêu ấy anh em à :v ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Lịch nào dài nhất","Lịch treo tường","Lịch lãm","Lịch lè","Lịch sử","Lịch sử","Câu này mà không biết thì nên xóa game đi bồ ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Bạn có biết cách nào để lông mày mọc dưới mắt?","Trồng cây chuối","Bỏ thuốc mọc tóc vào mắt","Ra tiệm xăm","Lấy bút vẻ","Trồng cây chuối","Thử đi bạn :v ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Một người nông dân có 40 con gà, do bị dịch cúm, tất cả trừ 9 con bị chết, Có bao nhiêu con còn sống","9","27","10","1","9","Có 40 con gà, do bị dịch cúm tất cả trừ 9 con bị chết, tức là tất cả đều chết trừ 9 con :v ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Muỗi sống nhờ gì?","Muỗi đực","Môi trường","Đập hụt","Máu","Đập hụt","Đập trúng là nó chết cmnr","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Bồn bên thành lũy đắp cao, giặc đánh ào ào, thiếp ở trong cung là gì?","Cái võng","Cái chiếu","Cái mùng","Cái áo","Cái mùng","Thông minh đấy bạn","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Tay phải mày cầm 4 quả lê, 3 quả táo. Tay trái mày cầm được 5 quả sầu riêng thì mày sẽ có gì?","Có một bàn tay rất to","Có quả để ăn","Không có gì hết","Có lê, có táo","Có một bàn tay rất to","Cầm hết được từng đó quả thì chả to tố bố ra ấy chứ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Người chồng bị tiểu đường, còn người vợ thì bị bệnh gì ta?","Bệnh chân tay","Bệnh tim","Bệnh sâu răng","Đău dạ dày","Bệnh sâu răng","Múc kẹo nhiều nên bị sâu răng chứ gì :v ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Tha thu là gì?","Tha thứ","Mình thích thì mình vẻ thôi","Tùng Sơn","Thả thính","Mình thích thì mình vẻ thôi","Mình thích thì mình hỏi thôi","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Đánh trẻ em là cái gì?","Bảo mẫu phương anh","Đi tù","Bàn chải","Ác độc","Bàn chải","Câu này đơn giản vãi","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Tay cầm cục thịt nắn nắn, tay vổ vổ là đang làm gì?","Cho con bú","Nhào thịt","Nướng thịt","Đáu vật","Cho con bú","Hãy tưởng tượng theo cách của bạn","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Có một đàn cò trắng bay qua một cánh đồng, hỏi có mấy con cò đen?","Con bé nhất","Chẳng có con nào đen","Con đầu đàn","Con cuối cùng","Chẳng có con nào đen","Đàn cò trắng mà :v ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Con cua đỏ dài 10cm chạy đua với con cua xanh dài 15 cm. Con nào về đích trước ?","Cua đỏ","Cua xanh","Không quan tâm","2 con về bằng nhau","Cua đỏ là cua chết mà :V ","Mình thích thì mình hỏi thôi","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Người gì đi bằng 3 chân?","Người sói","Người máy","Người dơi","Người già","Người già","Thêm cây gậy nữa là 3 chân rồi","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Đố toàn thể anh chị em, đêm tân hôn 2 vợ chồng làm gì?","Động phòng","Chơi game","Đếm tiền","Đi ngủ","Đếm tiền","Hehe, làm gì thì chút làm nha, đến tiền trước đã","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("12h đêm chúng ta thường làm gì?","Thẩm...","Đi du học nhật bản","Đi ngủ","Thả thính","Đi ngủ","Đúng rồi đó bác ơi","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Cây nến đốt càng nhiều càng ngắn, vậy cây gì đốt càng nhiều càng dài?","Cây tre","Không có cây đó","Cây nhang","Cây chuối","Cây tre","Suy nghĩ tại sao mình đúng đi ","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Tại sao có phụ nữ mà không có phụ nam?","Câu này đúng quá cho qua","Vì nghe phụ nam không hay","Vì nữ chỉ là phụ","Vì con trai là chính","Vì nữ chỉ là phụ","Theo mình là thế á","Chán chú quá đi",R.drawable.anhmenu01));
        data.add(new CauHoi("Tam giác có 3 góc = nhau gọi là gì?","Tam giác cân","Tam giác thường","Tam giác vuông","Tam giác đều","Tâm giác đều","Đã có ai nói với bạn là bạn rất không chưa :v ","Chán chú quá đi",R.drawable.anhmenu01));
      //  data.add(new CauHoi("Tại sao có phụ nữ mà không có phụ nam?","Câu này đúng quá cho qua","Vì nghe phụ nam không hay","Vì nữ chỉ là phụ","Vì con trai là chính","Vì nữ chỉ là phụ","Theo mình là thế á","Chán chú quá đi",R.drawable.anhmenu01));




    }
    public void setControl() {
        CauHoi = (TextView) findViewById(R.id.cauhoi);
        cautl01 = (Button) findViewById(R.id.traloi01);
        cautl02 = (Button) findViewById(R.id.traloi02);
        cautl03 = (Button) findViewById(R.id.traloi03);
        cautl04 = (Button) findViewById(R.id.traloi04);
        imggame = (ImageView) findViewById(R.id.imggame);
        tv = (TextView) findViewById(R.id.tv);
        txtSC = (TextView) findViewById(R.id.txtSC);
    }
    private void setEvent() {

        a = 0 + (int) (Math.random() * ((data.size() - 1 ) + 1));
        b = 0 + (int) (Math.random() * ((3 - 0) + 1));
        switch (a){

            case 0:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;

            case 1:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 2:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 3:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 4:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 5:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 6:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 7:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 8:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 9:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 10:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 11:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 12:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 13:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 14:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 15:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 16:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 17:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 18:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 19:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 20:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 21:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 22:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 23:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 24:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 25:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 26:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 27:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 28:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 29:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 30:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 31:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 34:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 35:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 36:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 37:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 38:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;
            case 39:
                CauHoi.setText(data.get(a).getCauHoi());
                imggame.setImageResource(data.get(a).getAnhCauHoi());
                break;

        }

        switch (b){
            case 0:
                cautl01.setText(data.get(a).getCauTL1());
                cautl02.setText(data.get(a).getCauTL2());
                cautl03.setText(data.get(a).getCauTL3());
                cautl04.setText(data.get(a).getCauTL4());

                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl01.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                    }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
            case 1:
                cautl01.setText(data.get(a).getCauTL2());
                cautl02.setText(data.get(a).getCauTL1());
                cautl03.setText(data.get(a).getCauTL3());
                cautl04.setText(data.get(a).getCauTL4());
                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl01.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                    }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
            case 2:
                cautl01.setText(data.get(a).getCauTL3());
                cautl02.setText(data.get(a).getCauTL2());
                cautl03.setText(data.get(a).getCauTL1());
                cautl04.setText(data.get(a).getCauTL4());
                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl01.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                 }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
            case 3:
                cautl01.setText(data.get(a).getCauTL4());
                cautl02.setText(data.get(a).getCauTL2());
                cautl03.setText(data.get(a).getCauTL3());
                cautl04.setText(data.get(a).getCauTL1());
                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
        }
    }

}
