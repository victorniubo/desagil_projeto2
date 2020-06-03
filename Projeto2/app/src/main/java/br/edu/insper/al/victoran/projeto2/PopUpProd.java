package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.content.Intent;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class PopUpProd extends AppCompatActivity {


    TextView PUcat;
    TextView PUlinha;
    TextView PUmod;
    TextView PUcod;
    TextView PUtipo;
    TextView PUdesc;

    TextView PrecoA;
    TextView PrecoB;
    TextView PrecoC;

    ImageView imagem;

    ArrayList<Product> referencia = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_prod);
        PUcat = findViewById(R.id.PUcat);
        PUlinha = findViewById(R.id.PUlinha);
        PUmod = findViewById(R.id.PUmod);
        PUcod = findViewById(R.id.PUcod);
        PUtipo = findViewById(R.id.PUtipo);
        PUdesc = findViewById(R.id.PUdesc);

        PrecoA = findViewById(R.id.precoA);
        PrecoB = findViewById(R.id.precoB);
        PrecoC = findViewById(R.id.precoC);

        Intent intent = getIntent();
        Product product = intent.getParcelableExtra("Produto");

        PUcat.setText("Categoria: "+product.getCategoria());
        PUlinha.setText("Linha: "+product.getLinha());

        PUtipo.setText("Tipo: "+product.getTipo());
        PUdesc.setText("Descrição: "+product.getDescritivo());
        if (product.getCOD().equals("-")){
            PUcod.setTextSize(0);
        }else{
            PUcod.setText("Código: "+product.getCOD());
        }

        if (product.getModelo().equals("-")){
            PUmod.setTextSize(0);
        }else{
            PUmod.setText("Modelo: "+product.getModelo());;
        }

        PrecoA.setText("A:\nR$"+product.getPreco1());
        PrecoB.setText("B:\nR$"+product.getPreco2());
        PrecoC.setText("C:\nR$"+product.getPreco3());

        imagem = findViewById(R.id.imageView);

        imagem.setImageResource(R.drawable.selenium1);

        NumberPicker np = findViewById(R.id.np);
        NumberPicker np2 = findViewById(R.id.np2);
        NumberPicker np3 = findViewById(R.id.np3);

        np.setMinValue(0);

        np.setMaxValue(100);

        np.setWrapSelectorWheel(false);

        np2.setMinValue(0);

        np2.setMaxValue(100);

        np2.setWrapSelectorWheel(false);

        np3.setMinValue(0);

        np3.setMaxValue(100);

        np3.setWrapSelectorWheel(false);


        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){

                PrecoA.setText("A: "+newVal+"\nR$"+product.getPreco1());
            }
        });
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){

                PrecoB.setText("B: "+newVal+"\nR$"+product.getPreco2());

            }
        });
        np3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){

                PrecoC.setText("C: "+newVal+"\nR$"+product.getPreco3());

            }
        });


    }
}
