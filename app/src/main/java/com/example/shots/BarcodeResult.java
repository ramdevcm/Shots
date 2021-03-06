package com.example.shots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BarcodeResult extends AppCompatActivity {
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_result);
        res = (TextView) findViewById(R.id.barcode_text);
       // res.setText(getIntent().getExtras().getString("barcode_data"));
        Intent intent = getIntent();
        final String value = intent.getStringExtra("barcode_data");
        res.setText(value);
        saveToLocalDatabase(value);
    }

/*
    public void addToDb() {
        String newEntry = res.getText().toString();
        if (res.length() != 0) {
            saveToLocalDatabase(newEntry);
            res.setText("");
        } else {
            toastMessage("You must put something in the text field!");
        }

    }

 */

    public void saveToLocalDatabase(String BR){
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        dbHelper.saveToLocalDatabase_BR(BR,database);
        dbHelper.close();
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //for back button press at action bar
    public void click_back(View v) {
        Intent intent = new Intent(BarcodeResult.this, Barcode.class);
        startActivity(intent);
    }

    public void click_barcode_history(View v) {
        Intent intent = new Intent(BarcodeResult.this, BarcodeHistory.class);
        startActivity(intent);
    }
}