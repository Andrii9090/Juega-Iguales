package com.andrii.paraimagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPlay, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExit = findViewById(R.id.main_btn_exit);
        btnPlay = findViewById(R.id.main_btn_play);

        btnExit.setOnClickListener(listener);
        btnPlay.setOnClickListener(listener);
    }

    OnClickListener listener = new OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.main_btn_exit:
                    finishAffinity();
                    break;
                case R.id.main_btn_play:
                    Intent i = new Intent(MainActivity.this, PlayActivity.class);
                    startActivity(i);
            }
        }
    };
}