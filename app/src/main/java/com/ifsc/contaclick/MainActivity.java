package com.ifsc.contaclick;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    EditText edPeso,edAltura;
    TextView tvResultado;
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("ciclo de vida", "metodo onCreate");

        setContentView(R.layout.activity_main);
        edPeso=findViewById((R.id.editTxtPeso));
        edAltura=findViewById(R.id.editTxtAltura);
        tvResultado=findViewById(R.id.tvResultadoImc);
        buttonCalcular=findViewById(R.id.button);
        buttonCalcular.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(), MainActivityB.class);
            String msg = edPeso.getText().toString();
            intent.putExtra("mensagem",msg);
            startActivity(intent);
        });

    }

}