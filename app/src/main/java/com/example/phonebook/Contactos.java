package com.example.phonebook;

public class Contactos {
    public int id;
    public String nome;
    public String telefone;
    public String sobrenome;
    public String morada;
    public String email;

    public Contactos() {
        id = 0;
    }


    public Contactos(String nome, String sobrenome, String telefone, String morada, String email) {
        this.id = getId();
        this.email = email;
        this.telefone = telefone;
        this.sobrenome = sobrenome;
        this.morada = morada;
        this.nome = nome;
    }

    public Contactos(String nome, String telefone, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.sobrenome = sobrenome;
        this.morada = morada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
