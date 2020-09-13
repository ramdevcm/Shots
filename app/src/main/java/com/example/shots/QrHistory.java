package com.example.shots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class QrHistory extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Custom_history_AdapterQR mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<QRstructure> List;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_history);
        List = new ArrayList<QRstructure>();
        mRecyclerView = findViewById(R.id.recycler_qrcode_history);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new Custom_history_AdapterQR(List,this);
        mRecyclerView.setAdapter(mAdapter);
        readFromLocalStorage();
    }

    private void readFromLocalStorage(){
        List.clear();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database =  dbHelper.getReadableDatabase();

        cursor = dbHelper.readFromLocalDatabase_BR(database);

        while(cursor.moveToNext()){
            String QR = cursor.getString(cursor.getColumnIndex(DBConst.QRCODE));
            String DATE = cursor.getString(cursor.getColumnIndex(DBConst.DATE));
            List.add(new QRstructure(QR,DATE));
        }


        mAdapter.notifyDataSetChanged();
        cursor.close();
        dbHelper.close();

    }

}