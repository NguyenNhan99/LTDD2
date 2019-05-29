package tdc.edu.vn.test;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView tenBaiHat, txtTimeDau, txtTimeCuoi, txtl;
    ArrayList<Song> arrayList;
    private MediaPlayer mediaPlayer;
    int position = 0;
    ImageButton play, prev, next;
    ImageView hinh;
    boolean isPlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        khoiTao();
        setEvent();


    }

    private void khoiTao(){
        arrayList = new ArrayList<>();
        arrayList.add(new Song(" Bức tranh từ nước mắt"," (Trong tình yêu, thuộc về ai không quan trọng \n" +
                "Một giây mơ màng là đã mất nhau...) \n" +
                "\n" +
                "Chuyện hai chúng ta bây giờ khác rồi \n" +
                "Thật lòng anh không muốn ai phải bối rối \n" +
                "Sợ em nhìn thấy nên anh đành phải lẳng lặng đứng xa \n" +
                "Chuyện tình thay đổi nên bây giờ trở thành-người-thứ-ba \n" +
                "Trách ai bây giờ... trách mình thôi... \n" +
                "\n" +
                "(Càng nghĩ đến em, anh càng ân hận \n" +
                "Vì xa em nên mất em thật ngu ngốc \n" +
                "Giờ tình anh như bức tranh tô bằng nước mắt không màu sắc \n" +
                "Nhẹ nhàng và trong suốt cho dù đau đớn vẫn lặng yên \n" +
                "Trách ai bây giờ, trách mình thôi...) \n" +
                "\n" +
                "Chorus: \n" +
                "\n" +
                "Nhìn em hạnh phúc bên ai càng làm anh tan nát lòng \n" +
                "Mới hiểu tại sao tình yêu người ta sợ-khi-cách-xa \n" +
                "Điều anh lo nhất cứ-vẫn-luôn-xảy-ra \n" +
                "Nếu không đổi thay chẳng có ai sống được vì thiếu-mất-yêu-thương \n" +
                "\n" +
                "Thời gian giết chết cuộc tình còn đau-hơn-giết-chính-mình \n" +
                "Tại sao mọi thứ xung quanh vẫn thế chỉ-lòng-người-thay-đổi \n" +
                "Giờ em chỉ là tất cả quá khứ anh phải cố xoá trong nước mắt \n" +
                "\n" +
                "(Nụ cười em vẫn như xưa mà lòng em sao khác rồi \n" +
                "Nỗi đau này chỉ mình anh nhận lấy vì anh đã sai \n" +
                "Giờ anh phải cố giữ nước mắt đừng rơi \n" +
                "Đến bao giờ quên được hết điều xảy ra giữa chúng ta ...)", R.drawable.b1, R.raw.b1));
        arrayList.add(new Song("Lắng nghe nước măt", "Buổi sáng hôm ấy thấy em chợt khóc \n" +
                "Rồi vội vàng lau thật nhanh nước mắt \n" +
                "Vẫn biết ta đã sai khi gặp nhau \n" +
                "Vì em...đã có...người yêu \n" +
                "Goodbye...I'm fine...xin đừng bận tâm \n" +
                "Đừng buồn vì những gì ta đã có \n" +
                "Anh biết sẽ vẫn quan tâm nhiều lắm \n" +
                "Dù anh...chẳng...là ai \n" +
                "(Em có thể dối anh trong lời nói \n" +
                "Nhưng làm sao giấu được trong ánh mắt \n" +
                "Tình yêu thì không có sai hoặc đúng \n" +
                "Chỉ cần trái tim rung động) \n" +
                "Chorus: \n" +
                "Nghẹn ngào giây phút ta chấp nhận sống không cần nhau \n" +
                "Chẳng khác chi Trái Đất này làm sao tồn tại không có mặt Trời \n" +
                "Chỉ biết lặng nhìn em quay lưng bước đi ... lòng anh thắt lại \n" +
                "Nghĩ đến mình sẽ không gặp lại... \n" +
                "Tình yêu đâu phải ai cũng may mắn tìm được nhau \n" +
                "Chẳng giống như chúng ta tìm được nhau rồi lại hoang phí duyên Trời \n" +
                "Tại sao phải rời xa nhau mãi mãi \n" +
                "Biết đến khi nào...chúng ta... \n" +
                "Nhận ra chẳng thể quên được nhau ...",R.drawable.b4, R.raw.b3));
        arrayList.add(new Song("Càng níu giữ càng dễ mất"," Nếu có nơi tôn thờ Tình Yêu Là Tất Cả \n" +
                "Sẽ có Chốn Vô Vọng để ta buông mình \n" +
                "Sau những tổn thương mãi không thể hàn gắn \n" +
                "Lời chia tay nào chẳng ưu sầu \n" +
                "Dồn lại bao nhiêu tổn thương, tình yêu gục ngã \n" +
                "Đừng nhìn tôi và hỏi quá nhiều \n" +
                "Vì chuyện tình nào cũng tan vậy thôi... \n" +
                "Nhiều lần tôi ngỡ mình đã tìm \n" +
                "được một người say đắm yêu mình \n" +
                "Ngờ đâu quên mất điều trớ trêu: \n" +
                "\"Càng níu giữ, ta càng dễ mất\" \n" +
                "Có khi cả cuộc đời, chẳng thể nào may mắn \n" +
                "mãi bên cạnh một người... \n" +
                "Chorus: \n" +
                "Tình yêu đâu ai biết trước \n" +
                "sẽ bao lần lạc Giữa Hồ Nước Mắt? \n" +
                "Nhớ đến nỗi hao gầy, người vẫn nỡ buông tay! \n" +
                "Tình yêu mong manh nhất là khi dâng trào! \n" +
                "Xóa đi một ký ức tàn nhẫn thế nào.. \n" +
                "Từng hơi ấm lỡ trao... giờ vô nghĩa sao? \n" +
                "Tình yêu đâu ai biết đã \n" +
                "bên nhau rồi, yên ấm rồi... lạc mãi? \n" +
                "Những chiếc hôn sơ sài.. người đã.. nhớ thêm ai? \n" +
                "Càng chạy theo, tình yêu càng xa ta dần \n" +
                "Biết không thuộc về nhau càng cố gắng tìm! \n" +
                "Chỉ cần chút hy vọng... dù bao cách trở \n" +
                "Vì tôi muốn kiếm tìm... Một Người Biết Trân Trọng \n" +
                "(Giang Tấu: \n" +
                "Đừng níu giữ một người vòng tay dần lung lay... \n" +
                "Đừng chạy theo một người chẳng hề biết quay lại...) \n" +
                "Chorus cuối: \n" +
                "Tình yêu đâu phải suối mát giữa sa mạc \n" +
                "Bền lâu đến mấy cũng rẽ ngang \n" +
                "Hạnh phúc nào được mãi mãi? \n" +
                "Càng chạy theo, tình yêu càng xa ta dần \n" +
                "Biết không thuộc về nhau càng cố gắng tìm! \n" +
                "Chỉ cần chút hy vọng... dù bao cách trở \n" +
                "Vì tôi muốn kiếm tìm... Một Người Biết Trân Trọng", R.drawable.mp3, R.raw.b2));
        arrayList.add(new Song("Một bước yêu vạn dặm đau","Một thế giới hư ảo, nhưng thật ấm áp \n" +
                "Em xuất hiện khiến những băng giá đời anh bỗng dần tan đi \n" +
                "Cuộc đời anh đặt tên là Muộn Phiền \n" +
                "nên làm sao dám mơ mình may mắn được trọn vẹn cùng em \n" +
                "Ta phải xa em mặc kệ nước mắt em rơi \n" +
                "Vì những nguyên do cả đời không dám đối diện \n" +
                "\n" +
                "Chỉ còn vài gang tấc nhưng lại xa xôi \n" +
                "Tình mình tựa đôi đũa lệch đành buông trôi \n" +
                "Cầu mong em sẽ sớm quên được tất cả \n" +
                "Tìm thấy một người xứng đáng ở bên... \n" +
                "\n" +
                "Chorus: \n" +
                "Từ nay duyên kiếp bỏ lại phía sau \n" +
                "Ngày và bóng tối chẳng còn khác nhau \n" +
                "Chẳng có nơi nào yên bình được như em bên anh \n" +
                "(Tình yêu một lần lỡ bước \n" +
                "là muôn dặm trường đau thương...) \n" +
                "\n" +
                "Hạt mưa bỗng hóa thành màu nỗi đau \n" +
                "Trời như muốn khóc ngày mình mất nhau \n" +
                "Có bao nhiêu đôi ngôn tình, cớ sao lìa xa mình ta? \n" +
                "\n" +
                "(Giang tấu: \n" +
                "Là nhân duyên Trời ban cớ sao mình chẳng thể thành đôi...) \n" +
                "\n" +
                "Lời 2: \n" +
                "Tại sao quá ngu ngốc bỏ lại mảnh ghép \n" +
                "mà đối với nhau là tất cả còn mình thì vụn vỡ... \n" +
                "Thế giới thực tại ồn ào vẫn thấy cô đơn \n" +
                "Còn hai ta thì khác, chỉ nhìn thôi tim đã thấu \n" +
                "\n" +
                "Chorus cuối: \n" +
                "Từ nay ranh giới của hai chúng ta là \n" +
                "yêu nhưng không thể nào bước qua \n" +
                "Ngọn cỏ ven đường thôi mà làm sao với được mây... \n" +
                "\n" +
                "Từ sau câu giã từ êm ái kia \n" +
                "Chẳng cơn bão lớn nào bằng bão lòng.. \n" +
                "Gặp trong mơ mà cũng không dám gào lên: \"anh thương em...\"", R.drawable.b1, R.raw.b4));
        arrayList.add(new Song("Người con gái anh không thể quên","Anh sẽ đón em... \n" +
                "Trong giấc mơ của ngày xưa \n" +
                "Ước gì... Tình mình chưa tan \n" +
                "Anh không thể quên một người \n" +
                "Mà đã có quá nhiều điều để nhớ \n" +
                "Những cuộc tình về sau luôn làm tim anh đau \n" +
                "Vì anh không thể quên... \n" +
                "\n" +
                "Người con gái rất hay cười \n" +
                "Nhưng luôn chất chứa những nỗi buồn...chôn giấu \n" +
                "Là em đó em biết không \n" +
                "Niềm tin anh đã trao trọn cho em \n" +
                "Sao anh tìm được em... \n" +
                "Khi em đã hạnh phúc bên người em yêu... \n" +
                "Đã có quá nhiều điều để nhớ để yêu \n" +
                "Người con gái anh không thể nào quên là em \n" +
                "Đã có quá nhiều điều để nhớ để yêu \n" +
                "Người con gái anh không thể nào quên là em \n" +
                "\n" +
                "Nếu trên đời có phép màu, \n" +
                "Anh sẽ nguyện thời gian được quay trở về ngày được ở bên cạnh em... \n" +
                "Nếu trên đời có phép màu... \n" +
                "Nếu trên đời có phép màu... \n" +
                "\n" +
                "Em có biết không \n" +
                "Không có ai thay được em \n" +
                "Bởi vì... tình mình chia đôi \n" +
                "Anh đã mất em thật rồi \n" +
                "Mà đã có quá nhiều điều để nhớ \n" +
                "Những cuộc tình về sau, chỉ làm anh nhớ em \n" +
                "Vì anh không thể quên... \n" +
                "\n" +
                "Anh chỉ biết một điều mãi mãi... rằng em sẽ không quay lại \n" +
                "Vì anh đã làm em đau nên chúng ta mới cách xa \n" +
                "Giờ chẳng biết em ở nơi nào và có nhớ anh hay không \n" +
                "Hay em vẫn hạnh phúc bên người em yêu \n" +
                "\n" +
                "Đã có quá nhiều điều để nhớ để yêu \n" +
                "Người con gái anh không thể nào quên là em....", R.drawable.b4, R.raw.b5));
        arrayList.add(new Song("Tìm được nhau khó thế nào","Đừng khóc nếu không yêu anh em sẽ hạnh phúc Rất đau nhưng anh phải lạnh lùng Phải làm em tin rằng anh đã ko còn... như ngày xưa nữa Từ đó... dù cho bên ai cũng không hạnh phúc Nhận ra trong anh tình yêu ấy ko thể thay đổi Một ký ức đã từng rất đẹp, đã kết thúc khi em về bên ai Tìm đc nhau khó thế nào Điều gì đau lòng hơn mất em... \n" +
                "\n" +
                "Chorus: \n" +
                "Anh đã khóc cho chuyện tình ta mỗi đêm \n" +
                "Để em bước đi - Ngàn lần không thể thứ tha Mất em chỉ một lần... anh mất em mãi mãi... \n" +
                "(Lầm lỡ buông tay để rồi hối hận) \n" +
                "Thời gian chẳng thể hàn gắn... những vết thương Từng không muốn tin mà... cuối cùng cũng phải tin Nỗi cô đơn nặng nề... biết em quên anh rồi... \n" +
                "\n" +
                "Dù không thấy nhưng tim anh có thể thấu \n" +
                "Những âm thanh em đang cười vui bên ai \n" +
                "Vết thương xưa trong lòng đã sâu càng thêm sâu \n" +
                "\n" +
                "(Dù biết trước sẽ đớn đau nếu mai ta rời nhau Duyên tình quá ngắn, mình có nhau chẳng được lâu) \n" +
                "\n" +
                "------- \n" +
                "Em đã níu lấy tay anh và khóc \n" +
                "Mà anh phải nhẫn tâm không được nhìn em \n" +
                "Lời em nói khiến anh không cầm được nước mắt Dù cho núi sẽ mòn và sông sẽ cạn Lòng anh vẫn không quên được ngày xưa Anh đã hứa bên em để che chở Tại sao vẫn yêu em mà phải mất em... \n" +
                "\n" +
                "Anh đã khóc cho chuyện tình ta mỗi đêm \n" +
                "Để em bước đi - Ngàn lần không thể thứ tha Mất em chỉ một lần... anh mất em mãi mãi... \n" +
                "Thời gian chẳng thể hàn gắn... những vết thương Từng không muốn tin mà... cuối cùng cũng phải tin Nỗi cô đơn nặng nề... biết em xa anh rồi... \n" +
                "\n" +
                "Một ký ức đã từng rất đẹp, đã kết thúc khi em về bên ai... \n" +
                "Tìm được nhau khó thế nào... \n" +
                "\n" +
                "Nỗi cô đơn nặng nề... biết em xa anh mãi... \n" +
                "Từ đó thấy em trong mơ là nước mắt rơi mãi không ngừng...", R.drawable.mp3, R.raw.b6));
        arrayList.add(new Song("Yêu người không thể yêu","Anh thấy nhớ em không biết từ khi nào mà hình bóng, nụ cười ấy luôn trong tâm trí anh \n" +
                "Chỉ một lần anh lỡ nhìn vào sâu trong đôi mắt em \n" +
                "Làm cho nhịp tim anh như vội hơn \n" +
                "\n" +
                "Trái tim anh như thiếu mất một mảnh ghép khi không có em kề bên anh, chuyện trò như những đôi tình nhân \n" +
                "Và ngày đó đã đến... ngày mà chúng ta xa nhau... \n" +
                "Em nói \"anh đừng yêu thầm em\" \n" +
                "\n" +
                "Chorus: \n" +
                "\n" +
                "Tại sao anh vẫn yêu, yêu người không thể yêu là em \n" +
                "Tại sao phải quên đi tình yêu bấy lâu tìm kiếm \n" +
                "Thời gian có làm ta quên được nhau hay không hay chỉ nhớ thêm nhiều \n" +
                "Lúc ban đầu ngỡ sau này mình bên nhau mãi mãi lâu dài \n" +
                "Đến hôm nay lòng anh vẫn thấy đau hoài \n" +
                "Anh chỉ dám nhìn ngắm những bức hình của em để bớt chơi vơi \n" +
                "\n" +
                "Không Gì Quan Trọng Hơn Có Em Lyrics \n" +
                "\n" +
                "Thời gian trôi qua thật chậm... \n" +
                "Trái tim này vẫn chẳng thể nguôi ngoai mỗi khi nhớ em \n" +
                "Tình yêu đã đến quá vội vàng ấm áp vẫn chưa thể quên \n" +
                "Nhớ em vậy... làm sao anh nỡ quên kỷ niệm \n" +
                "\n" +
                "Vòng tay ấy anh không ngờ rằng hôm qua con đang ôm nhau thật chặt hôm nay đổi thay... \n" +
                "Lấy can đảm ngước nhìn theo em đi \n" +
                "Trong lòng anh càng thêm cô đơn \n" +
                "Muốn xoá hết đi mà sao cứ đêm lại mơ... \n" +
                "\n" +
                "Chorus: \n" +
                "\n" +
                "Cho dù anh có mọi thứ trong cuộc đời thì anh vẫn không gì quan trọng hơn có em \n" +
                "Vì anh biết xa em là điều đau nhất trên đời \n" +
                "\n" +
                "Những nụ hôn sâu thật sâu vẫn đang làm tim anh nhói lên tại sao càng yêu càng đau? \n" +
                "Tại sao những quan tâm bây giờ vô nghĩa với em?", R.drawable.b1, R.raw.b7));
    }

    private void setMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(position).getFile());
        tenBaiHat.setText(arrayList.get(position).getTenBH());
        hinh.setImageResource(arrayList.get(position).getHinhA());
        txtl.setText(arrayList.get(position).getLoiBH());
    }

    private void setEvent() {
        setMediaPlayer();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlay == true) {
                    final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quay);
                    hinh.startAnimation(animation);
                    play.setImageResource(R.drawable.pause);
                    isPlay = false;
                } else {
                    play.setImageResource(R.drawable.play);
                    hinh.clearAnimation();
                    isPlay = true;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.play);
                }
                else{
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.pause);
                   // stop.setImageResource(R.drawable.pause);
                    //pause.setImageResource(R.drawable.ic_pause);
                }
                setTimeTotal();
                updateTime();
            }


        });

