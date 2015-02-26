package com.latihan.hadi.testscreening;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.latihan.hadi.testscreening.model.modelNama;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends ActionBarActivity {
    TextView hi;
    //modelNama mNama = new modelNama();

    @ViewById
    EditText main_edittext;

    @ViewById
    Button main_next;


    private static final String PREFS = "prefs";
    private static final String PREF_NAME = "name";
    private static final String PREF_EVENT = "event";
    private static final String PREF_GUEST = "guest";
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor e;
    public String name;
    public String nama;

    @Click(R.id.main_next)
    void NextScreen(){

      //  mNama.setNamaUser(nama);

        mSharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        name = mSharedPreferences.getString(PREF_NAME, "");
        nama = main_edittext.getText().toString();


        //String nama1 = mNama.getNamaUser();

        e = mSharedPreferences.edit();
        e.putString(PREF_NAME, nama);
        e.putString(PREF_EVENT, null);
        e.putString(PREF_GUEST, null);
        e.commit();

        Toast.makeText(getApplicationContext(), "Hi " + nama + "!", Toast.LENGTH_LONG).show();
        Intent menuIntent = new Intent(this, menu_.class);
        menuIntent.putExtra("nama", nama);
        startActivity(menuIntent);
    }

}
