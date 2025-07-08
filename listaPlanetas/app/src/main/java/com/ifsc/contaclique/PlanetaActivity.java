package com.ifsc.contaclique;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlanetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planeta);

        Bundle bundle=getIntent().getExtras();

        Planeta p = (Planeta) bundle.getSerializable ("planeta");

        ImageView imageview =  findViewById(R.id.imagem);
        TextView text = findViewById(R.id.tvPlaneta);

        imageview.setImageResource(p.imagem);
        text.setText(p.nome);
    }
}