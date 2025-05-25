package com.example.docbaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        webView = findViewById(R.id.webtintuc);

        // Lấy dữ liệu từ Intent
        Intent intent = getIntent();
        String link = intent.getStringExtra("linkTinTuc");

        if (link != null && !link.isEmpty()) {
            // Bật JavaScript nếu cần (nhiều trang báo cần)
            webView.getSettings().setJavaScriptEnabled(true);

            // Giữ người dùng trong ứng dụng khi bấm link trong trang
            webView.setWebViewClient(new WebViewClient());

            // Load URL
            webView.loadUrl(link);
        } else {
            Toast.makeText(this, "Link không hợp lệ", Toast.LENGTH_SHORT).show();
            finish(); // Thoát activity nếu không có link
        }
    }

    // Bắt nút quay lại trong WebView (nếu có thể)
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
