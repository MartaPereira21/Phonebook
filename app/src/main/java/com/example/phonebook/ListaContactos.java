package com.example.phonebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ListaContactos extends AppCompatActivity {
    ImageView bt_add, bt_reverter;
    ListView lv_contactos;
    String nome = "", sobrenome = "", numero = "", morada = "", email = "";

    ArrayList<Contactos> contactos;
    ArrayAdapter<Contactos> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);

        lv_contactos = findViewById(R.id.lv_contactos);
        bt_add = findViewById(R.id.bt_add);
        bt_reverter = findViewById(R.id.bt_reverter);

        contactos = new ArrayList<>();
        contactos.add(new Contactos("Ana", "Martins", "+351961234545", "Rua da Esquerda", "ana@gmail.com"));
        contactos.add(new Contactos("João", "Cardoso", "+351961234578", "Rua de Baixo", "joao@gmail.com"));
        contactos.add(new Contactos("Maria", "Gomes", "+351912345678", "Rua de Cima", "maria@gmail.com"));


        adapter = new ArrayAdapter<>(ListaContactos.this, android.R.layout.simple_list_item_1, contactos);

        lv_contactos.setAdapter(adapter);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaContactos.this, Adicionar.class);
                i.putExtra("nome", nome);
                i.putExtra("nome", sobrenome);
                i.putExtra("nome", numero);
                i.putExtra("nome", morada);
                i.putExtra("nome", email);
                startActivityForResult(i, 1);

            }
        });


        lv_contactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent i = new Intent(ListaContactos.this, DadosContacto.class);
                i.putExtra("nome", contactos.get(pos).getNome());
                i.putExtra("sobrenome", contactos.get(pos).getSobrenome());
                i.putExtra("morada", contactos.get(pos).getMorada());
                i.putExtra("telefone", contactos.get(pos).getTelefone());
                i.putExtra("email", contactos.get(pos).getEmail());
                i.putExtra("id", contactos.get(pos).getId());
                i.putExtra("pos", pos);
                startActivityForResult(i, 1);


            }
        });
        bt_reverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Collections.reverse(contactos);
                adapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1) {
            nome = data.getExtras().getString("nome");
            sobrenome = data.getExtras().getString("sobrenome");
            numero = data.getExtras().getString("numero");
            morada = data.getExtras().getString("morada");
            email = data.getExtras().getString("email");
            contactos.add(new Contactos(nome, sobrenome, numero, morada, email));
            Collections.sort(contactos, new Comparator<Contactos>() {
                @Override
                public int compare(Contactos obj1, Contactos obj2) {
                    return obj1.toString().compareTo(obj2.toString());
                }
            });
            adapter.notifyDataSetChanged();


        }
        if (resultCode == 2) {
            int pos = data.getExtras().getInt("pos");
            contactos.remove(pos);
            Collections.sort(contactos, new Comparator<Contactos>() {
                @Override
                public int compare(Contactos obj1, Contactos obj2) {
                    return obj1.toString().compareTo(obj2.toString());
                }
            });
            adapter.notifyDataSetChanged();
        }
        if (resultCode == 3) {
            int pos = data.getExtras().getInt("pos");
            contactos.get(pos).setNome(data.getExtras().getString("nome"));
            contactos.get(pos).setSobrenome(data.getExtras().getString("sobrenome"));
            contactos.get(pos).setTelefone(data.getExtras().getString("numero"));
            contactos.get(pos).setMorada(data.getExtras().getString("morada"));
            contactos.get(pos).setEmail(data.getExtras().getString("email"));
            Collections.sort(contactos, new Comparator<Contactos>() {
                @Override
                public int compare(Contactos obj1, Contactos obj2) {
                    return obj1.toString().compareTo(obj2.toString());
                }
            });
            adapter.notifyDataSetChanged();
        }

    }

}






