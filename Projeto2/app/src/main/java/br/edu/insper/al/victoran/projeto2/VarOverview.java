package br.edu.insper.al.victoran.projeto2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class VarOverview extends AppCompatActivity {

    private ArrayList<Variantes> variantes = new ArrayList<>();
    private ListView listaVar;
    private TextView nomeProduto;
    private VarListAdapter adapter;
    private ProductEx product;
    private ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var_overview);

        Intent intent = getIntent();
        product = intent.getParcelableExtra("Produto");
        orders = intent.getParcelableArrayListExtra("lista");


        listaVar = findViewById(R.id.listView3);
        nomeProduto = findViewById(R.id.nomeprod);

        adapter = new VarListAdapter(this, R.layout.adapter_var_layout, product.getVar());
        listaVar.setAdapter(adapter);
        nomeProduto.setText(product.getVar().get(0).getDescritivo());
        listaVar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                product.setIndicador(position);
                Intent intent = new Intent(VarOverview.this, PopUpProd.class);
                intent.putExtra("Produto", product);
                intent.putParcelableArrayListExtra("lista", orders);
                startActivity(intent);
            }
        });


    }

    public void onBackPressed() {

        Intent intent = new Intent(VarOverview.this, MainActivity.class);
        intent.putParcelableArrayListExtra("lista", orders);
        startActivity(intent);

    }

}
