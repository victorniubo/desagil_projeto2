package br.edu.insper.al.victoran.projeto2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ProductEx extends Product implements Parcelable {
    private ArrayList<Variantes> var;
    private int indicador;
    public ProductEx(String id, String categoria, String linha, String modelo, String tipo, String COD, String descritivo, String preco1, String preco2, String preco3, String variacao, String foto,ArrayList<Variantes> var) {
        super(id, categoria, linha, modelo, tipo, COD, descritivo, preco1, preco2, preco3, variacao, foto);
        this.var = var;
    }

    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }
    public int getIndicador(){
        return indicador;
    }

    protected ProductEx(Parcel in) {
        super(in);
        var = in.createTypedArrayList(Variantes.CREATOR);
        indicador = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(var);
        dest.writeInt(indicador);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductEx> CREATOR = new Creator<ProductEx>() {
        @Override
        public ProductEx createFromParcel(Parcel in) {
            return new ProductEx(in);
        }

        @Override
        public ProductEx[] newArray(int size) {
            return new ProductEx[size];
        }
    };

    @Override
    public ArrayList<Variantes> getVar(){
        return var;
    }

}
