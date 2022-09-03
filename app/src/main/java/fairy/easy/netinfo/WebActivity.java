package fairy.easy.netinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class WebActivity extends AppCompatActivity {
    WebView webView;
    EditText address;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Intent startIntent = getIntent();
        String url=startIntent.getStringExtra("url");

        address = findViewById(R.id.urlAddress);
        address.setText(url);

        searchButton=findViewById(R.id.searchButton);

        webView = findViewById(R.id.wv);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(url);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(address.getText().toString());
            }
        });
    }


}
