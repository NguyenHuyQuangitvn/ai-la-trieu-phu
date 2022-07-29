package com.example.ailatrieuphu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ailatrieuphu.adapter.TienThuongAdapter;
import com.example.ailatrieuphu.object.CauHoi;
import com.example.ailatrieuphu.object.FakeData;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer mediaPlayer;
    ListView lvTienThuong;
    TienThuongAdapter tienThuongAdapter;
    ArrayList<String> arrTienThuong;
    CauHoi cauHoi;
    int viTriCauHoi = 1;
    TextView txtQuestion, txvCauHoi, txvCauTraLoi1, txvCauTraLoi2, txvCauTraLoi3, txvCauTraLoi4;
    ArrayList<TextView> arrTxvCauTraLoi;
    FakeData fakeData;
    ArrayList<CauHoi> cauHoiArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //playSound();
        init();
        anhXa();
        setUp();
        //setClick();

    }
    // hàm kiểm tra dáp án
    public void checkCauTraLoi(TextView txv){
         String cauTraLoi = txv.getText().toString();
         // nếu  trả lời đúng
        if (cauTraLoi.equals(cauHoi.getDapAnDung())){
            mediaPlayer = MediaPlayer.create(MainActivity2.this,R.raw.dap_an_dung);
            mediaPlayer.start();
            txv.setBackgroundResource(R.drawable.bg_cau_dung);// đổi màu xanh
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    viTriCauHoi ++;
                    if (viTriCauHoi > 15){
                        viTriCauHoi = 1;
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                        builder.setTitle("Xin Chúc Mừng Bạn Đã Trở Thành Triệu Phú");
                        builder.setIcon(R.mipmap.ic_launcher_round);
                        builder.setMessage("Bạn Có Muốn Chơi Lại Không ?");
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                txtQuestion.setText("Question "+viTriCauHoi);
                                hienCauHoi();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                gameOver();
                            }
                        });
                        builder.show();
                    }
                    txtQuestion.setText("Question "+viTriCauHoi);
                    hienCauHoi();
                }
            },3000);


        }else {
            // trả lời sai
            txv.setBackgroundResource(R.drawable.bg_cau_sai);// đổi backgroud màu đỏ
            mediaPlayer = MediaPlayer.create(MainActivity2.this,R.raw.am_thanh_tra_loi_sai);
            mediaPlayer.start();
            hienThiDapAnDung(cauHoi);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                    builder.setTitle("Bạn Đã Thua Cuộc !");
                    builder.setIcon(R.mipmap.ic_launcher_round);
                    builder.setMessage("Bạn Có Muốn Chơi Lại Không ?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            viTriCauHoi = 1;
                            txtQuestion.setText("Question "+viTriCauHoi);
                            hienCauHoi();
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            gameOver();
                        }
                    });
                    builder.show();
                }
            },1000);
        }
    }
    private void setUp() {
        hienCauHoi();
        lvTienThuong.setAdapter(tienThuongAdapter);
    }

    private void anhXa() {
        lvTienThuong = findViewById(R.id.lvTienThuong);
        txvCauHoi = findViewById(R.id.txvCauHoi);
        txvCauTraLoi1 = findViewById(R.id.txvCauTraLoi1);
        txvCauTraLoi2 = findViewById(R.id.txvCauTraLoi2);
        txvCauTraLoi3 = findViewById(R.id.txvCauTraLoi3);
        txvCauTraLoi4 = findViewById(R.id.txvCauTraLoi4);
        txtQuestion = findViewById(R.id.txtQuestion);

        arrTxvCauTraLoi.add(txvCauTraLoi1);
        arrTxvCauTraLoi.add(txvCauTraLoi2);
        arrTxvCauTraLoi.add(txvCauTraLoi3);
        arrTxvCauTraLoi.add(txvCauTraLoi4);

    }
