package com.example.kanika.indilens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kanika on 5/7/17.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private Items[] items;

    public ImageAdapter(Context c, Items[] items ){
        this.context = c;
        this.items = items;
    }

    public int getCount(){
        return items.length;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        final Items item = items[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.grid_single, null);
        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_icon);
        final TextView textView = (TextView)convertView.findViewById(R.id.textview_name);

        imageView.setImageResource(item.getImgId());
        textView.setText(item.getName());


        return convertView;
    }


}