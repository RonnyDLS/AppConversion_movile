package com.example.appconversion;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnEntrar = findViewById(R.id.btnEntrar);
        EditText cjTxt = findViewById(R.id.cjTxt);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!String.valueOf(cjTxt.getText()).isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, ConversionActivity.class);
                    intent.putExtra("nombreUsuario", String.valueOf(cjTxt.getText()));

                    ConstraintLayout main = findViewById(R.id.main);
                    intent.putExtra("tema", ((ColorDrawable) main.getBackground()).getColor());

                    startActivity(intent);
                }
            }
        });


        Button btnTema = findViewById(R.id.btnTema);
        btnTema.setOnClickListener(new View.OnClickListener() {
            boolean gris_ = true;
            @Override
            public void onClick(View v) {

                ConstraintLayout main = findViewById(R.id.main);

                if(gris_){
                    main.setBackgroundResource(R.color.black);
                    gris_ = false;
                }else {
                    main.setBackgroundResource(R.color.white);
                    gris_ = true;
                }
            }
        });
    }
}