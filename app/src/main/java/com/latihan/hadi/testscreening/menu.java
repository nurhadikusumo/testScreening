package com.latihan.hadi.testscreening;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.latihan.hadi.testscreening.model.modelNama;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

/**
 * Created by SONY on 2/25/2015.
 */
@EActivity(R.layout.menu)
@OptionsMenu(R.menu.menu_main)
public class menu extends ActionBarActivity {
//    modelNama mNama = new modelNama();


    private static final String PREFS = "prefs";
    private static final String PREF_NAME = "name";
    private static final String PREF_EVENT = "event";
    private static final String PREF_GUEST = "guest";
    SharedPreferences mSharedPreferences;
    public String name;

    @ViewById
    TextView hi;

    @ViewById
    Button btn_event;

    @ViewById
    Button btn_guess;

    @AfterViews
    void menuTampil(){
        super.onStart();

     mSharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
       name = mSharedPreferences.getString(PREF_NAME, "");
       String nama_event = mSharedPreferences.getString(PREF_EVENT, "");
       String nama_guest = mSharedPreferences.getString(PREF_GUEST, "");

       if (name.length() > 0) {
            hi.setText("Hi " + name + "!");
        }



            //String nama = this.getIntent().getExtras().getString("nama");
        //String nama = mNama.getNamaUser();
       // hi.setText("Hi " + nama + "!");

        //String nama_event = this.getIntent().getExtras().getString("nama_event");
        if (nama_event.length() > 0){
            btn_event.setText(nama_event);
        }

        //String nama_guest = this.getIntent().getExtras().getString("name_guest");
        if (nama_guest.length() > 0){
            btn_guess.setText(nama_guest);
        }
    }

    @Click(R.id.btn_event)
    void eventNext(){
        Intent eventIntent = new Intent(this, event.class);
        startActivity(eventIntent);
    }

    @Click(R.id.btn_guess)
    void guessNext(){
        Intent guessIntent = new Intent(this, guest_.class);
        startActivity(guessIntent);
    }
}
