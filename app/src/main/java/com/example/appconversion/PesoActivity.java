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

public class PesoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.peso_activity);

        TextView nombreUsuario = findViewById(R.id.nombreUsuario);
        Intent intent = getIntent();
        nombreUsuario.setText(intent.getStringExtra("nombreUsuario"));

        ConstraintLayout main = findViewById(R.id.main);
        main.setBackgroundColor(intent.getIntExtra("tema", Color.WHITE));

        Button btnConvertir = findViewById(R.id.btnConvertir);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText objKgramos = findViewById(R.id.kgramos);
                String getKgramos = String.valueOf(objKgramos.getText());
                Double kgramos = Double.parseDouble(getKgramos);

                final double valorConversion = 2.20462;
                double resultado = kgramos * valorConversion;
                TextView objLb = findViewById(R.id.lb);
                objLb.setText(String.valueOf(resultado));

            }
        });

        Button btnReiniciar = findViewById(R.id.reiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PesoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
