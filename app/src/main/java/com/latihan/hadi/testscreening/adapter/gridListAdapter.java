package com.latihan.hadi.testscreening.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.latihan.hadi.testscreening.R;
import com.latihan.hadi.testscreening.model.guestApi;
import com.latihan.hadi.testscreening.model.modelEvent;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by SONY on 2/26/2015.
 */
public class gridListAdapter extends ArrayAdapter<guestApi> {
    private ArrayList<guestApi> listData;
    private LayoutInflater layoutInflater;

    public gridListAdapter(Context aContext, int resource, ArrayList listData) {
        super(aContext, resource, listData);
        this.listData = listData;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.row_grid, null);
        }
        guestApi g = listData.get(position);

        if (g != null) {
            ImageView image_grid = (ImageView) v.findViewById(R.id.image_grid);
            TextView nama_grid = (TextView) v.findViewById(R.id.nama_grid);
            TextView date_grid = (TextView) v.findViewById(R.id.date_grid);

            image_grid.setImageResource(R.drawable.udimo);
            nama_grid.setText(g.name);
            date_grid.setText("");
        }
        return v;
    }
}
