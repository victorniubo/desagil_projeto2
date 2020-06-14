package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PedidoOverview extends AppCompatActivity {

    ArrayList<Order> orders = new ArrayList<>();
    Carrinho carrinho;
    PedidoListAdapter adapter;
    ListView listaOrders;
    TextView total;
    Button end;
    private static final String FILE_NAME = "pedido.txt";

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

        end = findViewById(R.id.finalizar);
        end.setOnClickListener(view -> {
            String textFinal = "";
            for (Order order : orders) {
                Product produto = order.getProduto();
                String text = "Categoria: " + produto.getCategoria() + "; Modelo: " +
                        produto.getModelo() + "; Linha: " + produto.getLinha() + ", Código: " +
                        produto.getCOD() + "; Tipo: " + produto.getTipo() + "; Descritivo: " +
                        produto.getDescritivo() + "; Quantidade: " + order.getQuantidade() + "\n";
                textFinal += text;
            }

            FileOutputStream fos = null;

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(textFinal.getBytes());

                Toast.makeText(this, "Salvo em " + getFilesDir() + "/" + FILE_NAME,
                        Toast.LENGTH_LONG).show();
                System.out.println(textFinal);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        }


}}
