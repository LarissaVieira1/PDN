package com.ifsc.contaclique;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int i=0;

    EditText edPeso,edAltura;
    TextView tvResultado;
    Button buttonCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edPeso = findViewById(R.id.txtPeso);
        edAltura = findViewById(R.id.txtAltura);
        tvResultado = findViewById(R.id.txtResultado);
        buttonCalcular = findViewById(R.id.button);
        //Define um tratamento para o click do botão
        buttonCalcular.setOnClickListener(v->{
            double peso,altura,imc;
            peso=Double.parseDouble(edPeso.getText().toString());
            altura=Double.parseDouble(edAltura.getText().toString());
            imc= peso/(altura*altura);

            tvResultado.setText(Double.toString(imc));
        });

    }
}