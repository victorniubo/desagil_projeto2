package br.edu.insper.al.victoran.projeto2;

import static java.lang.Double.parseDouble;

public class Order{
    private Product produto;
    private int quantidade;

    public Order(Product produto){
    this.produto = produto;
    this.quantidade = 0;
    }
    public void IncreQuantidade(){
        quantidade ++;
    }
    public void DecQuantidade(){
        quantidade --;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public double CalculateQuant(){
        double preco = parseDouble(produto.getPreco1());
        double precoTotal = quantidade * preco;
        return precoTotal;
    }

}
