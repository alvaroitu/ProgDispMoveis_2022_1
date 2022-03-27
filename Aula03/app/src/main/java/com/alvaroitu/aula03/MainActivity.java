package com.alvaroitu.aula03;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPassword;

    RadioGroup radioGroupSexo;
    RadioButton radioButtonSexo;

    CheckBox checkBoxJava;
    CheckBox checkBoxPython;

    Button buttonEnviar;

    TextView textViewName;
    TextView textViewEmail;
    TextView textViewPassword;

    TextView textViewSexo;

    TextView textViewJava;
    TextView textViewPython;

    String valorPython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);

        radioGroupSexo = findViewById(R.id.radioGroup);

        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxPython = findViewById(R.id.checkBoxJPython);

        textViewName = findViewById(R.id.textView1);
        textViewEmail = findViewById(R.id.textView2);
        textViewPassword = findViewById(R.id.textView3);

        textViewSexo = findViewById(R.id.textView4);

        textViewJava = findViewById(R.id.textView5);
        textViewPython = findViewById(R.id.textView6);

        buttonEnviar = findViewById(R.id.button);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextName.getText().toString();
                textViewName.setText(nome);

                String email = editTextEmail.getText().toString();
                textViewEmail.setText(email);

                String password = editTextPassword.getText().toString();
                textViewPassword.setText(password);

                int sexoSelecionado = radioGroupSexo.getCheckedRadioButtonId();
                radioButtonSexo = findViewById(sexoSelecionado);
                textViewSexo.setText(radioButtonSexo.getText());

                boolean java = checkBoxJava.isChecked();
                textViewJava.setText(Boolean.toString(java));

                boolean python = checkBoxPython.isChecked();
                if(python){
                    valorPython = "Verdadeiro";
                }else{
                    valorPython = "Falso";
                }
                textViewPython.setText(valorPython);
            }
        });
    }
}