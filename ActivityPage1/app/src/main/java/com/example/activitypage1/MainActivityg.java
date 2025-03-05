package com.example.activitypage1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityg extends AppCompatActivity {
    private Button page1Button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_activityg);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.page1Main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        page1Button = findViewById(R.id.page1Button);
        page1Button.setOnClickListener(new page1ButtonsetOnClickListener());

    }

    private class page1ButtonsetOnClickListener implements View.OnClickListener {
        Intent intent = new Intent();

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            Log.d("msg_show","button");
            if (v.getId()==R.id.button) {
                Log.d("msg_show", "button1");
                intent.setClass(MainActivityg.this,MainActivity.class);
                startActivity(intent);

            }
        }
    }
}


