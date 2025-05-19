package com.ifsc.contaclique;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        Planeta p = (Planeta) bundle.getSerializable("planeta");

        ImageView imageView = findViewById(R.id.imageViewPlaneta);
        TextView textView = findViewById(R.id.textViewPlaneta);

        imageView.setImageResource(p.imagem);
        textView.setText(p.nome);
    }
}