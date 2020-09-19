package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Adicionar extends AppCompatActivity {

    EditText et_nome, et_sobrenome, et_numero, et_morada, et_email;
    Button bt_ok;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        et_nome = findViewById(R.id.et_nome);
        et_sobrenome = findViewById(R.id.et_sobrenome);
        et_numero = findViewById(R.id.et_numero);
        et_morada = findViewById(R.id.et_morada);
        et_email = findViewById(R.id.et_email);
        bt_ok = findViewById(R.id.bt_ok);

        i = getIntent();

        et_nome.setText(i.getExtras().getString("nome"));


        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("nome", et_nome.getText().toString());
                i.putExtra("sobrenome", et_sobrenome.getText().toString());
                i.putExtra("numero", et_numero.getText().toString());
                i.putExtra("morada", et_morada.getText().toString());
                i.putExtra("email", et_email.getText().toString());
                setResult(1, i);
                finish();
            }
        });

    }
}