//ham khoi tao
    public void init(){
        arrTienThuong = new ArrayList<>();

        arrTienThuong.add("1.000.000");
        arrTienThuong.add("500.000");
        arrTienThuong.add("250.000");
        arrTienThuong.add("125.000");
        arrTienThuong.add("64.000");
        arrTienThuong.add("32.000");
        arrTienThuong.add("16.000");
        arrTienThuong.add("8.000");
        arrTienThuong.add("4.000");
        arrTienThuong.add("2.000");
        arrTienThuong.add("1.000");
        arrTienThuong.add("500");
        arrTienThuong.add("300");
        arrTienThuong.add("200");
        arrTienThuong.add("100");

        tienThuongAdapter = new TienThuongAdapter(this, 0, arrTienThuong);
        // khoi tao cau hoi
        cauHoi = new CauHoi();
        // khoi tao data
        fakeData = new FakeData();

        arrTxvCauTraLoi = new ArrayList<>();
    }
    // ham tao noi dung
    public void setCauHoi(){
        fakeData.addDataCauHoi();
        cauHoi = fakeData.taoCauHoi(viTriCauHoi);

//        cauHoi.setNoiDung("ai xinh nhat ?" +viTriCauHoi);
//        cauHoi.setDapAnDung("ngoc trinh"+viTriCauHoi);
//        ArrayList<String> arrDapAnSai = new ArrayList<>();
//        arrDapAnSai.add("ngoc tre");
//        arrDapAnSai.add("ngoc ");
//        arrDapAnSai.add("chinh");
//        cauHoi.setArrDapAnSai(arrDapAnSai);
    }
    // ham hien thi
    public void hienCauHoi(){
        setCauHoi();
        txvCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());//khởi tạo các câu tl chứa các đáp án sai
        arrCauTraLoi.add(cauHoi.getDapAnDung());// thêm đáp án dúng

        // đảo vị trí của câu trả lời
        Random random = new Random();
        for (int i = 1; i < 5; i++){
            int viTri1 = random.nextInt(arrCauTraLoi.size());
            int viTri2 = random.nextInt(arrCauTraLoi.size());
            String a = arrCauTraLoi.get(viTri1);// biến trung gian để đảo( a = 1 )
            arrCauTraLoi.set(viTri1,arrCauTraLoi.get(viTri2)); //(1 = 2)
            arrCauTraLoi.set(viTri2,a);                         //(2 = a)
        }
        for (int i = 0; i < arrTxvCauTraLoi.size(); i++) {
            arrTxvCauTraLoi.get(i).setOnClickListener(this);
            arrTxvCauTraLoi.get(i).setVisibility(View.VISIBLE);// trả lại đáp án sau khi dùng trợ giúp 5050 ẩn đi
            arrTxvCauTraLoi.get(i).setBackgroundResource(R.drawable.bg_btn);// set bg cho cau tra loi
            arrTxvCauTraLoi.get(i).setText(arrCauTraLoi.get(i)); //set text cau tra loi
        }
        // set vị trí câu đang chơi sang bên cột tiền thưởng
        tienThuongAdapter.setViTriCauHoi(viTriCauHoi);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txvCauTraLoi1:
                // đổi backgroud khi click vào thành màu vàng
                txvCauTraLoi1.setBackgroundResource(R.drawable.bg_cau_chon);
                // phát đoạn nhạc lên
                mediaPlayer = MediaPlayer.create(this,R.raw.chon_a);
                mediaPlayer.start();
                // delay để đợi hết nhạc mới check
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkCauTraLoi(((TextView)view));
                    }
                },3500);
                break;
            case R.id.txvCauTraLoi2:
                txvCauTraLoi2.setBackgroundResource(R.drawable.bg_cau_chon);
                mediaPlayer = MediaPlayer.create(this,R.raw.chon_b);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkCauTraLoi(((TextView)view));
                    }
                },3500);
                break;
            case R.id.txvCauTraLoi3:
                txvCauTraLoi3.setBackgroundResource(R.drawable.bg_cau_chon);
                mediaPlayer = MediaPlayer.create(this,R.raw.chon_c);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkCauTraLoi(((TextView)view));
                    }
                },3500);
                break;
            case R.id.txvCauTraLoi4:
                txvCauTraLoi4.setBackgroundResource(R.drawable.bg_cau_chon);
                mediaPlayer = MediaPlayer.create(this,R.raw.chon_d);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkCauTraLoi(((TextView)view));
                    }
                },3500);
                break;
        }
    }
