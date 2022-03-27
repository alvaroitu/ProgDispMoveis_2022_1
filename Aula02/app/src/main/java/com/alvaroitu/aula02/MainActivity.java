package com.alvaroitu.aula02;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button botaoTexto2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoTexto = (Button) findViewById(R.id.button1);

        RadioGroup radio = (RadioGroup) findViewById(R.id.sexo);

       // int radioButtonSelected = radio.getCheckedRadioButtonId();
       // RadioButton radioButton = (RadioButton) findViewById(radioButtonSelected);

        botaoTexto2 = (Button) findViewById(R.id.button2);


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int radioButtonSelected = radio.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(radioButtonSelected);
                    Toast toast = Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT);
                    toast.show();
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "nada foi selecionado", Toast.LENGTH_SHORT).show();
                }
            }
        };
        botaoTexto.setOnClickListener(clickListener);

        botaoTexto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "BOTAO2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}