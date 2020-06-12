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

public class VarListAdapter extends ArrayAdapter {

    ArrayList<Var> vars;

    public VarListAdapter(Context context, int layout, ArrayList<Var> vars){
        super(context, layout);
        this.vars = vars;
    }


    public class ViewHolder{
        TextView furos;
        TextView tamanho;

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
            row.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) row.getTag();
        }


        viewHolder.furos.setText(vars.get(position).getFuros);
        viewHolder.tamanho.setText(vars.get(position).getTamanho);

        return row;

    }


}
