package com.ifsc.contaclique;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    String [] nomes = new String[] {"Larissa", "Felipe", "Willian"};

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Recuperar ListView
        lv = findViewById(R.id.listView);

        //Adaptador
        ArrayAdapter<String> a = new ArrayAdapter(
                this,
               R.layout.item_lista,
               R.id.textView,nomes);

        lv.setAdapter(a);
    }
}