package com.example.appconversion;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TemperaturaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.temperatura_activity);

        TextView nombreUsuario = findViewById(R.id.nombreUsuario);
        Intent intent = getIntent();
        nombreUsuario.setText(intent.getStringExtra("nombreUsuario"));

        ConstraintLayout main = findViewById(R.id.main);
        main.setBackgroundColor(intent.getIntExtra("tema", Color.WHITE));

        Button btnConvertir = findViewById(R.id.btnConvertir);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText objCelsius = findViewById(R.id.celsius);
                String getCelsius = String.valueOf(objCelsius.getText());
                Double celsius = Double.parseDouble(getCelsius);

                double resultado = (celsius*9/5)+32;
                TextView objFahrenheit = findViewById(R.id.fahrenheit);
                objFahrenheit.setText(String.valueOf(resultado));
            }
        });

        Button btnReiniciar = findViewById(R.id.reiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TemperaturaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
