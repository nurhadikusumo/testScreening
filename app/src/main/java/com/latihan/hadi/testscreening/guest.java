package com.latihan.hadi.testscreening;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.latihan.hadi.testscreening.Connection.ApiConnection;
import com.latihan.hadi.testscreening.Interface.RestInterface;
import com.latihan.hadi.testscreening.adapter.gridListAdapter;
import com.latihan.hadi.testscreening.model.guestApi;

import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by SONY on 2/25/2015.
 */
@EActivity
public class guest extends ActionBarActivity {
    private static final String PREFS = "prefs";
    private static final String PREF_GUEST = "guest";
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor e;

    //public static final int FRAME_ID = 1;
    ArrayList<guestApi> stringGrid = new ArrayList<>();
    gridListAdapter adapter;
    //ListTitleFragment listTitleFragment;
    //PopupWindow popupWindow;

    //@ViewById
    //FrameLayout imageViewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest);

        GridView grid_guest = (GridView) findViewById(R.id.grid_guest);

        getTracksData();

        adapter = new gridListAdapter(this,R.layout.row_grid,stringGrid);
        grid_guest.setAdapter(adapter);

        grid_guest.setClickable(true);
        grid_guest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                guestApi guest = stringGrid.get(position);
                Intent MenuAct = new Intent(view.getContext(),menu_.class);

                mSharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
                e = mSharedPreferences.edit();
                e.putString(PREF_GUEST, guest.name);
                e.commit();

                //MenuAct.putExtra("name_guest",guest.name);

                int i = Integer.parseInt(guest.birthdate.substring(guest.birthdate.length()-2, guest.birthdate.length()));
                String tHitung = "";

                if((i%2==0) && (i%3==0)){
                       tHitung = "iOS";
                }else if(i%3==0){
                       tHitung = "Android";
                }else if(i%2==0){
                        tHitung = "BlackBerry";
                }

                Toast.makeText(getApplicationContext(), tHitung, Toast.LENGTH_LONG).show();
                startActivity(MenuAct);

            }
        });

        //updateScreen();
    }
    public void updateListData(ArrayList<guestApi> listGuest){
        //textTitle.setText("Soundcloud Simple App");
        //ImageSoundView view = new ImageSoundView_();
        for (int i = 0 ; i < listGuest.size() ; i++){
            //adapter.add(content);
//            Toast.makeText(getApplicationContext(),"ini date" + listGuest.get(i).birthdate, Toast.LENGTH_LONG).show();

            stringGrid.add(new guestApi(listGuest.get(i).name,listGuest.get(i).birthdate));
            // stringList.add(listGuest.get(i).date);
        }
        adapter.notifyDataSetChanged();
    }

    public void getTracksData(){
        RestAdapter adapter = ApiConnection.getRestAdapter(this);
        RestInterface restInterface = adapter.create(RestInterface.class);
        restInterface.getTracks(new Callback<List<guestApi>>() {
            @Override
            public void success(List<guestApi> trackses, Response response) {
                if (trackses.isEmpty()){
                    Log.i("Error ", "tracks is empty");
                }
                ArrayList<guestApi> listGuest = new ArrayList<guestApi>();
                int i = 0;
                for (guestApi tracks : trackses){
                    listGuest.add(tracks);
                    //Log.i("name", listGuest.get(i).name);
                   // Log.i("date", listGuest.get(i).date);
                    i++;
                }
                updateListData(listGuest);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Response error ","Response error - "+error.getResponse());
            }
        });

    }
}
