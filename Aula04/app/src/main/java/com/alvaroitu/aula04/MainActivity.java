package com.alvaroitu.aula04;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText entrada;
    Button botalSalvar;
    Button botaoEnviar;

    String textoDigitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = findViewById(R.id.entrada);

        botalSalvar = findViewById(R.id.botaoSalvar);
        botaoEnviar = findViewById(R.id.botaoEnviar);

        botalSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoDigitado = entrada.getText().toString();
            }
        });

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("valorEnviado", textoDigitado);
                startActivity(intent);
            }
        });
    }
}