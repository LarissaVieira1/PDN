package com.ifsc.contaclick;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivityB extends AppCompatActivity {

    TextView IMCResult;
    TextView nome;
    TextView nomeResult;

    TextView alturaResult;

    TextView pesoResult;

    ImageView imgIMC;

    double imcCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_b);
        Bundle bundle = getIntent().getExtras();

        String result = bundle.getString("IMC");
        IMCResult = findViewById(R.id.textView);
        IMCResult.setText(result);

        String nome = bundle.getString("Nome");
        nomeResult = findViewById(R.id.txtNomeR);
        nomeResult.setText(nome);

        pesoResult=findViewById(R.id.txtPseoBR);
        String peso = bundle.getString("Peso");
        pesoResult.setText(peso);

        String altura = bundle.getString("Altura");
        alturaResult = findViewById(R.id.txtAlturaBR);
        alturaResult.setText(altura);


        imgIMC = findViewById(R.id.imgIMC);
        imcCalc = Double.parseDouble(result);

        if(imcCalc < 18.5) {
            imgIMC.setImageResource(R.drawable.abaixopeso);
        }
        if(imcCalc >= 18.5 && imcCalc < 24.9) {
            imgIMC.setImageResource(R.drawable.obesidade1);
        }
        if(imcCalc >= 25 && imcCalc < 29.9) {
            imgIMC.setImageResource(R.drawable.sobrepeso);
        }
        if(imcCalc >= 30 && imcCalc < 34.9) {
            imgIMC.setImageResource(R.drawable.obesidade1);
        }
        if(imcCalc >= 35 && imcCalc < 39.9) {
            imgIMC.setImageResource(R.drawable.obesidade2);
        }
        if(imcCalc >= 40) {
            imgIMC.setImageResource(R.drawable.obesidade3);
        }

    }
}