package com.thoughtworks.iot.buybuddy;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.thoughtworks.iot.buybuddy.view.CustomizedListView;
import com.thoughtworks.iot.buybuddy.view.Product;

import java.util.List;

public class LazyAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> items;
    private int layoutResourceId;


    public LazyAdapter(Context context, int layoutResourceId, List<Product> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }
    public int getCount() {
        return items.size();
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CustomizedListView holder=new CustomizedListView();
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        holder.product = items.get(position);

        holder.removeButton = (Button) row.findViewById(R.id.button2);
        holder.removeButton.setTag(holder.product);

        holder.name=(TextView) row.findViewById(R.id.name);
        holder.name.setText(holder.product.name);
        holder.description = (TextView) row.findViewById(R.id.description);
        holder.description.setText(holder.product.description);

        holder.price = (TextView) row.findViewById(R.id.price);
        holder.price.setText(holder.product.price);

        row.setTag(holder);
        return row;
    }


}