//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer.stop();
//                mediaPlayer.release();
//                play.setImageResource(R.drawable.play);
//                stop.setImageResource(R.drawable.pause);
//                hinh.clearAnimation();
//                //imPause.setImageResource(R.drawable.ic_pause);
//                setMediaPlayer();
//                setTimeTotal();
//                updateTime();
//            }
//        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if (position > arrayList.size() - 1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }

                setMediaPlayer();
                mediaPlayer.start();
                play.setImageResource(R.drawable.play);
                mediaPlayer.pause();
                hinh.clearAnimation();
                setTimeTotal();
                updateTime();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if (position < arrayList.size() - 1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                setMediaPlayer();
                mediaPlayer.start();
                setTimeTotal();
                updateTime();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }

    public void setTimeTotal(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        txtTimeCuoi.setText(dateFormat.format(mediaPlayer.getDuration()) + "");
        seekBar.setMax(mediaPlayer.getDuration());
    }

    public void updateTime(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                txtTimeDau.setText(dateFormat.format(mediaPlayer.getCurrentPosition()) + "");
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                mediaPlayer.setOnCompletionListener((new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if (position > arrayList.size() - 1){
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }

                        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(position).getFile());
                        tenBaiHat.setText(arrayList.get(position).getTenBH());
                        mediaPlayer.start();
                        play.setImageResource(R.drawable.pause);
                        setTimeTotal();
                        updateTime();
                    }
                }));
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void setControl() {
        seekBar = (SeekBar)findViewById(R.id.sB);
        hinh = (ImageView) findViewById(R.id.hinh);
        play = (ImageButton) findViewById(R.id.play);
        prev = (ImageButton) findViewById(R.id.prev);
        next = (ImageButton) findViewById(R.id.next);
        tenBaiHat = (TextView)findViewById(R.id.tvbaihat);
        txtTimeDau = (TextView)findViewById(R.id.tvdau);
        txtTimeCuoi = (TextView)findViewById(R.id.tvcuoi);
        txtl = (TextView)findViewById(R.id.txtL);
    }

}
