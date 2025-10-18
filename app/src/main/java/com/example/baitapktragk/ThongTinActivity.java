package com.example.baitapktragk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThongTinActivity extends AppCompatActivity {
    private TextView txt_ma, txt_ten, txt_diem, txt_xl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thong_tin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addView();
    }
    private void addView() {
        txt_ten = (TextView) findViewById(R.id.txt_tt_ten);
        txt_diem = (TextView) findViewById(R.id.txt_tt_diem);
        txt_ma = (TextView) findViewById(R.id.txt_tt_ma);
        txt_xl = (TextView) findViewById(R.id.txt_tt_xl);
        Intent intent = getIntent();
        txt_ma.setText("Mã sv: "+intent.getStringExtra("ma"));
        txt_ten.setText("Tên sv: "+intent.getStringExtra("ten"));
        txt_diem.setText("Điểm: "+intent.getStringExtra("diem"));
        float x = Float.parseFloat(intent.getStringExtra("diem"));
        if(x<=10 && x>=8)
            txt_xl.setText("Xếp loại: Giỏi");
        else if (x<8&&x>=6.5) {
            txt_xl.setText("Xếp loại: Khá");
        } else if (x<6.5 && x>=4.5) {
            txt_xl.setText("Xếp loại: Trung bình");
        } else if (x>=0 && x<4.5) {
            txt_xl.setText("Xếp loại: Yếu");

        }
        else
            txt_xl.setText("Điểm không hợp lệ");
    }
}