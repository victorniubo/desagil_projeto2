package br.edu.insper.al.victoran.projeto2;

public class Variantes {
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
}
