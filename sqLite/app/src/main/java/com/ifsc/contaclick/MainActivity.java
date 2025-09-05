package com.ifsc.contaclick;

import android.content.ContentValues;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Button b;
    EditText edNome;

    ListView lv;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("banco2", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, txt VARCHAR)");

        b=findViewById(R.id.btnInserir);
        edNome=findViewById(R.id.edNome);
        lv=findViewById(R.id.listView);


        b.setOnClickListener(v->{
            String nota = edNome.getText().toString();
            inserirNota(nota);
            //lv.setItem;


        });


    }

    public void listagemNotas(){
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        ArrayList<String> listaNotas = new ArrayList<String>();

        while(!cursor.isAfterLast()){
            int coluna = cursor.getColumnIndex("txt");
            listaNotas.add(cursor.getString(coluna));
            cursor.moveToNext();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaNotas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //adapter = planetaDAO.getPlanetas().get(position);

                Intent intent = new Intent(getApplicationContext(), ExibeUmaNota.class);

               // intent.putExtra("planeta", p);

                startActivity(intent);
            }
        });

    }
    public void inserirNota(String txt){
        ContentValues cv = new ContentValues();
        cv.put("txt", txt);
        db.insert("notas", null, cv);
        listagemNotas();
    }
}