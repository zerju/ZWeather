package com.zerju.weather;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by System32 on 6. 03. 2016.
 */
public class LocationAdapter extends ArrayAdapter<Object> {

    Context c;
    LayoutInflater inflater;
    List<Location> location;
    @Bind(R.id.savedLocationText)
    TextView savedLocation;
    @Bind(R.id.selectedText)
    TextView selectedText;
    @Bind(R.id.deleteBtn)
    Button deleteBtn;
    boolean edit;

    public LocationAdapter(Context context,List<Location> location,boolean editable){
        super(context,R.layout.list_of_places);
        this.c = context;
        edit = editable;
        this.location = location;
    }

    @Override
    public View getView(final int position,View convertView, ViewGroup parent){

        View locationView = convertView;
        if (locationView == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            locationView = inflater.inflate(R.layout.list_of_places, parent,false);
            //convertView = favoriteView;
        }
        ButterKnife.bind(this, locationView);
        savedLocation.setTextColor(c.getResources().getColor(R.color.black));
        selectedText.setTextColor(c.getResources().getColor(R.color.black));

            savedLocation.setText(location.get(position).getName());
            final String city = location.get(position).getCity();
            final String country = location.get(position).getCountry();


            Button deleteBtn = (Button) locationView.findViewById(R.id.deleteBtn);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(c,R.style.AppCompatAlertDialogStyle);
                    alertDialogBuilder.setMessage("Do you really want to delete this?");
                    alertDialogBuilder.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Realm realm = Realm.getInstance(getContext());
                                    RealmQuery<Location> query = realm.where(Location.class);
                                    query.beginGroup()
                                            .equalTo("city", city)
                                            .equalTo("country", country)
                                            .endGroup();
                                    RealmResults<Location> result1 = query.findAll();
                                    realm.beginTransaction();
                                    List<Location> locationList = new ArrayList<Location>(location);

                   /* for (int i = 0; i < result1.size(); i++) {
                        Location loc = result1.get(i);
                        int index = locationList.indexOf(loc);
                        location.remove(result1.get(i));
                    }*/

                                    while (result1.size() > 0) {
                                        result1.removeLast();
                                    }

                                    realm.commitTransaction();

                                    refresh();
                                }
                            });
                    alertDialogBuilder.setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {

                                }

                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    alertDialog.show();



                }
            });

            if (location.get(position).isSelected()) {
                selectedText.setVisibility(View.VISIBLE);
            } else {
                selectedText.setVisibility(View.INVISIBLE);
            }

            if (edit) {
                deleteBtn.setVisibility(View.VISIBLE);
            } else {
                deleteBtn.setVisibility(View.GONE);
            }

        return locationView;
    }

    public void refresh(){
        Intent i = new Intent(getContext(),LocationActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(i);
        //this.notifyDataSetChanged();
    }
    @OnClick({R.id.deleteBtn})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.deleteBtn:

                break;
        }

    }

}
