package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.File;
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
            String textFinal = new String();
            String labels = lenghtPadronizer("DESCRITIVO") + lenghtPadronizer("QUANTIDADE") +
                    lenghtPadronizer("PREÇO") + lenghtPadronizer("MODELO") +
                    lenghtPadronizer("CÓDIGO") + lenghtPadronizer("TIPO") +
                    lenghtPadronizer("CATEGORIA") + lenghtPadronizer("LINHA") +
                    lenghtPadronizer("FUROS/MEDIDAS/COR") + "\n";

            for (Order order : orders) {
                Product produto = order.getProduto();
                String quantidade = Integer.toString(order.getQuantidade());
                String descritivo = produto.getDescritivo();
                int descSize = descritivo.length();
                String second = new String();
                String pulaLinha = new String();
                for (int n = 0; n < 6; n++){
                    pulaLinha += "--------------------|";
                }
                if (descSize >= 20){
                    String first = descritivo.substring(0,20);
                    if (descSize >= 40){
                        second = descritivo.substring(20,40);
                        String third = descritivo.substring(40,descSize);
                        descritivo = lenghtPadronizer(first) + pulaLinha +"\n" +
                                lenghtPadronizer(second) + pulaLinha + "\n" +
                                lenghtPadronizer(third);
                    } else{
                    second = descritivo.substring(20,descSize);
                    descritivo = lenghtPadronizer(first) + pulaLinha + "\n" +
                            lenghtPadronizer(second);
                    }
                }
                String text = descritivo + lenghtPadronizer(quantidade) +
                        lenghtPadronizer(("R$" + order.CalculateQuant())) +
                        lenghtPadronizer(produto.getModelo()) + lenghtPadronizer(produto.getCOD() ) +
                        lenghtPadronizer(produto.getTipo()) + lenghtPadronizer(produto.getCategoria()) +
                        lenghtPadronizer(produto.getLinha()) + "\n";
                textFinal += text;
            }

            FileOutputStream fos = null;

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(labels.getBytes());
                fos.write(textFinal.getBytes());

//                Toast.makeText(this, "Salvo em " + getFilesDir() + "/" + FILE_NAME,
//                        Toast.LENGTH_LONG).show();

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
            Uri path = FileProvider.getUriForFile(this, "br.edu.insper.al.victoran.projeto2",
                    new File(getFilesDir() + "/" + FILE_NAME));

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, path);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            shareIntent.setType("message/rfc822");
            startActivity(Intent.createChooser(shareIntent, "Share..."));
        });

        }
}
    public String lenghtPadronizer(String str){
//        if (str.length() > 19){
//            String first = str.substring(0,20);
//            int size = str.length();
//            String second = str.substring(20, size);
//            str = lenghtPadronizer(first) + "\n" + lenghtPadronizer(second);
//        }
//        else {
            while (str.length() <= 19){
                str += "-";
            }
            str += "|";
//        }


        return str;

    }}
