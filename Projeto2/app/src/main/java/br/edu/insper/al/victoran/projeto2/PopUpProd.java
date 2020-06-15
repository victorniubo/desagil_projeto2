package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;


public class PopUpProd extends AppCompatActivity{
    
    TextView PUcat;
    TextView PUlinha;
    TextView PUmod;
    TextView PUcod;
    TextView PUtipo;
    TextView PUdesc;
    TextView TituloSeletor;
    TextView PrecoA;
    TextView PrecoB;
    TextView PrecoC;
    TextView PrecoUnitario;
    TextView PrecoTotal;
    RadioGroup Seletor;
    RadioButton TabelaA;
    RadioButton TabelaB;
    RadioButton TabelaC;
    String mDrawableName;
    ImageView imagem;
    Order order;
    ArrayList<Order> orders = new ArrayList<>();
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_prod);

        imagem = findViewById(R.id.imageView);

        PUcat = findViewById(R.id.PUcat);
        PUlinha = findViewById(R.id.PUlinha);
        PUmod = findViewById(R.id.PUmod);
        PUcod = findViewById(R.id.PUcod);
        PUtipo = findViewById(R.id.PUtipo);
        PUdesc = findViewById(R.id.PUdesc);


        Seletor = findViewById(R.id.myRadioGroup);
        TabelaA = findViewById(R.id.TabelaA);
        TabelaB = findViewById(R.id.TabelaB);
        TabelaC = findViewById(R.id.TabelaC);
        Seletor.setVisibility(View.INVISIBLE);
        TituloSeletor = findViewById(R.id.TituloSeletor);
        TituloSeletor.setTextSize(0);

        PrecoA = findViewById(R.id.precoA);
        PrecoB = findViewById(R.id.precoB);
        PrecoC = findViewById(R.id.precoC);

        NumberPicker np2 = findViewById(R.id.np2);
        np2.setMinValue(0);
        np2.setMaxValue(300);
        np2.setWrapSelectorWheel(false);

        PrecoUnitario = findViewById(R.id.precoUnitario);
        PrecoTotal = findViewById(R.id.precoTotal);

        Button addcart = findViewById(R.id.addcart);


        Intent intent = getIntent();
        orders = intent.getParcelableArrayListExtra("lista");
        order = new Order(product);
        int pos = intent.getIntExtra("posicao",2222222);
        product = intent.getParcelableExtra("Produto");
        System.out.println(pos);

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
            PUmod.setText("Modelo: "+product.getModelo());
        }


        mDrawableName = product.getFoto();
        if (mDrawableName.equals("-")){
            imagem.setImageResource(R.drawable.jassyfoto);

        }else{
        Resources res = getResources();
        int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        imagem.setImageResource(resID);}


        if(product.getprecoCerto() == 0.00){
            Seletor.setVisibility(View.VISIBLE);
            TituloSeletor.setTextSize(20);
            Seletor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // find which radio button is selected
                    if(checkedId == R.id.TabelaA) {
                        product.setPrecoCerto(Double.valueOf(product.getPreco1()));
                        PrecoUnitario.setText("R$: " + product.getprecoCerto());
                        PrecoTotal.setText(String.valueOf(order.CalculateQuant()));
                    } else if(checkedId == R.id.TabelaB) {
                        product.setPrecoCerto(Double.valueOf(product.getPreco2()));
                        PrecoUnitario.setText("R$: " + product.getprecoCerto());
                        PrecoTotal.setText(String.valueOf(order.CalculateQuant()));
                    } else {
                        product.setPrecoCerto(Double.valueOf(product.getPreco3()));
                        PrecoUnitario.setText("R$: " + product.getprecoCerto());
                        PrecoTotal.setText(String.valueOf(order.CalculateQuant()));
                    }
                }
            });

        }else{
            PrecoUnitario.setText("R$: " + product.getprecoCerto());
        }


        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                order.setQuantidade(newVal);
                long tot = Math.round(order.CalculateQuant());

                PrecoTotal.setText(String.valueOf(tot));
            }
        });


        addcart.setOnClickListener((view) -> {
            String s = String.valueOf(order.getQuantidade());
            orders.add(order);
            showToast(s + " Unidades adicionadas");
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(PopUpProd.this, MainActivity.class);
        intent.putParcelableArrayListExtra("lista",orders);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    private void showToast(String text) {

        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }

}

