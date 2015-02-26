package com.latihan.hadi.testscreening.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.latihan.hadi.testscreening.R;
import com.latihan.hadi.testscreening.model.modelEvent;
import com.latihan.hadi.testscreening.model.modelNama;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SONY on 2/25/2015.
 */
public class eventListAdapter extends BaseAdapter{
    private ArrayList<modelEvent> listData;
    private LayoutInflater layoutInflater;

    public eventListAdapter(Context aContext, ArrayList<modelEvent> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_event, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.namaView = (TextView) convertView.findViewById(R.id.nama);
            holder.tanggalView = (TextView) convertView.findViewById(R.id.tanggal);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(R.drawable.udimo);
        holder.namaView.setText(listData.get(position).getNama());
        holder.tanggalView.setText(listData.get(position).getTanggal());
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView namaView;
        TextView tanggalView;
    }
}
