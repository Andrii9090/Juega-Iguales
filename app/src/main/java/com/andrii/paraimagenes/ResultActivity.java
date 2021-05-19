package com.andrii.paraimagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textResult;
    Button btnExit, btnRestart;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textResult = findViewById(R.id.result_text);
        Intent i = getIntent();
        if(i.getIntExtra(PlayActivity.RES_KEY, 0)==8){
            textResult.setText(getString(R.string.text_win));
        }

        btnExit = findViewById(R.id.result_btn_exit);
        btnRestart = findViewById(R.id.result_btn_restart);

        btnExit.setOnClickListener(clickListener);
        btnRestart.setOnClickListener(clickListener);
    }
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.result_btn_exit:
                        finishAffinity();
                        break;
                    case R.id.result_btn_restart:
                        Intent i = new Intent(ResultActivity.this, PlayActivity.class);
                        startActivity(i);
                        break;
                }
            }
        };
}