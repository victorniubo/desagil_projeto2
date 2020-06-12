package br.edu.insper.al.victoran.projeto2;

import android.os.Parcel;
import android.os.Parcelable;

public class Variantes implements Parcelable {
    private String model;
    private String descritivo;
    private String furo;
    private String medida;
    private String cor;

    public Variantes(String model, String descritivo, String furo, String medida, String  cor){
        this.model = model;
        this.descritivo = descritivo;
        this.furo = furo;
        this.medida = medida;
        this.cor = cor;

    }

    protected Variantes(Parcel in) {
        model = in.readString();
        descritivo = in.readString();
        furo = in.readString();
        medida = in.readString();
        cor = in.readString();
    }

    public static final Creator<Variantes> CREATOR = new Creator<Variantes>() {
        @Override
        public Variantes createFromParcel(Parcel in) {
            return new Variantes(in);
        }

        @Override
        public Variantes[] newArray(int size) {
            return new Variantes[size];
        }
    };

    public String getModel() {
        return model;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public String getFuro() {
        return furo;
    }

    public String getMedida() {
        return medida;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model);
        dest.writeString(descritivo);
        dest.writeString(furo);
        dest.writeString(medida);
        dest.writeString(cor);
    }
}
