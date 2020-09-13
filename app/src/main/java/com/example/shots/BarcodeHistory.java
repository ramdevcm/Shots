package com.example.shots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BarcodeHistory extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Custom_histoty_Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Barcodestructure> List;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_history);
        List = new ArrayList<Barcodestructure>();
        mRecyclerView = findViewById(R.id.recycler_barcode_history);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new Custom_histoty_Adapter(List,this);
        mRecyclerView.setAdapter(mAdapter);
        readFromLocalStorage();

    }
    public void click_barcode_history_back(View v) {
        Intent intent = new Intent(BarcodeHistory.this, BarcodeResult.class);
        startActivity(intent);
    }

    private void readFromLocalStorage(){
        List.clear();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database =  dbHelper.getReadableDatabase();

        cursor = dbHelper.readFromLocalDatabase_BR(database);

        while(cursor.moveToNext()){
            String BR = cursor.getString(cursor.getColumnIndex(DBConst.BRCODE));
            String DATE = cursor.getString(cursor.getColumnIndex(DBConst.DATE));
            List.add(new Barcodestructure(BR,DATE));
        }


        mAdapter.notifyDataSetChanged();
        cursor.close();
        dbHelper.close();

    }

}