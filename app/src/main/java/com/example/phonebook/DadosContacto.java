package com.example.phonebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DadosContacto extends AppCompatActivity {

    EditText et_nome, et_sobrenome, et_numero, et_morada, et_email;
    ImageView btcall, bt_eliminar, bt_editar;
    Intent i;

    String nome, sobrenome, telefone, morada, email;
    int pos, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_contacto);

        et_nome = findViewById(R.id.et_nome);
        et_sobrenome = findViewById(R.id.et_sobrenome);
        et_numero = findViewById(R.id.et_numero);
        et_morada = findViewById(R.id.et_morada);
        et_email = findViewById(R.id.et_email);
        btcall = findViewById(R.id.bt_call);
        bt_eliminar = findViewById(R.id.bt_eliminar);
        bt_editar = findViewById(R.id.bt_editar);


        i = getIntent();
        id = i.getExtras().getInt("id");
        pos = i.getExtras().getInt("pos");
        nome = i.getExtras().getString("nome");
        sobrenome = i.getExtras().getString("sobrenome");
        telefone = i.getExtras().getString("telefone");
        morada = i.getExtras().getString("morada");
        email = i.getExtras().getString("email");


        et_nome.setText(nome);
        et_sobrenome.setText(sobrenome);
        et_numero.setText(telefone);
        et_morada.setText(morada);
        et_email.setText(email);


        btcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telefone = et_numero.getText().toString();
                if (telefone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor insira um número!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + Uri.encode(telefone.trim())));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                }
            }
        });

        bt_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("pos", pos);
                setResult(2, i);
                finish();
            }
        });


        bt_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("nome", et_nome.getText().toString());
                i.putExtra("sobrenome", et_sobrenome.getText().toString());
                i.putExtra("numero", et_numero.getText().toString());
                i.putExtra("morada", et_morada.getText().toString());
                i.putExtra("email", et_email.getText().toString());
                i.putExtra("id", id);
                i.putExtra("pos", pos);

                setResult(3, i);
                finish();
            }
        });

    }
}