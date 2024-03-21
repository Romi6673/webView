package com.example.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    EditText inputUrl;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        btnGo = findViewById(R.id.btnGo);
        inputUrl = findViewById(R.id.inputUrl);
        wv.setWebViewClient(new MyWebViewClient());

    }

    public void search(View view) {
        String url = inputUrl.getText().toString();
        wv.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}