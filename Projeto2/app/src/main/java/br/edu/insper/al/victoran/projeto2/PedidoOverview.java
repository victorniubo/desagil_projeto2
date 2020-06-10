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
    PedidoListAdapter adapter;
    ListView listaOrders;
    TextView descricao;
    TextView preco;
    TextView quantidade;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_overview);

        Intent intent = getIntent();
        if (orders != null){
        orders = intent.getParcelableArrayListExtra("ListaFinal");
        carrinho = new Carrinho(orders);

        total = findViewById(R.id.total);
//        preco = findViewById(R.id.textView6);
//        quantidade = findViewById(R.id.textView7);

//        descricao.setText(orders.get(0).getProduto().getDescritivo());
//        preco.setText(String.valueOf(orders.get(0).CalculateQuant()));
//        quantidade.setText("2");

            listaOrders = findViewById(R.id.listView2);


            adapter = new PedidoListAdapter(this, R.layout.adapter_order_layout,orders);
            listaOrders.setAdapter(adapter);
            total.setText(String.valueOf(carrinho.precoFinal()));



        }


}}
