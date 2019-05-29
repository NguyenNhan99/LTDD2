package com.quocnguyen.mediaplayerdemo;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Switch chang;
    int i = 0;
    ImageButton loi;
    int a = 0;
    LinearLayout s;
    boolean ready = false;
    boolean isPlaying = true;
    MediaPlayer mediaPlayer;
    ImageButton lui, play, stop, next, randrom, back;
    ImageView hinh;
    TextView timeS, timeE, ten;
    SeekBar seeB;
    private ArrayList<Music> arrayList;
    private ArrayList<String> array;
    private CustomMusicAdapter adapter;
    private ListView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setControl();
        addSong();
        khoiTaoPlay(i);
        hinh.setImageResource(R.drawable.hinhdoi);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
        hinh.setAnimation(animation);
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    i = position;
                    play.setImageResource(R.drawable.ic_stop_black_24dp);
                    khoiTaoPlay(position);
                    switch (position) {
                        case 0:
                            hinh.setImageResource(R.drawable.hinhdoi);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation);
                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.bacphan);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation1);
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.loianh);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation2);
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.lil);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation3);
                            break;
                    }


                    mediaPlayer.start();
                } else {
                    i = position;
                    play.setImageResource(R.drawable.ic_stop_black_24dp);
                    khoiTaoPlay(position);
                    mediaPlayer.start();
                }


            }
        });
        lui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    play.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                    isPlaying = true;
                } else if (i >= 0) {
                    khoiTaoPlay(i);
                    mediaPlayer.start();
                    switch (i) {
                        case 0:
                            hinh.setImageResource(R.drawable.hinhdoi);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation);
                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.bacphan);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation1);
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.loianh);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation2);
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.lil);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation3);
                            break;
                        default:
                            break;


                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Không Thể Lui", Toast.LENGTH_SHORT).show();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    play.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                    isPlaying = true;
                } else if (i <= arrayList.size() - 1) {

                    khoiTaoPlay(i);
                    mediaPlayer.start();
                }
                if (i > arrayList.size() - 1) {
                    i = 0;
                    khoiTaoPlay(i);
                    mediaPlayer.start();
                    switch (i) {
                        case 0:
                            hinh.setImageResource(R.drawable.hinhdoi);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(0);
                                }
                            });

                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.bacphan);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation1);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(1);
                                }
                            });
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.loianh);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation2);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(2);
                                }
                            });
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.lil);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation3);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(3);
                                }
                            });
                            break;
                        default:
                            break;


                    }
                }
            }
        });
        seeB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seeB.getProgress());
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying == true) {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.ic_stop_black_24dp);
                    isPlaying = false;
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                    isPlaying = true;
                }

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    khoiTaoPlay(i);
                    play.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                    if (mediaPlayer.isPlaying() == false) {
                        mediaPlayer.start();
                        play.setImageResource(R.drawable.ic_stop_black_24dp);
                    }
                } else {
                    mediaPlayer.start();
                }
            }
        });
        randrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b = arrayList.size() - 1;
                int rd = (int) (Math.random() * ((b - 0) + 1));
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    khoiTaoPlay(rd);
                    mediaPlayer.start();
                    switch (rd) {
                        case 0:
                            hinh.setImageResource(R.drawable.hinhdoi);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(0);
                                }
                            });
                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.bacphan);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation1);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(1);
                                }
                            });
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.loianh);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation2);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(2);
                                }
                            });
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.lil);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation3);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(3);
                                }
                            });
                            break;
                        default:
                            break;
                    }
                }else {
                    khoiTaoPlay(rd);
                    mediaPlayer.start();
                    switch (rd) {
                        case 0:
                            hinh.setImageResource(R.drawable.hinhdoi);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(0);
                                }
                            });
                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.bacphan);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation1);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(1);
                                }
                            });
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.loianh);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation2);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(2);
                                }
                            });
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.lil);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                            hinh.setAnimation(animation3);
                            loi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    DialogCustom(3);
                                }
                            });
                            break;
                        default:
                            break;
                    }
                }
                //Toast.makeText(getApplicationContext(), rd + "", Toast.LENGTH_SHORT ).show();

            }
        });
        chang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chang.isChecked()) {
                    s.setBackgroundResource(R.drawable.mau_avatar);
                } else {
                    s.setBackgroundResource(R.drawable.mautoi_avater);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoMain.class);
                startActivity(intent);
            }
        });
    }

    private void khoiTaoPlay(int i) {
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(i).getSong());
        ten.setText(arrayList.get(i).getName());
        SimpleDateFormat dinhdang = new SimpleDateFormat("mm:ss");
        timeE.setText(dinhdang.format(mediaPlayer.getDuration()));
        seeB.setMax(mediaPlayer.getDuration());
        updateTimeSong();
    }

    private void addSong() {
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Đời Là Thế Thôi", "Phú Lê", R.raw.dltt));
        arrayList.add(new Music("Bạc Phận", "Jack", R.raw.bacphan));
        arrayList.add(new Music("Lời anh chưa thể nói", "Hàn Khởi", R.raw.loi_anh_chua_the_noi));
        arrayList.add(new Music("Tau Thích Mi", "Lil Pig", R.raw.ttm));

        adapter = new CustomMusicAdapter(this, R.layout.custom_music_item, arrayList);
        songList.setAdapter(adapter);
    }

    public void setControl() {
        randrom = (ImageButton) findViewById(R.id.random);
        ten = (TextView) findViewById(R.id.ten);
        songList = (ListView) findViewById(R.id.songList);
        lui = (ImageButton) findViewById(R.id.lui);
        next = (ImageButton) findViewById(R.id.next);
        s = (LinearLayout) findViewById(R.id.nens);
        play = (ImageButton) findViewById(R.id.play);
        stop = (ImageButton) findViewById(R.id.stop);
        timeS = (TextView) findViewById(R.id.timestart);
        timeE = (TextView) findViewById(R.id.timeend);
        seeB = (SeekBar) findViewById(R.id.see);
        chang = (Switch) findViewById(R.id.change);
        hinh = (ImageView) findViewById(R.id.nen);
        back = (ImageButton) findViewById(R.id.back);
        loi = (ImageButton) findViewById(R.id.loi);
    }

    private void updateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdang = new SimpleDateFormat("mm:ss");
                seeB.setProgress(mediaPlayer.getCurrentPosition());
                timeS.setText(dinhdang.format(mediaPlayer.getCurrentPosition()));
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    public void DialogCustom(int position) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);

        TextView thongtin = (TextView) dialog.findViewById(R.id.xem);
        Button dongy = (Button) dialog.findViewById(R.id.dongy);

        if (position == 0){
            thongtin.setText("Khổ trước sướng sau\n" +
                    "thế mới giàu\n" +
                    "Tình nghĩa anh em\n" +
                    "có chắc bền lâu\n" +
                    "Giàu trước khổ sau\n" +
                    "thế mới đau lòng\n" +
                    "Khi sa cơ\n" +
                    "không còn ai\n" +
                    "Khi mình đã có\n" +
                    "những gì người ta cần\n" +
                    "Người ta luôn quan tâm\n" +
                    "và chia sẻ\n" +
                    "Khi mình sa cơ\n" +
                    "thất thế trên cuộc đời\n" +
                    "Người ta mang mình ra\n" +
                    "đành rẽ bán\n" +
                    "Khi gian nan\n" +
                    "mới biết ai là bạn\n" +
                    "Hỏi thế nhân ơi\n" +
                    "có mấy người\n" +
                    "cũng như tôi\n"
                    );
        }else if (position == 1){
            thongtin.setText("Ai gieo tình này, ai mang tình này, để lệ trên khóe mi cay\n" +
                    "Ai đưa về nhà, ai cho ngọc ngà, giờ người xa cách ta\n" +
                    "Từng là một thời thiếu nữ trong vùng quê nghèo\n" +
                    "Hồn nhiên cài hoa mái đầu\n" +
                    "Dòng người vội vàng em hóa thân đời bẽ bàng\n" +
                    "Rời xa tình anh năm tháng …\n" +
                    "\n" +
                    "ĐK:\n" +
                    "Ôi phút giây tương phùng anh nhớ và mong\n" +
                    "Dòng lưu bút năm xưa in dấu mãi đậm sâu\n" +
                    "Trong nỗi đau anh mệt nhoài\n" +
                    "Trong phút giây anh tìm hoài\n" +
                    "Muốn giữ em ở lại một lần này vì anh mãi thương\n" +
                    "\n" +
                    "Xa cách nhau thật rồi sương trắng chiều thu\n" +
                    "Ngày em bước ra đi nước mắt ấy biệt li\n" +
                    "Hoa vẫn rơi bên thềm nhà\n" +
                    "Lá xát xơ đi nhiều và\n" +
                    "Anh chúc em yên bình mối tình mình hẹn em kiếp sau …\n"
                    );
        }else  if (position == 2){
            thongtin.setText("Một lời anh chưa thể nói...\n" +
                    "Với em...\n" +
                    "Chúng ta quen nhau lâu rồi...\n" +
                    "Từ lần đầu tiên đôi ta gặp nhau thật sự thì anh cũng có biết đâu rằng mình sẽ đến bên nhau nhanh như vậy ư.......\n" +
                    "Nhìn đôi mắt sáng lung linh.\n" +
                    "Đã bao lần làm anh phải quên đi bản thân mình.\n" +
                    "Dù trời mưa rơi hai đứa hai nơi nhưng em vẫn mang cho anh cảm giác ấm êm và xua tan hết chơi vơi....\n" +
                    "Điệp khúc:\n" +
                    "Chờ đợi bao lâu anh không nói ra.\n" +
                    "Nghe trong lòng ôi sao xót xa.\n" +
                    "Vì sao khoảng cách đôi ta xa quá biết đâu tình yêu ta mau nhạt nhòa.\n" +
                    "Vẫn nơi đây chỉ còn mỗi anh và ngày buồn mang theo cơn gió lạnh.\n" +
                    "Bao thử thách luôn ở phía trước liệu rằng ta có vững bước vượt qua.\n" +
                    "Chỉ là vài câu yêu thương thế thôi.\n" +
                    "Bao đêm dài mi cay đắng môi.\n" );
        }else if (position == 3){
            thongtin.setText("Tau thích mi nhưng tau không hề *** nói ra \n" +
                    "có lẽ ngại có lẽ dị hoặc không có lí do gì cả \n" +
                    "tao biết tao không bằng đc người ta nên nói thích mi chỉ là 1 điều gì đó rất xa mà \n" +
                    "iu là 1 thứ quá cao khỏi tầm tay nên tao nói thích mi chắc cũng không có sao đâu nhỉ \n" +
                    "tao biết mi không cho nhưng tao thích như rứa đó \n" +
                    "tao thích ngồi ngắm ánh mắt của mi mỗi khi mi nhìn hay mi đang ngó \n" +
                    "hay mỗi lúc mi lặng thinh đi vì những điều k vui làm mi cau có \n" +
                    "tao biết tao k mong đc như thằng Baek Hyun đc Hyun Jung kêu là chồng ơi \n" +
                    "nhưng mỗi khi mi kêu tao là heo ơi heo sao tao thấy vui thế \n" +
                    "chữ heo kéo dài ra và chữ ơi nặng cả tạ \n" +
                    "với đôi mắt to tròn như căng ra \n" +
                    "khiến tao gần như gục ngã \n" +
                    "mi như trái đất khiến bao nhiu vệ tinh nhân tao bay quanh chết ngất \n" +
                    "tao như mặt trăng đứng từ xa nhìin mi với tình cảm chân thật \n" +
                    "và 1 thứ gì đó gần như đã đánh mất \n" );
        }

        dongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}

