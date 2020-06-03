package br.edu.insper.al.victoran.projeto2;

import android.os.Parcel;
import android.os.Parcelable;

import static java.lang.Double.parseDouble;

public class Order implements Parcelable {
    private Product produto;
    private int quantidade;

    public Order(Product produto){
    this.produto = produto;
    this.quantidade = 0;
    }

    protected Order(Parcel in) {
        produto = in.readParcelable(Product.class.getClassLoader());
        quantidade = in.readInt();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(produto, flags);
        //dest.writeInt(quantidade);
    }
}
