package com.example.baitapktragk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText txt_ma, txt_ten, txt_diem;
    private Button btn_xn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        addView();
        btn_xn.setOnClickListener(v->{
            Intent intent = new Intent( MainActivity.this, ThongTinActivity.class);
            startActivity(intent);
        });
    }

    private void addView() {
        txt_ten = (EditText) findViewById(R.id.txt_ten);
        txt_diem = (EditText) findViewById(R.id.txt_diem);
        txt_ma = (EditText) findViewById(R.id.txt_ma);
        btn_xn = (Button) findViewById(R.id.btn_xn);
    }
}