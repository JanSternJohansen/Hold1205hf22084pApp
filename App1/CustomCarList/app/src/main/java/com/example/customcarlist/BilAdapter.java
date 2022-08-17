package com.example.customcarlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BilAdapter extends BaseAdapter
{
    private final List<Bil> biler;
    private final MainActivity context;

    public BilAdapter(List<Bil> biler, MainActivity mainActivity)
    {
        this.biler = biler;
        this.context = mainActivity;
    }

    @Override
    public int getCount() {
        return biler.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custom_item, null);

        Bil bil = biler.get(position);

        ImageView im = v.findViewById(R.id.imageView);
        im.setImageResource(bil.getBilBillede());
        TextView txtOverskrift = v.findViewById(R.id.txtOverskrift);
        txtOverskrift.setText(bil.getOverskrift());
        TextView txtBeskrivelse = v.findViewById(R.id.txtBeskrivelse);
        txtBeskrivelse.setText(bil.getBeskrivelse());

        return v;
    }
}
