package br.edu.insper.al.victoran.projeto2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.text.DecimalFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class VarListAdapter extends ArrayAdapter {

    ArrayList<Variantes> vars;

    public VarListAdapter(Context context, int layout, ArrayList<Variantes> vars){
        super(context, layout);
        this.vars = vars;
    }


    public class ViewHolder{
        TextView furos;
        TextView tamanho;
        TextView modelo;
        TextView cor;

    }
    @Override
    public int getCount() {
        return vars.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        ViewHolder viewHolder;

        if(row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.adapter_var_layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.furos=row.findViewById(R.id.furos);
            viewHolder.tamanho=row.findViewById(R.id.tamanho);
            viewHolder.modelo=row.findViewById(R.id.modelo);
            viewHolder.cor = row.findViewById(R.id.cor);
            row.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) row.getTag();
        }


        viewHolder.furos.setText(vars.get(position).getFuro());
        viewHolder.tamanho.setText(vars.get(position).getMedida());
        viewHolder.modelo.setText(vars.get(position).getModel());
        viewHolder.cor.setText(vars.get(position).getCor());

        return row;

    }


}
