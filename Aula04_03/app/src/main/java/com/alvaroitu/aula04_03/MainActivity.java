package com.alvaroitu.aula04_03;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView mensagem;
    Switch som;
    String mensagemMostrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mensagem = findViewById(R.id.mensagem);
        som = findViewById(R.id.som);
        boolean checked = som.isChecked();
        som.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mensagem.setText(som.getTextOn().toString());
                if (som.isChecked()){
                    mensagemMostrada = "O Palmeiras TEM Mundial";
                    mensagem.setText(mensagemMostrada);
                } else {
                    mensagemMostrada = "O Palmeiras NÃO TEM Mundial";
                    mensagem.setText(mensagemMostrada);
                }
            }
        });
    }
}