package com.example.featurebox;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Features extends AppCompatActivity {
    ImageView iv1,iv2,iv3,wifi,bluetooth,flash;
    WifiManager w1;
    BluetoothAdapter b1;
    CameraManager cm;
    int flashcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_features);
        iv1=(ImageView) findViewById(R.id.imageView3);
        iv2=(ImageView) findViewById(R.id.imageView4);
        iv3=(ImageView) findViewById(R.id.imageView5);
        wifi=(ImageView) findViewById(R.id.imageView2);
        bluetooth=(ImageView) findViewById(R.id.imageView6);
        flash=(ImageView) findViewById(R.id.imageView7);
        w1=(WifiManager)getSystemService(WIFI_SERVICE);
        b1=BluetoothAdapter.getDefaultAdapter();
        cm=(CameraManager) getSystemService(CAMERA_SERVICE);



        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Features.this,webBrowser.class);
                startActivity(i1);
                finish();

            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Features.this,VideoPlayer.class);
                startActivity(i2);
                finish();
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Features.this,MusicPlayer.class);
                startActivity(i3);
                finish();
            }
        });
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w1.isWifiEnabled()) w1.setWifiEnabled(false);
                else
                w1.setWifiEnabled(true);
            }
        });
        bluetooth.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if(b1.isEnabled()) b1.disable();
                else b1.enable();
            }
        });
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcount++;
                if(flashcount%2!=0) {

                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {

                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        }

    }
