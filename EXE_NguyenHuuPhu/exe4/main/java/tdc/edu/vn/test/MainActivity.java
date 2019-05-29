package tdc.edu.vn.test;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView tenBaiHat, tenCaSi, txtTimeDau, txtTimeCuoi;
    private ArrayList<Music> arrayList;
    private MediaPlayer mediaPlayer;
    int position = 0;
    ImageButton play, prev, stop, next;
    ImageView hinh;
    boolean isPlay = true;
    private ListView songList;
    int i = 0;
    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        khoiTao();
        setMediaPlayer(i);

        hinh.setImageResource(R.drawable.mp3);
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    i = position;
                    play.setImageResource(R.drawable.ic_pause);
                    setMediaPlayer(position);
                    switch (position) {
                        case 0:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation);
                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation1);
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation2);
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation3);
                            break;
                        case 4:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation4);
                            break;
                        case 5:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation5 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation5);
                            break;
                    }


                    mediaPlayer.start();
                } else {
                    i = position;
                    play.setImageResource(R.drawable.ic_pause);

                    setMediaPlayer(position);
                    mediaPlayer.start();
                }


            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    play.setImageResource(R.drawable.ic_pause);
                    isPlay = true;
                } else if (i >= 0) {
                    setMediaPlayer(i);
                    mediaPlayer.start();
                    switch (i) {
                        case 0:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation);
                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation1);
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation2);
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation3);
                            break;
                        case 4:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation4);
                            break;
                        case 5:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation5 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation5);
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
                    play.setImageResource(R.drawable.ic_pause);
                    isPlay = true;
                } else if (i <= arrayList.size() - 1) {

                    setMediaPlayer(i);
                    mediaPlayer.start();
                }
                if (i > arrayList.size() - 1) {
                    i = 0;
                    setMediaPlayer(i);
                    mediaPlayer.start();
                    switch (i) {
                        case 0:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation);
                            break;
                        case 1:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation1);
                            break;
                        case 2:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation2);
                            break;
                        case 3:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation3);
                            break;
                        case 4:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation4);
                            break;
                        case 5:
                            hinh.setImageResource(R.drawable.mp3);
                            Animation animation5 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.quay);
                            hinh.setAnimation(animation5);
                            break;
                        default:
                            break;


                    }
                }
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
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlay == true) {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.ic_pause);
                    isPlay = false;
                    mediaPlayer.start();
                    hinh.setAnimation(animation);
                } else {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play);
                    isPlay = true;
                    hinh.clearAnimation();
                }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    setMediaPlayer(i);
                    play.setImageResource(R.drawable.ic_play);
                    if (mediaPlayer.isPlaying() == false) {
                        mediaPlayer.start();
                        play.setImageResource(R.drawable.ic_play);

                    }
                } else {
                    mediaPlayer.start();
                }
            }
        });


    }

    private void khoiTao() {
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Anh Nhà Ở Đâu Thế?", "AMEE, B Ray", R.raw.b1));
        arrayList.add(new Music("Anh Ơi Anh Ở Lại", "Chi Pu, Đạt G", R.raw.b2));
        arrayList.add(new Music("Bạc Phận", "Jack, K-ICM", R.raw.b3));
        arrayList.add(new Music("Đừng Yêu Nữa, Em Mệt Rồi", "MIN", R.raw.b4));
        arrayList.add(new Music("Một Bước Yêu Vạn Dặm Đau", "Mr Siro", R.raw.b5));

        adapter = new MusicAdapter(this, R.layout.custom_music_item, arrayList);
        songList.setAdapter(adapter);
    }

    private void setMediaPlayer(int i) {
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(i).getSong());
        tenBaiHat.setText(arrayList.get(i).getName());
        tenCaSi.setText(arrayList.get(i).getSinger());
        SimpleDateFormat dinhdang = new SimpleDateFormat("mm:ss");
        txtTimeCuoi.setText(dinhdang.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
        updateTimeSong();

    }


    public void setTimeTotal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        txtTimeCuoi.setText(dateFormat.format(mediaPlayer.getDuration()) + "");
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void updateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdang = new SimpleDateFormat("mm:ss");
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                txtTimeDau.setText(dinhdang.format(mediaPlayer.getCurrentPosition()));
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void setControl() {
        seekBar = (SeekBar) findViewById(R.id.sB);
        hinh = (ImageView) findViewById(R.id.hinh);
        play = (ImageButton) findViewById(R.id.play);
        prev = (ImageButton) findViewById(R.id.prev);
        stop = (ImageButton) findViewById(R.id.stop);
        next = (ImageButton) findViewById(R.id.next);
        tenBaiHat = (TextView) findViewById(R.id.tvbaihat);
        txtTimeDau = (TextView) findViewById(R.id.tvdau);
        txtTimeCuoi = (TextView) findViewById(R.id.tvcuoi);
        tenCaSi = (TextView) findViewById(R.id.tvcasi);
        songList = (ListView) findViewById(R.id.list);


    }

}
