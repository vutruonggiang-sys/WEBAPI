package com.example.webapidemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterProduct extends BaseAdapter {
    List<Product> productList;

    public AdapterProduct(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_product_activity,parent,false);
        TextView tvID,tvTitle;
        tvID=view.findViewById(R.id.tvID);
        tvTitle=view.findViewById((R.id.tvTitle));
        Product product=productList.get(position);
        tvID.setText(product.getId()+"");
        tvTitle.setText(product.getTitle());
        return view;
    }
}
