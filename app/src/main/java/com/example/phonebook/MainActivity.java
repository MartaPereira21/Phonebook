package com.example.phonebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btEntrar = findViewById(R.id.bt_entrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsername.getText().toString().equals("user") &&
                        etPassword.getText().toString().equals("1234")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );

                    final AlertDialog.Builder builde = builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login correto!");
                    builder.setMessage("Bem-vindo");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    Intent i = new Intent(MainActivity.this, Menu.class);
                    startActivityForResult(i, 1);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Password ou  Username inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}