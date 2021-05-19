package com.andrii.paraimagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    public static int PLAY_ELEMENTS = 16;
    private ImageView[] listImages;
    private PlayElement[] listPlay;
    private Integer[] listRes;
    private boolean isSet;
    private int counter;
    private int par;
    private boolean isDouble;
    private int lastElement;
    private Handler handler;
    private TextView playTimer;
    private int playTime;
    Animation in;
    Animation out;
    Runnable r;

    static String RES_KEY = "result";

    Button btnExit, btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        isSet = true;
        listImages = new ImageView[16];
        listRes = new Integer[8];
        listPlay = new PlayElement[16];
        isDouble = false;
        handler = new Handler();
        par = 0;
        lastElement = -1;
        playTime = 40000;

        btnRestart = findViewById(R.id.play_btn_restart);
        btnExit = findViewById(R.id.play_btn_exit);
        playTimer = findViewById(R.id.play_timer);
        playTimer.setText(String.valueOf(playTime / 1000));

        btnExit.setOnClickListener(clickListener);
        btnRestart.setOnClickListener(clickListener);

        listImages[0] = findViewById(R.id.play_image_1);
        listImages[1] = findViewById(R.id.play_image_2);
        listImages[2] = findViewById(R.id.play_image_3);
        listImages[3] = findViewById(R.id.play_image_4);
        listImages[4] = findViewById(R.id.play_image_5);
        listImages[5] = findViewById(R.id.play_image_6);
        listImages[6] = findViewById(R.id.play_image_7);
        listImages[7] = findViewById(R.id.play_image_8);
        listImages[8] = findViewById(R.id.play_image_9);
        listImages[9] = findViewById(R.id.play_image_10);
        listImages[10] = findViewById(R.id.play_image_11);
        listImages[11] = findViewById(R.id.play_image_12);
        listImages[12] = findViewById(R.id.play_image_13);
        listImages[13] = findViewById(R.id.play_image_14);
        listImages[14] = findViewById(R.id.play_image_15);
        listImages[15] = findViewById(R.id.play_image_16);

        listRes[0] = R.drawable.la0;
        listRes[1] = R.drawable.la1;
        listRes[2] = R.drawable.la2;
        listRes[3] = R.drawable.la3;
        listRes[4] = R.drawable.la4;
        listRes[5] = R.drawable.la5;
        listRes[6] = R.drawable.la6;
        listRes[7] = R.drawable.la7;
        counter = 0;
        in = AnimationUtils.loadAnimation(this, R.anim.in);
        out = AnimationUtils.loadAnimation(this, R.anim.out);

        for (int i = 0; i < listImages.length; i++) {
            listPlay[i] = new PlayElement();
            listImages[i].setOnClickListener(clickListener);
            listImages[i].setAnimation(in);
        }

        for (int i = 0; i < listImages.length; i++) {
            counter = 0;
            int randImage = getRand(8);
            int randPos = getRand(16);
            if (listPlay[i].getDrawable() == 0) {
                listPlay[i].setShow(false);
                listPlay[i].setDrawable(listRes[randImage]);
                listPlay[i].setPosition(i);
            } else {
                continue;
            }
            setImageToElement(randImage, randPos);
        }

        r = new Runnable() {
            @Override
            public void run() {
                PlayActivity.this.playTime -= 1000;
                if (PlayActivity.this.playTime < 10000) {
                    PlayActivity.this.playTimer.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
                PlayActivity.this.playTimer.setText(String.valueOf(PlayActivity.this.playTime / 1000));
                handler.postDelayed(PlayActivity.this.r, 1000);
            }
        };
        handler.postDelayed(r, 1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startResultActivity();
            }
        }, playTime);

    }

    private void startResultActivity() {
        Intent i = new Intent(PlayActivity.this, ResultActivity.class);
        i.putExtra(RES_KEY, par);
        startActivity(i);
    }

    private void setImageToElement(int randImage, int randPos) {
        counter++;
        if (listPlay[randPos].getDrawable() == 0) {
            listPlay[randPos].setDrawable(listRes[randImage]);
            listPlay[randPos].setPosition(randPos);
            listPlay[randPos].setShow(false);
        } else if (counter > 15) {
            return;
        } else {
            setImageToElement(randImage, counter);
        }
    }


    private int getRand(int max) {
        return (int) (Math.random() * max + 1) - 1;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public void onClick(View v) {
            int position = 0;
            switch (v.getId()) {
                case R.id.play_image_1:
                    position = 0;
                    break;
                case R.id.play_image_2:
                    position = 1;
                    break;
                case R.id.play_image_3:
                    position = 2;
                    break;
                case R.id.play_image_4:
                    position = 3;
                    break;
                case R.id.play_image_5:
                    position = 4;
                    break;
                case R.id.play_image_6:
                    position = 5;
                    break;
                case R.id.play_image_7:
                    position = 6;
                    break;
                case R.id.play_image_8:
                    position = 7;
                    break;
                case R.id.play_image_9:
                    position = 8;
                    break;
                case R.id.play_image_10:
                    position = 9;
                    break;
                case R.id.play_image_11:
                    position = 10;
                    break;
                case R.id.play_image_12:
                    position = 11;
                    break;
                case R.id.play_image_13:
                    position = 12;
                    break;
                case R.id.play_image_14:
                    position = 13;
                    break;
                case R.id.play_image_15:
                    position = 14;
                    break;
                case R.id.play_image_16:
                    position = 15;
                    break;
                case R.id.play_btn_exit:
                    finishAffinity();
                    break;
                case R.id.play_btn_restart:
                    startActivity(getIntent());
                    break;
            }
            listImages[position].startAnimation(out);
            listImages[position].setOnClickListener(null);
            final int finalPosition = position;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    listImages[finalPosition].startAnimation(PlayActivity.this.in);
                    listImages[finalPosition].setImageDrawable(getDrawable(listPlay[finalPosition].getDrawable()));
                }
            }, 190);
            listPlay[position].setShow(true);
            if (lastElement == -1) {
                lastElement = position;
            } else {
                isSame(lastElement, position);
            }
        }
    };

    private void isSame(final int lastElement, final int listImage) {
        if (listPlay[lastElement].getDrawable() == listPlay[listImage].getDrawable()) {
            par++;
            listImages[lastElement].setOnClickListener(null);
            listImages[listImage].setOnClickListener(null);
            this.lastElement = -1;
            if (par == 8) {
                startResultActivity();
            }
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    PlayActivity.this.listImages[lastElement].startAnimation(out);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            PlayActivity.this.listImages[lastElement].setOnClickListener(clickListener);
                            PlayActivity.this.listImages[lastElement].setImageDrawable(getDrawable(R.drawable.fondo));
                            PlayActivity.this.listImages[listImage].startAnimation(in);
                        }
                    }, 200);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            PlayActivity.this.listImages[listImage].setImageDrawable(getDrawable(R.drawable.fondo));
                            PlayActivity.this.listImages[listImage].setOnClickListener(clickListener);
                        }
                    }, 400);
                    PlayActivity.this.lastElement = -1;
                }
            }, 620);
        }
    }
}