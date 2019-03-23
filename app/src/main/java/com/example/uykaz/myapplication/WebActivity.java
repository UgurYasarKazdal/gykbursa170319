package com.example.uykaz.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebActivity extends Activity {
    private WebView mWebView;
    private String mUrl = "https://gelecegiyazanlar.turkcell.com.tr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mWebView = findViewById(R.id.webView_web);

     mWebView.getSettings().setJavaScriptEnabled(true);

        openWebPage();
    }

    private void openWebPage() {
        mWebView.loadUrl(mUrl);

        final ProgressDialog progressDialog = ProgressDialog.show(WebActivity.this, "türkcell", "loading...");
        progressDialog.show();

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(WebActivity.this, "Sayfa yüklendi...", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
