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
import java.util.List;

public class ProdListAdaptor extends ArrayAdapter<Product> {

    private Context mContext;
    int mResource;

    public ProdListAdaptor(Context context, int resource, ArrayList<Product> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String cat = getItem(position).getCategoria();
        String mod = getItem(position).getModelo();
        String desc = getItem(position).getDescritivo();
        

        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(mResource, parent, false);

        TextView tvCat = convertView.findViewById(R.id.tvcategoria);
        TextView tvMod = convertView.findViewById(R.id.tvmodelo);
        TextView tvDesc = convertView.findViewById(R.id.tvdescritivo);

        tvCat.setText(cat);
        tvMod.setText(mod);
        tvDesc.setText(desc);

        return convertView;




    }
}
