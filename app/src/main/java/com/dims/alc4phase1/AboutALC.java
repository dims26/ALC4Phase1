package com.dims.alc4phase1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutALC extends AppCompatActivity {

    WebView mALCAboutPage;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        mALCAboutPage = findViewById(R.id.about_page);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebSettings = mALCAboutPage.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setBuiltInZoomControls(true);
        mWebSettings.setDisplayZoomControls(true);
        mALCAboutPage.setWebViewClient(new MyWebViewClient());
        mALCAboutPage.loadUrl("https://www.andela.com/alc/");
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(getApplicationContext(), "Oh no! " + description, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }
}
