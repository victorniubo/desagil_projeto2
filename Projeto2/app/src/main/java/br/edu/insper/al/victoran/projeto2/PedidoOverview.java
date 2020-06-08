package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import java.util.ArrayList;

public class PedidoOverview extends AppCompatActivity {

    ArrayList<Order> orders = new ArrayList<>();
    Carrinho carrinho;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_overview);




        Intent intent = getIntent();
        if (orders != null){
        orders = intent.getParcelableArrayListExtra("ListaFinal");
        carrinho = new Carrinho(orders);
        //texto.setText(String.valueOf(carrinho.precoFinal()));}

            System.out.println(carrinho.precoFinal());


    }
}}