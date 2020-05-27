package br.edu.insper.al.victoran.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProdListAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaprods = findViewById(R.id.listView);
        EditText procura = findViewById(R.id.barraProcura);

        Product prod1 = new Product("Discoso e anéis","L-RAMPA","Prod",12.00,"DISCO MILHO - L RAMPA",12.00,12.00,12.00);
        Product prod2 = new Product("Discoso e anéis","L-RAMPA","Prod",12.00,"DISCO MILHO - L RAMPA",12.00,12.00,12.00);
        Product prod3 = new Product("Discoso e anéis","L-RAMPA","Prod",12.00,"DISCO MILHO - L RAMPA",12.00,12.00,12.00);
        Product prod4 = new Product("Discoso e anéis","L-RAMPA","Prod",12.00,"DISCO MILHO - L RAMPA",12.00,12.00,12.00);

        ArrayList<Product> prodlist = new ArrayList<>();
        prodlist.add(prod1);
        prodlist.add(prod2);
        prodlist.add(prod3);
        prodlist.add(prod4);

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
}
