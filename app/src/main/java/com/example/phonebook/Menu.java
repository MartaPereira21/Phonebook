package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    ImageView bt_listacontactos, bt_sobre, bt_avaliacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_listacontactos = findViewById(R.id.bt_listacontactos);
        bt_sobre = findViewById(R.id.bt_sobre);
        bt_avaliacao = findViewById(R.id.bt_avaliacao);

        bt_listacontactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, ListaContactos.class);
                startActivity(i);
            }
        });

        bt_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Sobre.class);
                startActivity(i);

            }
        });

        bt_avaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Avaliacao.class);
                startActivity(i);

            }
        });
    }
}