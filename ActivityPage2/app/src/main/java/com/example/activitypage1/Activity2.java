package com.example.activitypage1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    private Button page2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pageMain2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        page2Button = findViewById(R.id.page2Button);
        page2Button.setOnClickListener(new page2ButtonsetOnClickListener());

        Toolbar toolbar= findViewById(R.id.page2toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//顯示toolbar
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);//back button以圖片取代



    }

    private class page2ButtonsetOnClickListener implements View.OnClickListener {
        Intent intent = new Intent();

        @Override

        public void onClick(View v) {
            Log.d("msg_show", "button");

                Log.d("msg_show", "button1");
                intent.setClass(Activity2.this, MainActivity.class);
                startActivity(intent);


        }
    }
}