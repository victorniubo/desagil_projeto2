package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class VarOverview extends AppCompatActivity {

    private ArrayList<Variantes> variantes = new ArrayList<>();
    ListView listaVar;
    TextView nomeProduto;
    VarListAdapter adapter;
    ProductEx product;
    Product prod;
    Order order;
    ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var_overview);

        Intent intent = getIntent();
        if(intent != null) {
            product = intent.getParcelableExtra("Produto1");
            orders = intent.getParcelableArrayListExtra("lista1");
        }
        //order = new Order(product);


        listaVar = findViewById(R.id.listView3);
        nomeProduto = findViewById(R.id.nomeprod);

        adapter = new VarListAdapter(this, R.layout.adapter_var_layout,product.getVar());
        listaVar.setAdapter(adapter);
        nomeProduto.setText(product.getVar().get(0).getDescritivo());

}}
