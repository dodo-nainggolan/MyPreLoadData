package com.example.mypreloaddata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import database.MahasiswaHelper;
import model.MahasiswaModel;

public class MahasiswaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_mahasiswa );

        RecyclerView recyclerView = findViewById ( R.id.recyclerview );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        MahasiswaAdapter mahasiswaAdapter = new MahasiswaAdapter ();
        recyclerView.setAdapter ( mahasiswaAdapter );

        MahasiswaHelper mahasiswaHelper = new MahasiswaHelper ( this );
        mahasiswaHelper.open ();

        // Ambil semua data mahasiswa di database
        ArrayList<MahasiswaModel> mahasiswaModels = mahasiswaHelper.getAllData ();

        mahasiswaHelper.close ();
        mahasiswaAdapter.setData ( mahasiswaModels );
    }
}
