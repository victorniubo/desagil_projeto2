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
    ArrayList<Variantes> var0;
    ArrayList<Variantes> var1;
    ArrayList<Variantes> var2;
    ArrayList<Variantes> var3;
    ArrayList<Variantes> var4;
    ArrayList<Variantes> var5;
    ArrayList<Variantes> var6;
    VarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var_overview);

        Intent intent = getIntent();
        Product product = intent.getParcelableExtra("Produto");
        var0 = intent.getParcelableArrayListExtra("Disco milho ramp");
        var1 = intent.getParcelableArrayListExtra("Disco milho baldan");
        var2 = intent.getParcelableArrayListExtra("Disco sorgo rampa");
        var3 = intent.getParcelableArrayListExtra("Disco soja ramp");
        var4 = intent.getParcelableArrayListExtra("Disco algodao ramp");
        var5 = intent.getParcelableArrayListExtra("Disco minduim");
        var6 = intent.getParcelableArrayListExtra("Anel");

        listaVar = findViewById(R.id.listView3);
        nomeProduto = findViewById(R.id.nomeprod);

        if(product.getDescritivo().equals(var0.get(0).getDescritivo())){
            adapter = new VarListAdapter(this, R.layout.adapter_var_layout,var0);
            listaVar.setAdapter(adapter);
            nomeProduto.setText(var0.get(0).getDescritivo());

        }
        else if(product.getDescritivo().equals(var1.get(0).getDescritivo())){
            adapter = new VarListAdapter(this, R.layout.adapter_var_layout,var1);
            listaVar.setAdapter(adapter);
            nomeProduto.setText(var1.get(0).getDescritivo());
        }
        else if(product.getDescritivo().equals(var2.get(0).getDescritivo())){
            adapter = new VarListAdapter(this, R.layout.adapter_var_layout,var2);
            listaVar.setAdapter(adapter);
            nomeProduto.setText(var2.get(0).getDescritivo());
        }
        else if(product.getDescritivo().equals(var3.get(0).getDescritivo())){
            adapter = new VarListAdapter(this, R.layout.adapter_var_layout,var3);
            listaVar.setAdapter(adapter);
            nomeProduto.setText(var3.get(0).getDescritivo());
        }
        else if(product.getDescritivo().equals(var4.get(0).getDescritivo())){
            adapter = new VarListAdapter(this, R.layout.adapter_var_layout,var4);
            listaVar.setAdapter(adapter);
            nomeProduto.setText(var4.get(0).getDescritivo());
        }
        else if(product.getDescritivo().equals(var5.get(0).getDescritivo())){
            adapter = new VarListAdapter(this, R.layout.adapter_var_layout,var5);
            listaVar.setAdapter(adapter);
            nomeProduto.setText(var5.get(0).getDescritivo());
        }
        else if(product.getDescritivo().equals(var6.get(0).getDescritivo())){
            adapter = new VarListAdapter(this, R.layout.adapter_var_layout,var6);
            listaVar.setAdapter(adapter);
            nomeProduto.setText(var6.get(0).getDescritivo());
        }
    }
}
