package com.example.featurebox;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class webBrowser extends AppCompatActivity {
    EditText e1;
    Button b1;
    WebView w1;
    ImageView iv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        iv=(ImageView) findViewById(R.id.imageView);
        e1 = (EditText) findViewById(R.id.editTextText);
        b1 = (Button) findViewById(R.id.button);
        w1 = (WebView) findViewById(R.id.webview);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(webBrowser.this,Features.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                w1.getSettings().setJavaScriptEnabled(true);
                w1.loadUrl("https://www.google.com/search?q=" + s1);
            }
        });
    }
}