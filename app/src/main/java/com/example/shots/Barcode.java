package com.example.shots;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class Barcode extends AppCompatActivity {
    CodeScanner CodeScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        CodeScanner = new CodeScanner(this, scannerView);

        CodeScanner.setDecodeCallback( new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), BarcodeResult.class);
                        result.getText();
                        intent.putExtra("barcode_data", String.valueOf(result));
                        startActivity(intent);
                    }
                });
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        CodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        CodeScanner.releaseResources();
        super.onPause();
    }

    //for back button press at action bar
    public void click_back(View v) {
        Intent intent = new Intent(Barcode.this, Dashboard.class);
        startActivity(intent);
    }
}

