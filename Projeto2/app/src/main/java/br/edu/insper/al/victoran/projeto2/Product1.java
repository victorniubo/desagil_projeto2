package br.edu.insper.al.victoran.projeto2;

public class Product1 {
    private String categotia;
    private String modelo;
    private String descritivo;


    public Product1(String categoria, String modelo,  String descritivo) {
        this.categotia = categoria;
        this.modelo = modelo;

        this.descritivo = descritivo;

    }
    public String getCategotia(){return categotia;}
    public String getModelo(){return modelo;}
    public String getDescritivo(){ return descritivo;}

}
