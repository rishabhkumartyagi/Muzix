package com.maet.rishabhkumartyagi.cloudmu;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.webkit.WebChromeClient;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;

public class pagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagen);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://soundcloud.com/");
    }
}
