package com.alvaroitu.aula06;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nome = findViewById(R.id.nome);
        EditText idade = findViewById(R.id.idade);
        Button botaoInserir = findViewById(R.id.botaoInserir);

        EditText pesquisar = findViewById(R.id.pesquisar);
        Button botaoPesquisar = findViewById(R.id.botaoPesquisar);

        EditText idAtualizar = findViewById(R.id.idAtualizar);
        EditText novoNome = findViewById(R.id.novoNome);
        EditText novaIdade = findViewById(R.id.novaIdade);
        Button botaoAtualizar = findViewById(R.id.botaoAtualizar);

        EditText idDeletar = findViewById(R.id.idDeletar);
        Button botaoDeletar = findViewById(R.id.botaoDeletar);

        botaoInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeInserido = nome.getEditableText().toString();
                int idadeInserida = Integer.parseInt(idade.getEditableText().toString());

                try {
                    //criar/abrir banco dados
                    SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

                    //criar tabela / remover tabale
                    bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas " +
                            "(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
                    //bancoDados.execSQL("DROP TABLE pessoas");

                    //inserindo registros
//
                    bancoDados.execSQL("INSERT INTO pessoas(nome, idade) " +
                            "VALUES('" + nomeInserido + "', '" + idadeInserida + "')");

                    //mostrar o dados
                    String consulta = "SELECT * FROM pessoas";
                    Cursor cursor = bancoDados.rawQuery(consulta, null);

                    //indice da tabela
                    int indiceId = cursor.getColumnIndex("id");
                    int indiceNome = cursor.getColumnIndex("nome");
                    int indiceIdade = cursor.getColumnIndex("idade");

                    cursor.moveToFirst();
                    while (cursor != null){

                        String id = cursor.getString(indiceId);
                        String nome = cursor.getString(indiceNome);
                        String idade = cursor.getString(indiceIdade);

                        Log.i("Resultado - ID " + id + " / nome ", nome + " / idade " + idade);
                        cursor.moveToNext();
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });//fim do botao inserir

        botaoPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valorPesquisado = pesquisar.getEditableText().toString();

                try {

                    //criar/abrir banco dados
                    SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

                    //filtrar/recuperar o dados

                    String consulta = "SELECT * FROM pessoas WHERE nome LIKE '%" + valorPesquisado + "%'";
                    Cursor cursor = bancoDados.rawQuery(consulta, null);


                    //indice da tabela
                    int indiceId = cursor.getColumnIndex("id");
                    int indiceNome = cursor.getColumnIndex("nome");
                    int indiceIdade = cursor.getColumnIndex("idade");

                    cursor.moveToFirst();
                    while (cursor != null){

                        String id = cursor.getString(indiceId);
                        String nome = cursor.getString(indiceNome);
                        String idade = cursor.getString(indiceIdade);

                        Log.i("Resultado - ID " + id + " / nome ", nome + " / idade " + idade);
                        cursor.moveToNext();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }); // fim do botao pesquisar

        botaoAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idSeraAtualizado = Integer.parseInt(idAtualizar.getEditableText().toString());
                String nomeAtualizado = novoNome.getEditableText().toString();
                int idadeAtualizada = Integer.parseInt(novaIdade.getEditableText().toString());

                try {

                    //criar/abrir banco dados
                    SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

                    //atualizar registro
                    bancoDados.execSQL("UPDATE pessoas SET nome = '" + nomeAtualizado + "', idade = " + idadeAtualizada + " WHERE id = '" + idSeraAtualizado + "'");

                    //mostrar o dados
                    String consulta = "SELECT * FROM pessoas";
                    Cursor cursor = bancoDados.rawQuery(consulta, null);

                    //indice da tabela
                    int indiceId = cursor.getColumnIndex("id");
                    int indiceNome = cursor.getColumnIndex("nome");
                    int indiceIdade = cursor.getColumnIndex("idade");

                    cursor.moveToFirst();
                    while (cursor != null){

                        String id = cursor.getString(indiceId);
                        String nome = cursor.getString(indiceNome);
                        String idade = cursor.getString(indiceIdade);

                        Log.i("Resultado - ID " + id + " / nome ", nome + " / idade " + idade);
                        cursor.moveToNext();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });// fim do botao atualizar

        botaoDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idSeraDeletado = Integer.parseInt(idDeletar.getEditableText().toString());

                try {

                    //criar/abrir banco dados
                    SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

                    //deletar item
                    bancoDados.execSQL("DELETE FROM pessoas WHERE id = '" + idSeraDeletado + "'");

                    //mostrar o dados
                    String consulta = "SELECT * FROM pessoas";
                    Cursor cursor = bancoDados.rawQuery(consulta, null);

                    //indice da tabela
                    int indiceId = cursor.getColumnIndex("id");
                    int indiceNome = cursor.getColumnIndex("nome");
                    int indiceIdade = cursor.getColumnIndex("idade");

                    cursor.moveToFirst();
                    while (cursor != null){

                        String id = cursor.getString(indiceId);
                        String nome = cursor.getString(indiceNome);
                        String idade = cursor.getString(indiceIdade);

                        Log.i("Resultado - ID " + id + " / nome ", nome + " / idade " + idade);
                        cursor.moveToNext();
                    }




                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });// fim do botao deletar

    }
}