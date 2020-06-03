package br.edu.insper.al.victoran.projeto2;

import java.util.LinkedList;

public class Carrinho {
    private LinkedList<Order> orders;
    public Carrinho(LinkedList<Order> orders){
        this.orders = new LinkedList<>();
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

    public LinkedList<Order> getOrders() {
        return orders;
    }
}
