package com.example.bm1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {


    private EditText edHeight, edWeight;
    private Button btCal;

    @SuppressLint("MissingInflatedId")
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
        //初始化
        edWeight = findViewById(R.id.edWeight);
        edHeight = findViewById(R.id.edHeight);
        btCal = findViewById(R.id.btCal);

        //button event
        btCal.setOnClickListener(new btcalOnClickListener());

//        Log.d("msg","button");
    }


    private class btcalOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
      //      Log.d("mymsg","button");
            String w = edWeight.getText().toString();//trin去除前後空格
            String h = edHeight.getText().toString();//trin去除前後空格
            Log.d("mymsg","weight"+w+"height"+h);
            float wValue = Float.parseFloat(w);
            float hValue = Float.parseFloat(h)/100;
            float bmi = wValue/(hValue*hValue);
//            Log.d("mymsg","bmi:"+bmi);
            Toast.makeText(MainActivity.this,"bmi:"+String.valueOf(bmi),Toast.LENGTH_SHORT).show();


            
        }
    }
}