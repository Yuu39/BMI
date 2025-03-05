package com.example.mutilbotton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private Button button4, button5, button6;
    private ImageView imageView;
    private TextView tvPicView;


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
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        imageView = findViewById(R.id.imageView3);
        tvPicView = findViewById(R.id.tvPicView);
        tvPicView.setText("");
        button4.setOnClickListener(new bt_picOnClickListener());
        button5.setOnClickListener(new bt_picOnClickListener());
        button6.setOnClickListener(new bt_picOnClickListener());


    }

    private class bt_picOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //           Log.d("msg_show","button");
            //           int id = v.getId();
            //           Log.d("msg_show","id="+id);
            //               Log.d("msg_show","button4");
            if (v.getId() == R.id.button4) {
                imageView.setImageResource(R.drawable.img1);
                tvPicView.setText("This is picture1");
            } else if (v.getId() == R.id.button5) {
                //               Log.d("msg_show","button5");
                imageView.setImageResource(R.drawable.img2);
                tvPicView.setText("This is picture2");
            } else if (v.getId() == R.id.button6) {
                //               Log.d("msg_show","button6");
                imageView.setImageResource(R.drawable.img3);
                tvPicView.setText("This is picture3");
            }

        }
    }
}
