package br.edu.insper.al.victoran.projeto2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PedidoListAdapter extends ArrayAdapter {

    ArrayList<Order> orders;

    public PedidoListAdapter(Context context, int layout, ArrayList<Order> orders){
        super(context, layout);
        this.orders=orders;
    }


    public class ViewHolder{
        TextView prodDesc;
        TextView prodPrec;
        TextView prodQuant;
    }
    @Override
    public int getCount() {
        return orders.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        ViewHolder viewHolder;

        if(row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.adapter_order_layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.prodDesc=row.findViewById(R.id.prodDesc);
            viewHolder.prodPrec=row.findViewById(R.id.prodPrec);
            viewHolder.prodQuant=row.findViewById(R.id.prodQuant);
            row.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) row.getTag();
        }
        Double preco_int = orders.get(position).CalculateQuant();
        String preço_redondo = new DecimalFormat("#,##0.00").format(preco_int);
        String quantidade = String.valueOf(orders.get(position).getQuantidade());

        viewHolder.prodDesc.setText(orders.get(position).getProduto().getDescritivo());
        viewHolder.prodPrec.setText(preço_redondo);
        viewHolder.prodQuant.setText(quantidade);

        return row;

    }


}
