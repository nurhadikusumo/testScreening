package com.latihan.hadi.testscreening;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.latihan.hadi.testscreening.adapter.eventListAdapter;
import com.latihan.hadi.testscreening.model.modelEvent;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import java.util.ArrayList;

/**
 * Created by SONY on 2/25/2015.
 */
public class event extends ActionBarActivity{
    private static final String PREFS = "prefs";
    private static final String PREF_EVENT = "event";
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor e;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

        ArrayList image_details = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.main_listview);
        lv1.setAdapter(new eventListAdapter(this, image_details));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                modelEvent newsData = (modelEvent) o;
                Toast.makeText(event.this, "Selected :" + " " + newsData.getNama(), Toast.LENGTH_LONG).show();

                mSharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
                e = mSharedPreferences.edit();
                e.putString(PREF_EVENT, newsData.getNama());
                e.commit();

                Intent eventIntent = new Intent(v.getContext(), menu_.class);
                //eventIntent.putExtra("nama_event", newsData.getNama());
                startActivity(eventIntent);
            }
        });
    }

    private ArrayList getListData() {
        ArrayList<modelEvent> results = new ArrayList<modelEvent>();
        modelEvent eventData = new modelEvent();
        eventData.setNama("Dance of Democracy");
        eventData.setTanggal("2/12/2016");
        results.add(eventData);

        modelEvent eventData1 = new modelEvent();
        eventData1.setNama("Dance of Society");
        eventData1.setTanggal("3/22/2017");
        results.add(eventData1);

        modelEvent eventData2 = new modelEvent();
        eventData2.setNama("Dance of Population");
        eventData2.setTanggal("4/21/2018");
        results.add(eventData2);

        modelEvent eventData3 = new modelEvent();
        eventData3.setNama("Dance of Crazy");
        eventData3.setTanggal("5/23/2019");
        results.add(eventData3);

        return results;
    }
}
