package com.ifsc.contaclique;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int i=0;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recupera listview
        lv= findViewById(R.id.listView);

        PlanetaDao planetaDao=new PlanetaDao();


        AdapterPlaneta ap=new AdapterPlaneta(this,
                R.layout.item_lista,
                planetaDao.getPlanetas());
        lv.setAdapter(ap);
     lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Planeta p = planetaDao.getPlanetas().get(position);

        //Criamos uma intenção para abrir nova atividade
        Intent i = new Intent(getApplicationContext(),MainActivity2.class);

        i.putExtra("planeta",p);
        startActivity(i);
           }
     });
    }
}