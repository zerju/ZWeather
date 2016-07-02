package com.zerju.weather.fragments;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;


import com.zerju.weather.Location;
import com.zerju.weather.LocationActivity;
import com.zerju.weather.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import co.geeksters.googleplaceautocomplete.lib.CustomAutoCompleteTextView;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddLocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddLocationFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View rootView;
    public AddLocationFragment() {
        // Required empty public constructor
    }

        public static AddLocationFragment newInstance(String param1, String param2) {
        AddLocationFragment fragment = new AddLocationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_add_location, container, false);
        ButterKnife.bind(this, rootView);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return rootView;
    }

    @OnClick({R.id.addAutoBtn, R.id.cancelAutoBtn})
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addAutoBtn:
                Realm realm = Realm.getInstance(getActivity());
                RealmQuery<Location> query = realm.where(Location.class);
                query.equalTo("selected",true);
                RealmResults<Location> result1 = query.findAll();
                realm.beginTransaction();
                for (int i = 0; i<result1.size(); i++) {
                    result1.get(i).setSelected(false);
                }

                CustomAutoCompleteTextView customAutoCompleteTextView = (CustomAutoCompleteTextView)rootView.findViewById(R.id.atv_places);

                if(customAutoCompleteTextView != null) {
                    String country = customAutoCompleteTextView.googlePlace.getCountry(); //Return the country name
                    String city = customAutoCompleteTextView.googlePlace.getCity(); //Return the city
                    String name = customAutoCompleteTextView.googlePlace.getDescription(); //Return the description (city + region + country)
                    Location locationObj = new Location();
                    locationObj.setSelected(true);
                    locationObj.setName(city + ", " + country);
                    locationObj.setCity(city);
                    locationObj.setCountry(country);
                    realm.copyToRealm(locationObj);
                    realm.commitTransaction();
                    ArrayAdapter<Object> adapter = ((LocationActivity) getActivity()).getAdapter();
                    adapter.notifyDataSetChanged();
                    ((LocationActivity) getActivity()).restartActivity();
                    dismiss();
                }
                break;
            case R.id.cancelAutoBtn:
                dismiss();
                break;
        }
    }

}
