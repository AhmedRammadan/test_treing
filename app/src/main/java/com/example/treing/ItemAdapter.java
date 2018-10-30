package com.example.treing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Context context, int resource, ArrayList<Item> items) {
        super(context, 0, items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItmeView=convertView;
        if (listItmeView==null){
            listItmeView= LayoutInflater.from(getContext()).inflate(R.layout.row_item,parent,false);
        }
        Item item =getItem(position);
        TextView name=listItmeView.findViewById(R.id.textView_name);
        name.setText(item.getName());
        TextView age=listItmeView.findViewById(R.id.textView_age);
        age.setText(String.valueOf(item.getAge()));
        return listItmeView;
    }
}
