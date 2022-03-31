package com.alvaroitu.aula05_01;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nome = findViewById(R.id.nome);
        EditText nacionalidade = findViewById(R.id.nacionalidade);

        Button gravar = findViewById(R.id.gravar);
        Button limpar = findViewById(R.id.limpar);
        Button recuperar = findViewById(R.id.recuperar);
        Button deletar = findViewById(R.id.deletar);

        TextView mostraDados = findViewById(R.id.mostraDados);

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("dados", Context.MODE_PRIVATE);
                SharedPreferences.Editor editaPrefs = prefs.edit();

                editaPrefs.putString("nome", nome.getText().toString());
                editaPrefs.putString("nacionalidade", nacionalidade.getText().toString());

                editaPrefs.apply();

                Toast.makeText(MainActivity.this, "Dados salvos", Toast.LENGTH_LONG).show();
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome.setText("");
                nacionalidade.setText("");
                mostraDados.setText("");
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("dados", Context.MODE_PRIVATE);

                //nome.setText(prefs.getString("nome", "não encontrado"));
                //nacionalidade.setText(prefs.getString("nacionalidade","não encontrado"));

                mostraDados.setText("O " + prefs.getString("nome", "não encontrado") + " é " +
                        prefs.getString("nacionalidade", "nao encontrado"));
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("dados", Context.MODE_PRIVATE);
                SharedPreferences.Editor editaPrefs = prefs.edit();

                editaPrefs.clear().apply();

                Toast.makeText(MainActivity.this, "Dados deletados", Toast.LENGTH_LONG).show();
            }
        });
    }
}