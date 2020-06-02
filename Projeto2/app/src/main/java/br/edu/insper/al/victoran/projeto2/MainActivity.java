package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

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
    ListView listaprods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaprods = findViewById(R.id.listView);

//        EditText procura = findViewById(R.id.barraProcura);
        prodlist = ReadProducts();

        adaptor = new ProdListAdaptor(this, R.layout.adapter_view_layout,prodlist);
        listaprods.setAdapter(adaptor);
        listaprods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent = intent.putExtra("Produto", prodlist.get(position));
                startActivity(intent);

            }
        });

    }
    private ArrayList<Product> ReadProducts(){
        InputStream is = getResources().openRawResource(R.raw.produtos);
        BufferedReader StrR = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String Str;

        try {

            //Essa estrutura do looping while é clássica para ler cada linha
            //do arquivo
            while ((Str = StrR.readLine()) != null) {
                String[] TableLine = Str.split(",");
                Product produto = new Product(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9]);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.searchMenu);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Product> resultados = new ArrayList<>();

                for(Product x:prodlist){

                    if(x.getCategoria().toLowerCase().contains(newText.toLowerCase())){
                        resultados.add(x);

                    }
                    else if(x.getModelo().toLowerCase().contains(newText.toLowerCase())){
                        resultados.add(x);

                    }
                    else if(x.getDescritivo().toLowerCase().contains(newText.toLowerCase())){
                        resultados.add(x);

                    }


                }
                ((ProdListAdaptor)listaprods.getAdapter()).update(resultados);



                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
