package com.thoughtworks.iot.buybuddy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.thoughtworks.iot.buybuddy.view.*;

public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private List<String>data;
    private static LayoutInflater inflater = null;

    public LazyAdapter(Activity a, List<String> d) {
        activity = a;
        data = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        CustomizedListView customView=new CustomizedListView();
        View row = convertView;
        View rowView;
        rowView = inflater.inflate(R.layout.list_item, null);
        System.out.println(rowView);
        customView.name=(TextView) rowView.findViewById(R.id.name);
        customView.name.setText(data.get(position));
        rowView.setTag(customView);
        return rowView;
    }


    public void removeItem(View view) {
        CustomizedListView itemToRemove = (CustomizedListView) view.getTag();
        final ListView listView = (ListView) activity.findViewById(R.id.listview);
        System.out.println(itemToRemove.name + " is deleted");
    }
}