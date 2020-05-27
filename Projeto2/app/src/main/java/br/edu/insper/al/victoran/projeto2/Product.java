package br.edu.insper.al.victoran.projeto2;

public class Product {
    private String categoria;
    private String modelo;
    private String linha;
    private String tipo;
    private String COD;
    private String descritivo;
    private String preco1;
    private String preco2;
    private String preco3;

    public Product(String categoria,String linha, String modelo, String tipo, String COD, String descritivo, String preco1, String preco2, String preco3) {
        this.categoria = categoria;
        this.linha = linha;
        this.modelo = modelo;
        this.tipo = tipo;
        this.COD = COD;
        this.descritivo = descritivo;
        this.preco1 = preco1;
        this.preco2 = preco2;
        this.preco3 = preco3;
    }
    public String getCategoria(){return categoria;}
    public String getLinha(){return linha;}
    public String getModelo(){return modelo;}
    public String getTipo(){return tipo; }
    public String getCOD() { return COD;}
    public String getDescritivo(){ return descritivo;}
    public String getPreco1(){return preco1;}
    public String getPreco2(){return preco2;}
    public String getPreco3(){return preco3;}
}