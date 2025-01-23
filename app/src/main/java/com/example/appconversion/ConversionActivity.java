package com.example.appconversion;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ConversionActivity extends AppCompatActivity {

    public TextView nombreUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.conversion_activity);

        TextView nombreUsuario = findViewById(R.id.nombreUsuario);
        Intent intent = getIntent();
        nombreUsuario.setText(intent.getStringExtra("nombreUsuario"));

        ConstraintLayout main = findViewById(R.id.main);
        main.setBackgroundColor(intent.getIntExtra("tema", Color.WHITE));

        Button btnLongitud = findViewById(R.id.btnLongitud);
        Button btnPeso = findViewById(R.id.btnPeso);
        Button btnTemperatura = findViewById(R.id.btnTemperatura);

        TextView objNombreUsuario = findViewById(R.id.nombreUsuario);

        btnLongitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConversionActivity.this, LongitudActivity.class);
                intent.putExtra("nombreUsuario",String.valueOf(objNombreUsuario.getText()));

                ConstraintLayout main = findViewById(R.id.main);
                intent.putExtra("tema", ((ColorDrawable) main.getBackground()).getColor());

                startActivity(intent);
            }
        });

        btnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConversionActivity.this, PesoActivity.class);
                intent.putExtra("nombreUsuario",String.valueOf(objNombreUsuario.getText()));

                ConstraintLayout main = findViewById(R.id.main);
                intent.putExtra("tema", ((ColorDrawable) main.getBackground()).getColor());

                startActivity(intent);
            }
        });

        btnTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConversionActivity.this, TemperaturaActivity.class);
                intent.putExtra("nombreUsuario",String.valueOf(objNombreUsuario.getText()));

                ConstraintLayout main = findViewById(R.id.main);
                intent.putExtra("tema", ((ColorDrawable) main.getBackground()).getColor());

                startActivity(intent);
            }
        });

        Button btnReiniciar = findViewById(R.id.reiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConversionActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