//    private void setClick() {
//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                view.setBackgroundResource(R.drawable.bg_cau_chon);
//
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        checkCauTraLoi(((TextView)view));// ép kiểu view về textview để checkCauTraloi xử lí
//                    }
//                },2000);// delay 2 giây
//            }
//        };
//        txvCauTraLoi1.setOnClickListener(onClickListener);
//        txvCauTraLoi2.setOnClickListener(onClickListener);
//        txvCauTraLoi3.setOnClickListener(onClickListener);
//        txvCauTraLoi4.setOnClickListener(onClickListener);
//    }
    private void gameOver() {
        mediaPlayer = MediaPlayer.create(this,R.raw.lose);
        mediaPlayer.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBackPressed();//hàm đóng ứng dụng
            }
        },4000);
    }
    private void hienThiDapAnDung(CauHoi cauHoi) {
        if (arrTxvCauTraLoi.get(0).getText().equals(cauHoi.getDapAnDung())) {
            txvCauTraLoi1.setBackgroundResource(R.drawable.bg_cau_dung);// đổi màu xanh
        }else if (arrTxvCauTraLoi.get(1).getText().equals(cauHoi.getDapAnDung())){
            txvCauTraLoi2.setBackgroundResource(R.drawable.bg_cau_dung);// đổi màu xanh
        }else if (arrTxvCauTraLoi.get(2).getText().equals(cauHoi.getDapAnDung())){
            txvCauTraLoi3.setBackgroundResource(R.drawable.bg_cau_dung);// đổi màu xanh
        }else if (arrTxvCauTraLoi.get(3).getText().equals(cauHoi.getDapAnDung())){
            txvCauTraLoi4.setBackgroundResource(R.drawable.bg_cau_dung);// đổi màu xanh
        }
    }
    boolean tg5050 = true;
    public void TroGiup5050(View view) {
        if (tg5050 == false){
            Toast.makeText(getApplicationContext(), "Bạn đã sử dụng quyền trợ giúp", Toast.LENGTH_LONG).show();
            return;
        }else {
            cauHoi.getArrDapAnSai();
            Random r= new Random();
            int soDapAnAn = 2;
            do {
                int viTriDapAnAn = r.nextInt(4);// 1
                TextView textView = arrTxvCauTraLoi.get(viTriDapAnAn);
                if(textView.getVisibility() == View.VISIBLE && textView.getText().toString().equals(cauHoi.getDapAnDung())==false){
                    textView.setVisibility(View.INVISIBLE);// ẩn đáp án sai
                    textView.setOnClickListener(null);
                    soDapAnAn --;
                }
            }while(soDapAnAn > 0);
            tg5050 = false;
        }
    }
    boolean troGiupKhanGia = true;
    public void TroGiupKhanGia(View view) {
        if (troGiupKhanGia == false){
            Toast.makeText(getApplicationContext(), "Bạn đã sử dụng quyền trợ giúp", Toast.LENGTH_LONG).show();
            return;
        }
        for (int i=0;i<arrTxvCauTraLoi.size();i++){
            TextView t = arrTxvCauTraLoi.get(i);
            if(t.getText().toString().equals(cauHoi.getDapAnDung())){
                new DialogKhanGiaTraLoi(this,i+1).show();
                break;
            }
        }
        troGiupKhanGia =false;
    }
    boolean troGiupDoiCauHoi = true;
    public void TroGiupDoiCauHoi(View view) {
        if(troGiupDoiCauHoi == false){
            Toast.makeText(getApplicationContext(), "Bạn đã sử dụng quyền trợ giúp", Toast.LENGTH_LONG).show();
            return;
        }
        hienCauHoi();
        troGiupDoiCauHoi = false;
    }
    boolean troGiupGoidienThoai = true;
    public void GoidienThoai(View view) {
        if(troGiupGoidienThoai == false){
            Toast.makeText(getApplicationContext(), "Bạn đã sử dụng quyền trợ giúp", Toast.LENGTH_LONG).show();
            return;
        }
        //DialogGoidienThoai.setTrueAnswer(cauHoiArrayList.get(viTriCauHoi).getDapAnDung());
        new DialogGoidienThoai(this).show();
        troGiupGoidienThoai = false;
    }
}