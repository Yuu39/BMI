package com.example.entername;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btEnter;
    private EditText edName;
    private TextView tvView;
    private boolean verify;


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
        edName = findViewById(R.id.edName);
        btEnter = findViewById(R.id.btEnter);
        tvView = findViewById(R.id.textView);

        btEnter.setOnClickListener(new btEnterOnClickListener());
        verify = true;
        edName.addTextChangedListener(new edNameaddTextChangedListener());


    }


    private class btEnterOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //     Log.d("mymsg" ,"button");
            String str = edName.getText().toString().trim();
            //         Log.d("mymsg","name:"+str);
            tvView.setText(str + ",你好!");
            if (str.length() == 0) {
                tvView.setTextSize(40);
                tvView.setText("請輸入大名!");
            } else {
                if (verify) {
                    tvView.setTextSize(24);
                    tvView.setText(str + ",哈囉哇!");
                } else {
                    tvView.setTextSize(40);
                    tvView.setText("格式錯誤!");

                }
            }
        }


    }

    private class edNameaddTextChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (edName.getText().toString().trim().length() == 0) {
                tvView.setTextSize(40);
                tvView.setText("請輸入大名!");
            } else if (edName.getText().toString().trim().length() > 10) {
                edName.setError("上限為10個字元");
                verify = false;
            } else {
                verify = true;
            }

        }
    }
}
