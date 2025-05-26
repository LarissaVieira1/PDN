package com.ifsc.contaclique;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    SQLiteDatabase db;

    Button buttonInsere;
    EditText editText;

    ListView listView;

    @Override
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("banco", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, txt VARCHAR)");
        buttonInsere = findViewById(R.id.button);
        editText = findViewById(R.id.text);
        listView = findViewById(R.id.listView);
        buttonInsere.setOnClickListener(v->{
            String msg = editText.getText().toString();
            ListagemNotas();
            insereNota(msg);
        });
    }

    public void ListagemNotas(){
        Cursor cursor = db.rawQuery("SELECT * FROM notas",null);
        cursor.moveToFirst();
        ArrayList<String> ListaNotas  = new ArrayList<String>();
        while
        (!cursor.isAfterLast()){
            int coluna = cursor.getColumnIndex("txt");
            ListaNotas.add(cursor.getString(coluna));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                ListaNotas
                );
        listView.setAdapter(adapter);
    }
    public void insereNota(String txt){
        db.execSQL("INSERT INTO notas (txt) VALUES('"+txt+"'); ");
        ContentValues cv = new ContentValues();
        cv.put("txt",txt);
        db.insert("notas",null,cv);
    }


}
