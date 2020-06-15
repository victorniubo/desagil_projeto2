package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    ProdListAdaptor adaptor;
    ArrayList<Product> prodlist = new ArrayList<>();
    ArrayList<Variantes> var0 = new ArrayList<>();
    ArrayList<Variantes> var1 = new ArrayList<>();
    ArrayList<Variantes> var2 = new ArrayList<>();
    ArrayList<Variantes> var3 = new ArrayList<>();
    ArrayList<Variantes> var4 = new ArrayList<>();
    ArrayList<Variantes> var5 = new ArrayList<>();
    ArrayList<Variantes> var6 = new ArrayList<>();
    ListView listaprods;
    TextView textoItens;
    TextView textoItens2;
    TextView textoItens3;
    ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaprods = findViewById(R.id.listView);
        textoItens = findViewById(R.id.titulo1);
        textoItens.setTextColor(Color.BLACK);
        textoItens2 = findViewById(R.id.titulo2);
        textoItens2.setTextColor(Color.BLACK);
        textoItens3 = findViewById(R.id.titulo3);
        textoItens3.setTextColor(Color.BLACK);


        Button pedido = findViewById(R.id.cart);
        pedido.setVisibility(View.INVISIBLE);
        prodlist = ReadProducts();
        adaptor = new ProdListAdaptor(this, R.layout.adapter_view_layout,prodlist);
        listaprods.setAdapter(adaptor);
        Intent intent = getIntent();
        orders = intent.getParcelableArrayListExtra("lista");
        if (orders == null) {orders = new ArrayList<>(); }

        listaprods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (adaptor.itens.get(position).getVariacao().equals("-")){
                    Intent intent = new Intent(MainActivity.this, PopUpProd.class);
                    intent.putExtra("Produto", adaptor.itens.get(position));
                    intent.putParcelableArrayListExtra("lista", orders);
                    startActivity(intent);
                }else{
                    Intent intent3 = new Intent(MainActivity.this, VarOverview.class);
                    intent3.putExtra("Produto", adaptor.itens.get(position));
                    intent3.putParcelableArrayListExtra("lista", orders);

                    startActivity(intent3);}

            }
        });


        if(orders.size() != 0){
        pedido.setVisibility(View.VISIBLE);
        pedido.setOnClickListener((view) -> {
            Intent intent2 = new Intent(MainActivity.this, PedidoOverview.class);
            intent2.putExtra("ListaFinal", orders);
            intent2.putParcelableArrayListExtra("ListaFinal", orders);
            startActivity(intent2);
        });}

    }
    private ArrayList<Product> ReadProducts(){
        InputStream is = getResources().openRawResource(R.raw.produtos);
        BufferedReader StrR = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String Str;
        ReadVar();

        try {
            //Essa estrutura do looping while é clássica para ler cada linha
            //do arquivo
            while ((Str = StrR.readLine()) != null) {
                String[] TableLine = Str.split(",");
                if (TableLine[10].equals("-")){
                Product produto = new Product(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9], TableLine[10],TableLine[11]);
                prodlist.add(produto);}
                else if (TableLine[6].equals("DISCO MILHO - RAMPFLOW")){
                          Product produto = new ProductEx(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9],TableLine[10],TableLine[11],var0);
                          prodlist.add(produto);
                }
                  else if (TableLine[6].equals("DISCO MILHO - BALDAN")){
                    Product produto = new ProductEx(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9],TableLine[10],TableLine[11],var1);
                    prodlist.add(produto);
                }
                  else if (TableLine[6].equals("DISCO SORGO - L-RAMPA")){
                    Product produto = new ProductEx(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9],TableLine[10],TableLine[11],var2);
                    prodlist.add(produto);
                }
                  else if (TableLine[6].equals("DISCO SOJA - RAMPFLOW")){
                    Product produto = new ProductEx(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9],TableLine[10],TableLine[11],var3);
                    prodlist.add(produto);
                }
                  else if (TableLine[6].equals("DISCO ALGODAO - RAMPFLOW")){
                    Product produto = new ProductEx(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9],TableLine[10],TableLine[11],var4);
                    prodlist.add(produto);
                }
                  else if (TableLine[6].equals("DISCO AMENDOIM")){
                    Product produto = new ProductEx(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9],TableLine[10],TableLine[11],var5);
                    prodlist.add(produto);
                }
                  else if (TableLine[6].equals("ANEL MILHO/FEIJAO")){
                    Product produto = new ProductEx(TableLine[0], TableLine[1],TableLine[2],TableLine[3],TableLine[4],TableLine[5],TableLine[6],TableLine[7],TableLine[8],TableLine[9],TableLine[10],TableLine[11],var6);
                    prodlist.add(produto);
                }


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

    private void ReadVar(){
        InputStream is = getResources().openRawResource(R.raw.variaveis);
        BufferedReader StrR = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String Str;

        try {

            //Essa estrutura do looping while é clássica para ler cada linha
            //do arquivo
            while ((Str = StrR.readLine()) != null) {
                String[] TableLine = Str.split(";");
                Variantes variante = new Variantes(TableLine[2],TableLine[4],TableLine[5],TableLine[6],TableLine[7]);

                if (variante != null){
                    if (TableLine[4].equals("DISCO MILHO - RAMPFLOW")){
                        var0.add(variante);
                    } else if (TableLine[4].equals("DISCO MILHO - BALDAN")){
                        var1.add(variante);
                    } else if (TableLine[4].equals("DISCO SORGO - L-RAMPA")){
                        var2.add(variante);
                    } else if (TableLine[4].equals("DISCO SOJA - RAMPFLOW")){
                        var3.add(variante);
                    } else if (TableLine[4].equals("DISCO ALGODAO - RAMPFLOW")){
                        var4.add(variante);
                    } else if (TableLine[4].equals("DISCO AMENDOIM")){
                        var5.add(variante);
                    } else if (TableLine[4].equals("ANEL MILHO/FEIJAO")){
                        var6.add(variante);
                    }}
            }
            //Fechamos o buffer
            StrR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

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
                ArrayList<Integer> id = new ArrayList<>();

                for(Product x:prodlist){

                    if(x.getLinha().toLowerCase().contains(newText.toLowerCase())){
                        int numero = Integer.parseInt(x.getId());
                        id.add(numero);
                        resultados.add(x);

                    }
                    else if(x.getModelo().toLowerCase().contains(newText.toLowerCase())){
                        int numero = Integer.parseInt(x.getId());
                        id.add(numero);
                        resultados.add(x);

                    }
                    else if(x.getDescritivo().toLowerCase().contains(newText.toLowerCase())){
                        int numero = Integer.parseInt(x.getId());
                        id.add(numero);
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
