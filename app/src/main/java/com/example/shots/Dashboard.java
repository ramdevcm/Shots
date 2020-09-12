package com.example.shots;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
       /* if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

            String[] permission =

            }
        }

*/
    }

    public void click_document(View v) {
        Intent intent = new Intent(Dashboard.this, Document.class);
        startActivity(intent);
    }
    public void click_qr(View v) {
        Intent intent = new Intent(Dashboard.this, Qrcode.class);
        startActivity(intent);
    }
    public void click_bar(View v) {
        Intent intent = new Intent(Dashboard.this, Barcode.class);
        startActivity(intent);
    }

}

