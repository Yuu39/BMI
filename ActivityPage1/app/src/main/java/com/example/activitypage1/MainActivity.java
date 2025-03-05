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

public class MainActivity extends AppCompatActivity {
    private Button button,button2;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
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
        button = findViewById(R.id.button);
        button2 =findViewById(R.id.button2);
        button.setOnClickListener(new buttonsetOnClickListener());
        button2.setOnClickListener(new buttonsetOnClickListener());

    }

    private class buttonsetOnClickListener implements View.OnClickListener {
       Intent intent = new Intent();

       @Override
        public void onClick(View v) {
            Log.d("msg_show","button");
            if (v.getId()==R.id.button) {
                Log.d("msg_show", "button1");
                intent.setClass(MainActivity.this,MainActivityg.class);
                startActivity(intent);

            }else if (v.getId()==R.id.button2){
                Log.d("msg_show", "button2");
                intent.setClass(MainActivity.this,Activity2.class);
                startActivity(intent);






            }
        }
    }
}