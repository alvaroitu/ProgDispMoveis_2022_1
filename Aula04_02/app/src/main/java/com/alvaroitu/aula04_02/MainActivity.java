package com.alvaroitu.aula04_02;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button checkValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        checkValor = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        checkValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String planeta = spinner.getSelectedItem().toString();
                Toast toast = Toast.makeText(MainActivity.this, planeta, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}