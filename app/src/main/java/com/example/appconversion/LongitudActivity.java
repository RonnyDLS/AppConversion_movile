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

public class LongitudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.longitud_activity);

        TextView nombreUsuario = findViewById(R.id.nombreUsuario);
        Intent intent = getIntent();
        nombreUsuario.setText(intent.getStringExtra("nombreUsuario"));

        ConstraintLayout main = findViewById(R.id.main);
        main.setBackgroundColor(intent.getIntExtra("tema", Color.WHITE));

        Button btnConvertir = findViewById(R.id.btnConvertir);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText objMetros = findViewById(R.id.Metros);
                String getMetros = String.valueOf(objMetros.getText());
                Double metros = Double.parseDouble(getMetros);

                final double valorConversion = 3.28084;
                double resultado = metros * valorConversion;
                TextView objPies = findViewById(R.id.Pies);
                objPies.setText(String.valueOf(resultado));

            }
        });

        Button btnReiniciar = findViewById(R.id.reiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LongitudActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
