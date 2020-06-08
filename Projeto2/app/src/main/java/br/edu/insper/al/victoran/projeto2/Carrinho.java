package br.edu.insper.al.victoran.projeto2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Carrinho {
    private ArrayList<Order> orders;
    public Carrinho(ArrayList<Order> orders){
        this.orders = orders;
    }
    public void setLista(ArrayList<Order> orders){
        this.orders = orders;
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public Double precoFinal(){
        double total = 0;
        for (Order order: orders){
            total = total + order.CalculateQuant();
        }
        return total;
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }

}
