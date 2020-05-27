package br.edu.insper.al.victoran.projeto2;

public class Product {
    private String categotia;
    private String modelo;
    private String tipo;
    private Double COD;
    private String descritivo;
    private Double preco1;
    private Double preco2;
    private Double preco3;

    public Product(String categoria, String modelo, String tipo, Double COD, String descritivo, Double preco1, Double preco2, Double preco3) {
        this.categotia = categoria;
        this.modelo = modelo;
        this.tipo = tipo;
        this.COD = COD;
        this.descritivo = descritivo;
        this.preco1 = preco1;
        this.preco2 = preco2;
        this.preco3 = preco3;
    }
    public String getCategotia(){return categotia;}
    public String getModelo(){return modelo;}
    public String getTipo(){return tipo; }
    public Double getCOD() { return COD;}
    public String getDescritivo(){ return descritivo;}
    public Double getPreco1(){return preco1;}
    public Double getPreco2(){return preco2;}
    public Double getPreco3(){return preco3;}
}