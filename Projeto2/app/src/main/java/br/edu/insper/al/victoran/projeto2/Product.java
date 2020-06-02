package br.edu.insper.al.victoran.projeto2;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String id;
    private String categoria;
    private String modelo;
    private String linha;
    private String tipo;
    private String COD;
    private String descritivo;
    private String preco1;
    private String preco2;
    private String preco3;

    public Product(String id, String categoria, String linha, String modelo, String tipo, String COD, String descritivo, String preco1, String preco2, String preco3) {
        this.id = id;
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

    protected Product(Parcel in) {
        id = in.readString();
        categoria = in.readString();
        modelo = in.readString();
        linha = in.readString();
        tipo = in.readString();
        COD = in.readString();
        descritivo = in.readString();
        preco1 = in.readString();
        preco2 = in.readString();
        preco3 = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getCategoria(){return categoria;}
    public String getLinha(){return linha;}
    public String getModelo(){return modelo;}
    public String getTipo(){return tipo; }
    public String getCOD() { return COD;}
    public String getDescritivo(){ return descritivo;}
    public String getPreco1(){return preco1;}
    public String getPreco2(){return preco2;}
    public String getPreco3(){return preco3;}

    public String getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(categoria);
        dest.writeString(modelo);
        dest.writeString(linha);
        dest.writeString(tipo);
        dest.writeString(COD);
        dest.writeString(descritivo);
        dest.writeString(preco1);
        dest.writeString(preco2);
        dest.writeString(preco3);
    }
}