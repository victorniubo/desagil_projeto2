package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProdListAdaptor adaptor;
    ArrayList<Product> prodlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaprods = findViewById(R.id.listView);
        EditText procura = findViewById(R.id.barraProcura);
        prodlist = ReadProducts();

        adaptor = new ProdListAdaptor(this, R.layout.adapter_view_layout,prodlist);
        listaprods.setAdapter(adaptor);

        procura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (MainActivity.this).adaptor.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private ArrayList<Product> ReadProducts(){
        InputStream is = getResources().openRawResource(R.raw.produtos);
        BufferedReader StrR = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String Str;
        ArrayList<Product> prodlist = new ArrayList<>();
        try {

            //Essa estrutura do looping while é clássica para ler cada linha
            //do arquivo
            while ((Str = StrR.readLine()) != null) {
                String[] TableLine = Str.split(",");
                Product produto = new Product(TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9]);
                //listaProdutos.add(new Product(TableLine[1], TableLine[2], TableLine[3], TableLine[4], TableLine[5], TableLine[6], TableLine[7], TableLine[8], TableLine[9]));
                prodlist.add(produto);
                Log.d("MyActivity","criado:" + produto);
            }
            //Fechamos o buffer
            StrR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prodlist;
    }

}
