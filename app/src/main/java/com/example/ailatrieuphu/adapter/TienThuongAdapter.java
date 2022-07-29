package com.example.ailatrieuphu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ailatrieuphu.R;

import java.util.ArrayList;
import java.util.List;

public class TienThuongAdapter extends ArrayAdapter<String> {
    Context mct;
    ArrayList<String> arr;
    int viTriCauHoi = 1;

    public TienThuongAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.mct = context;
        this.arr = new ArrayList<>(objects);
    }

    public void setViTriCauHoi(int viTriCauHoi) {
        this.viTriCauHoi = viTriCauHoi;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_tien_thuong, null);
        }
        if (arr.size() > 0) {
            int viTri = 15 - position ;
            TextView txvTienThuong = convertView.findViewById(R.id.txvTienThuong);
            if (viTri  % 5 == 0) {
                txvTienThuong.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                txvTienThuong.setTextColor(Color.parseColor("#FF9800"));
            }
            String khoangTrang;
            if (viTri / 10 > 0){
                khoangTrang = "     ";//5
            }else{
                khoangTrang = "      ";//6
            }
            String textHienThi = viTri + khoangTrang + "$" + arr.get(position);
            txvTienThuong.setText(textHienThi);

            // nếu pos = vi trí cau hỏi thi set backgroup, textColor cho item
            if (viTri == viTriCauHoi){
                txvTienThuong.setBackgroundColor(Color.parseColor("#FF9800"));
                txvTienThuong.setTextColor(Color.parseColor("#F11707"));
            }else {
                txvTienThuong.setBackgroundColor(Color.parseColor("#00FF9800"));

            }
        }
        return convertView;
    }
}
