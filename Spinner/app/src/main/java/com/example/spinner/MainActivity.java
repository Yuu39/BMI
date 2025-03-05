package com.example.spinner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView tvShow;
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
        spinner = findViewById(R.id.spinner);
        tvShow = findViewById(R.id.tvShow);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,R.array.Balls,android.R.layout.simple_spinner_item
        );
        //設定顯示格式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //設定spinner的資料來源與格式
        spinner.setAdapter(arrayAdapter);
        //預設選項
        spinner.setSelection(0,false);

        spinner.setOnItemSelectedListener(new spinnerOnItemClickListener());

    }


    private class spinnerOnItemClickListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String str = parent.getSelectedItem().toString();
            tvShow.setText("您選擇的運動為:" + str);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}