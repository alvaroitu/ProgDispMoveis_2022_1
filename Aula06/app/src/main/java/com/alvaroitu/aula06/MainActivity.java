package com.alvaroitu.aula06;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button salvar = findViewById(R.id.salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    //criar banco dados
                    SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

                    //criar tabela
                    bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

                    //inserindo registros
                    bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Alvaro', 30)");
                    bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Pereira', 20)");


                    //recurar o dados
                    Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas", null);

                    //indice da tabela
                    int indiceNome = cursor.getColumnIndex("nome");
                    int indiceIdade = cursor.getColumnIndex("idade");

                    cursor.moveToFirst();
                    while (cursor != null){
                        Log.i("Resultado - nome: ", cursor.getString(indiceNome));
                        Log.i("Resultado - idade: ", cursor.getString(indiceIdade));
                        cursor.moveToNext();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });//fim do botao




    }
}