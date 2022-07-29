package com.example.ailatrieuphu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playSound();

    }

    public void batDau(View view) {
        stopSound(); 
        mediaPlayer = MediaPlayer.create(this,R.raw.san_sang);
        mediaPlayer.start();
        Intent i = new Intent(this,MainActivity2.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
            }
        },3500);

    }
    private void playSound() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this,R.raw.khoi_dau);
        }
        mediaPlayer.start();
        mediaPlayer.setLooping(true);// lặp lại đoạn nhạc
    }
    private void stopSound() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void Thoat(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo !");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setMessage("Bạn có chắc chắn muốn thoát game ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();//hàm đóng ứng dụng
                stopSound();
            }
        });
        builder.setNegativeButton("NO",null);
        builder.show();
    }

    public void HuongDan(View view) {
        stopSound();
        Intent i = new Intent(this,huongDan.class);
        startActivity(i);
    }

    public void GioiThieu(View view) {
        View diglogSheetView = LayoutInflater.from(MainActivity.this).inflate(R.layout.gioi_thieu,null);
        BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
        dialog.setContentView(diglogSheetView);
        //TextView txtGioiThieu = diglogSheetView.findViewById(R.id.txtGioiThieu);
        dialog.show();
    }
}