package com.alvaroitu.aula04;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    Button mostraNome;
    TextView nomeRecebido;

    Button botaoEnviarEmail;

    Button botaoNavegador;

    Button botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mostraNome = findViewById(R.id.mostraNome);
        nomeRecebido = findViewById(R.id.nomeRecebido);

        botaoEnviarEmail = findViewById(R.id.botaoEnviarEmail);

        botaoNavegador = findViewById(R.id.botaoNavegador);

        botaoVoltar = findViewById(R.id.botaoVoltar);

        Bundle extras = getIntent().getExtras();
        String valorEnviadoDaTela1 = extras.getString("valorEnviado");

        mostraNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeRecebido.setText(valorEnviadoDaTela1);
            }
        });

        botaoEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", valorEnviadoDaTela1, null));
                email.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
                email.putExtra(Intent.EXTRA_TEXT, "BODY");
                startActivity(Intent.createChooser(email, "Enviar email"));

            }
        });

        botaoNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegador = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.br"));
                startActivity(navegador);
            }
        });

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(voltar);
            }
        });
    }
}