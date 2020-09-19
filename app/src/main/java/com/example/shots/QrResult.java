package com.example.shots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QrResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView res;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_result);
        res = (TextView) findViewById(R.id.qr_text);

        //for getting result of qr code from Qrcode.java
        Intent intent = getIntent();
        final String value = intent.getStringExtra("qr_data");
        res.setText(value);
        saveToLocalDatabase(value);
    }

    public void saveToLocalDatabase(String QR){
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        dbHelper.saveToLocalDatabase_QR(QR,database);
        dbHelper.close();
    }

    //for back button press at action bar
    public void click_back(View v) {
        Intent intent = new Intent(QrResult.this, Qrcode.class);
        startActivity(intent);
    }
    public void click_qrcode_history(View v) {
        Intent intent = new Intent(QrResult.this, QrHistory.class);
        startActivity(intent);
    }
}