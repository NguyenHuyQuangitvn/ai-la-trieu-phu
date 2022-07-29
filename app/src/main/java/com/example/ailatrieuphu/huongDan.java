package com.example.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class huongDan extends AppCompatActivity {
    TextView hd1,hd2,hd3;
    Button sanSang, chuaSanSang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan);
        hd1 = findViewById(R.id.hd1);
        hd2 = findViewById(R.id.hd2);
        hd3 = findViewById(R.id.hd3);
        sanSang = findViewById(R.id.SanSang);
        chuaSanSang = findViewById(R.id.chuaSanSang);

    }

    public void Yes(View view) {
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }

    public void No(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}