package com.alvaroitu.aula06_01;

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

        EditText distancia = findViewById(R.id.distancia);
        Button calcular = findViewById(R.id.calcular);
        TextView resultado1 = findViewById(R.id.resultado1);
        TextView resultado2 = findViewById(R.id.resultado2);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double bandeira1 = 4.5;
                Double bandeira2 = 7.5;
                Double valorPorKm = 1.80;

                try{

                    Double corridaBandeira1 = Double.parseDouble(distancia.getEditableText().toString()) * valorPorKm + bandeira1;
                    Double corridaBandeira2 = Double.parseDouble(distancia.getEditableText().toString()) * valorPorKm + bandeira2;

                    resultado1.setText(" Valor em bandeira 1 = R$ " + corridaBandeira1.toString());
                    resultado2.setText(" Valor em bandeira 2 = R$ " + corridaBandeira2.toString());

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}