package com.alvaroitu.aula03_02;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText numero1;
    EditText numero2;
    TextView resultadoTv;

    Button adicao;
    Button subtracao;
    Button multiplicacao;
    Button divisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.editTextTextPersonName);
        numero2 = findViewById(R.id.editTextTextPersonName2);
        resultadoTv = findViewById(R.id.textView);

        adicao = findViewById(R.id.adicao);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);

        final DecimalFormat df = new DecimalFormat("0.00");

        adicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    double resultado = (Double.parseDouble(
//                            numero1.getEditableText().toString() +
//                            numero1.getEditableText().toString()));

                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) +
                                        Double.parseDouble(numero2.getEditableText().toString());

                    resultadoTv.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        subtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) -
                            Double.parseDouble(numero2.getEditableText().toString());

                    resultadoTv.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        multiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) *
                            Double.parseDouble(numero2.getEditableText().toString());

                    resultadoTv.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        divisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double resultado = Double.parseDouble(numero1.getEditableText().toString()) /
                            Double.parseDouble(numero2.getEditableText().toString());

                    resultadoTv.setText(df.format(resultado));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "entre com valores...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}