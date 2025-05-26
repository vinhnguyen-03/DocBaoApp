package com.example.docbaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private HandlerThread handlerThread;
    private Handler backgroundHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Tạo HandlerThread
        handlerThread = new HandlerThread("SplashDelayThread");
        handlerThread.start();
        backgroundHandler = new Handler(handlerThread.getLooper());

        // Delay 2s rồi chạy trên UI Thread
        backgroundHandler.postDelayed(() -> {
            runOnUiThread(() -> {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            });
        }, 2000); // giảm xuống 2s
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }
}