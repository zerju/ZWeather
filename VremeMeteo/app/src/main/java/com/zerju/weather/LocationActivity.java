package com.zerju.weather;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.zerju.weather.fragments.AddLocationFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class LocationActivity extends AppCompatActivity {

    @Bind(R.id.listView)
    ListView lw;
    View rootView;
    ArrayAdapter<Object>publicAdapter;
    RealmResults<Location> result1;
    boolean edit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Location");
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this, this.findViewById(android.R.id.content).getRootView());
        rootView = this.findViewById(android.R.id.content).getRootView();
        Realm realm = Realm.getInstance(getApplicationContext());
        RealmQuery<Location> query = realm.where(Location.class);
        query.findAll();
        result1 = query.findAll();
        final ArrayAdapter<Object> adapter = new LocationAdapter(LocationActivity.this,result1,false);
        adapter.addAll(result1);
        publicAdapter = adapter;
        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Realm realm = Realm.getInstance(getApplicationContext());
                RealmQuery<Location> query = realm.where(Location.class);
                query.equalTo("selected", true);
                RealmResults<Location> result1 = query.findAll();
                realm.beginTransaction();
                TextView locationText = (TextView)view.findViewById(R.id.savedLocationText);
                String location = locationText.getText().toString();
                RealmQuery<Location> query2 = realm.where(Location.class);
                query2.equalTo("name", location);
                RealmResults<Location> result2 = query2.findAll();
                for (int i = 0; i<result1.size(); i++) {
                    Log.e("I IN POSITION", "POSITION:" + position + " I:" + i);
                        result1.get(i).setSelected(false);
                }
                for (int i = 0; i<result2.size(); i++) {
                        result2.get(i).setSelected(true);
                }
                realm.commitTransaction();
                adapter.notifyDataSetChanged();
                
                /*Intent i = new Intent(LocationActivity.this, LocationActivity.class);
// set the new task and clear flags
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);*/


            }
        });


    }

    @OnClick({R.id.addBtn, R.id.editBtn,R.id.editLocBtn})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addBtn:
                AddLocationFragment fragment = new AddLocationFragment();
                fragment.show(getFragmentManager(),"hopsasa");
                break;
            case R.id.editBtn:
                if(result1.size()>0) {
                    startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                } else {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setMessage("You have to set atleast one location!");
                    alertDialogBuilder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                break;
            case R.id.editLocBtn:
                ArrayAdapter<Object> adapter;
                if(!edit) {
                    adapter = new LocationAdapter(LocationActivity.this, result1, true);
                    edit = true;
                }else{
                    adapter = new LocationAdapter(LocationActivity.this, result1, false);
                    edit = false;
                }
                adapter.addAll(result1);
                publicAdapter = adapter;
                lw.setAdapter(adapter);
                break;
        }
    }

    private void updateView(int index,boolean visible){
        View v = lw.getChildAt(index -
                lw.getFirstVisiblePosition());

        if(v == null)
            return;

        TextView someText = (TextView) v.findViewById(R.id.selectedText);
        if(visible){
            someText.setVisibility(View.VISIBLE);
        }else {
            someText.setVisibility(View.INVISIBLE);
        }

    }
    public ArrayAdapter<Object> getAdapter(){
        return publicAdapter;
    }
    public void setPublicAdapter(ArrayAdapter<Object> adapter){
        publicAdapter = adapter;
    }
    public void restartActivity(){
        Intent i = new Intent(LocationActivity.this, LocationActivity.class);
// set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(i);
    }
    public void setResult1(RealmResults<Location> a){
        result1 = a;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }}
