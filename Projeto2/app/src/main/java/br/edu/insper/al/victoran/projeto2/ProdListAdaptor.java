package br.edu.insper.al.victoran.projeto2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProdListAdaptor extends ArrayAdapter {

    ArrayList<Product> itens;

    public ProdListAdaptor(Context context, int layout, ArrayList<Product> itens){
        super(context, layout);
        this.itens=itens;
    }
    public void update(ArrayList<Product> resultados){

        itens = new ArrayList<>();
        itens.addAll(resultados);
        notifyDataSetChanged();

    }

    public class ViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }
    @Override
    public int getCount() {
        return itens.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        ViewHolder viewHolder;

        if(row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.adapter_view_layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textView1=row.findViewById(R.id.tvlinha);
            viewHolder.textView2=row.findViewById(R.id.tvmodelo);
            viewHolder.textView3=row.findViewById(R.id.tvdescritivo);
            row.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) row.getTag();
        }
        viewHolder.textView1.setText(itens.get(position).getLinha());
        viewHolder.textView2.setText(itens.get(position).getModelo());
        viewHolder.textView3.setText(itens.get(position).getDescritivo());

        return row;

    }


}
