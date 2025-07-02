package com.ifsc.contaclick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    EditText edPeso,edAltura, edNome;
    TextView tvResultado;

    TextView txtIMC;
    Button buttonCalcular;


    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("ciclo de vida", "metodo onCreate");

        setContentView(R.layout.activity_main);
        txtIMC=findViewById(R.id.txtCalcularIMC);
        edPeso=findViewById((R.id.editTxtPeso));
        edAltura=findViewById(R.id.editTxtAltura);
        edNome=findViewById(R.id.editTextNome);
        buttonCalcular=findViewById(R.id.button);
        img=findViewById(R.id.imageView);
        img.setImageResource(R.drawable.perfil);



        buttonCalcular.setOnClickListener(v ->{
            //calcular imc
            float peso,altura,imc;
            peso = Float.parseFloat(edPeso.getText().toString());
            altura = Float.parseFloat(edAltura.getText().toString());

            imc = (peso/(altura * altura));

            //formatando número
            DecimalFormat decimalFormat = new DecimalFormat("##.##");

            //    tvResultado.setText(decimalFormat.format(imc));

            Intent intent = new Intent(getApplicationContext(), MainActivityB.class);

            String resultNome = edNome.getText().toString();
            intent.putExtra("Nome",resultNome);

            String resultAltura = edAltura.getText().toString();
            intent.putExtra("Altura",resultAltura);

            String resultPeso = edPeso.getText().toString();
            intent.putExtra("Peso",resultPeso);

            String resultIMC = String.valueOf(imc);
            intent.putExtra("IMC",resultIMC);

            startActivity(intent);
        });

    }

}