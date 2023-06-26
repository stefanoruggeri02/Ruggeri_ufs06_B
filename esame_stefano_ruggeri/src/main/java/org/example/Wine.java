package org.example;
public class Wine
{
    private int id;
    private String nome;
    private double prezzo;
    private String type;

    public Wine(int id, String nome, double prezzo, String type)
    {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.type = type;
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

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
