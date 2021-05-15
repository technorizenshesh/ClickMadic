package com.technorizen.crysco.fragments;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.technorizen.crysco.Adapters.AdapterDoctor;
import com.technorizen.crysco.Adapters.AdapterHealth;
import com.technorizen.crysco.Adapters.AdapterNearbyClinic;
import com.technorizen.crysco.Adapters.AdapterNearbyDoctor;
import com.technorizen.crysco.Adapters.AdapterOffers;
import com.technorizen.crysco.Adapters.AdapterSearchDoctor;
import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.Enums.NearByType;
import com.technorizen.crysco.Model.ModelHealth;
import com.technorizen.crysco.Model.ModelNearBy;
import com.technorizen.crysco.R;
import com.technorizen.crysco.Services.GPSTracker;
import com.technorizen.crysco.activities.DoctorProfileActivity;
import com.technorizen.crysco.clinics.activities.LoadClinicActivity;
import com.technorizen.crysco.databinding.FragmentHomeBinding;
import com.technorizen.crysco.emergency.activities.EmergencyHomeActivity;
import com.technorizen.crysco.onlinedoctors.activities.MoreDoctorsActivity;
import com.technorizen.crysco.onlinedoctors.activities.OnlineDoctorHomeActivity;
import com.utils.Session.SessionKey;
import com.utils.Session.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    Context mContext;
    private ArrayList<ModelNearBy> DoctorList = new ArrayList<>();
    private ArrayList<ModelNearBy> DoctorSearchList = new ArrayList<>();
    private ArrayList<ModelNearBy> ClinicList = new ArrayList<>();
    private ArrayList<ModelHealth> HealthList = new ArrayList<>();
    private ArrayList<ModelHealth> OfferList = new ArrayList<>();
    private AdapterNearbyDoctor docAdapter;
    private AdapterNearbyClinic clinicAdapter;
    private AdapterHealth healthAdapter;
    private AdapterOffers offerAdapter;
    private SessionManager session;
    private GPSTracker gps;
    private FusedLocationProviderClient fusedLocationClient;
    private Location location;
    private AdapterSearchDoctor docSearchAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        session = SessionManager.get(getContext());
        gps = new GPSTracker(getContext());
        docAdapter=new AdapterNearbyDoctor(getContext(),DoctorList).Callback(this::onSelectDoctor);
        docSearchAdapter=new AdapterSearchDoctor(getContext(),DoctorSearchList).Callback(this::onSelectDoctor);
        clinicAdapter=new AdapterNearbyClinic(getContext(),ClinicList).Callback(this::onSelectClinic);
        healthAdapter=new AdapterHealth(getContext(),HealthList).Callback(this::onSelectHealth);
        offerAdapter=new AdapterOffers(getContext(),OfferList).Callback(this::onSelectHealth);
        binding.nearByDoctor.setAdapter(docAdapter);
        binding.nearByClinic.setAdapter(clinicAdapter);
        binding.healthTips.setAdapter(healthAdapter);
        binding.offerList.setAdapter(offerAdapter);
        binding.searchDoctor.setAdapter(docSearchAdapter);
        Log.e("UserDetails",session.getAllDetails());


        binding.tvMoreNearby.setOnClickListener(v -> {
            startActivity(new Intent(mContext, MoreDoctorsActivity.class)
            .putExtra("which_type","nearby")
            );
        });

        binding.tvMoreClinic.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadClinicActivity.class));
        });

        binding.rlPharmacy.setOnClickListener(v -> {
            FragmentNearBy.get().setType(NearByType.pharmacy).show(getChildFragmentManager(),"");
        });
        gps.Listener(loc->{
            location=loc;
            Log.e("Lat",""+loc.getLatitude());
            getNearByDoctor();
        });
        getNearByDoctor();
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String txt=binding.etSearch.getText().toString();
                if (txt.length()==0){
                    DoctorSearchList.clear();
                    docSearchAdapter.notifyDataSetChanged();
                }else if (txt.length()%2==0){
                    getSearchDoctor(txt);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void onSelectHealth(ModelNearBy nearBy) {

    }

    private void onSelectClinic(ModelNearBy nearBy) {
        Intent intent=new Intent(mContext, LoadClinicActivity.class);
        intent.putExtra("which_type","clinicprofile");
        intent.putExtra("data",nearBy);
        startActivity(intent);
    }

    private void onSelectDoctor(ModelNearBy nearBy) {
        Intent intent=new Intent(mContext, DoctorProfileActivity.class);
        intent.putExtra("which_type","nearby");
        intent.putExtra("data",nearBy);
        startActivity(intent);
    }

    private void getNearByDoctor() {
        HashMap<String,String>param=new HashMap<>();
        param.put("lat",""+gps.getLatitude());
        param.put("lon",""+gps.getLongitude());
        param.put("type", NearByType.doctor.name());
        ApiCallBuilder.build(getContext()).setUrl(BaseClass.get().NearBy())
                .isShowProgressBar(false).setParam(param)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        Log.e("NearByDoctor","===>"+response);
                        try {
                            JSONObject object=new JSONObject(response);
                            boolean status=object.getString("status").contains("1");
                            DoctorList.clear();
                            if (status){
                                JSONArray array=object.getJSONArray("result");
                                for (int i=0;i<array.length();i++){
                                    JSONObject jsonObject=array.getJSONObject(i);
                                    ModelNearBy near=new ModelNearBy();
                                    near.setId(jsonObject.getString("id"));
                                    near.setFirst_name(jsonObject.getString("first_name"));
                                    near.setImage(jsonObject.getString("image"));
                                    near.setDistance(jsonObject.getString("distance"));
                                    DoctorList.add(near);
                                }
                            }
                            docAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        getHealth();
                    }

                    @Override
                    public void Failed(String error) {
                        getNearClinic();
                    }
                });
    }

    private void getSearchDoctor(String qry) {
        binding.searchProgress.setVisibility(View.VISIBLE);
        HashMap<String,String>param=new HashMap<>();
        param.put("search", qry);
        ApiCallBuilder.build(getContext()).setUrl(BaseClass.get().search_doctor())
                .setParam(param)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        binding.searchProgress.setVisibility(View.GONE);
                        Log.e("SearchDoctor","===>"+response);
                        try {
                            JSONObject object=new JSONObject(response);
                            boolean status=object.getString("status").contains("1");
                            DoctorSearchList.clear();
                            if (status){
                                JSONArray array=object.getJSONArray("result");
                                for (int i=0;i<array.length();i++){
                                    JSONObject jsonObject=array.getJSONObject(i);
                                    ModelNearBy near=new ModelNearBy();
                                    near.setId(jsonObject.getString("id"));
                                    near.setFirst_name(jsonObject.getString("first_name"));
                                    near.setImage(jsonObject.getString("image"));
                                    near.setDistance("0km");
                                    DoctorSearchList.add(near);
                                }
                            }
                            docSearchAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void Failed(String error) {
                        binding.searchProgress.setVisibility(View.GONE);
                    }
                });
    }
    private void getNearClinic() {
        HashMap<String,String>param=new HashMap<>();
        param.put("lat",""+gps.getLatitude());
        param.put("lon",""+gps.getLongitude());
        param.put("type","Clinic");
        ApiCallBuilder.build(getContext()).setUrl(BaseClass.get().NearBy())
                .isShowProgressBar(true).setParam(param)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            boolean status=object.getString("status").contains("1");
                            ClinicList.clear();
                            if (status){
                                JSONArray array=object.getJSONArray("result");
                                for (int i=0;i<array.length();i++){
                                    JSONObject jsonObject=array.getJSONObject(i);
                                    ModelNearBy near=new ModelNearBy();
                                    near.setId(jsonObject.getString("id"));
                                    near.setFirst_name(jsonObject.getString("first_name"));
                                    near.setImage(jsonObject.getString("image"));
                                    near.setDistance(jsonObject.getString("distance"));
                                    ClinicList.add(near);
                                }
                            }
                            clinicAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        getHealth();

                    }

                    @Override
                    public void Failed(String error) {
                        getHealth();
                    }
                });
    }
    private void getHealth() {
        ApiCallBuilder.build(getContext()).setUrl(BaseClass.get().getHealthTips())
                .isShowProgressBar(true)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            boolean status=object.getString("status").contains("1");
                            HealthList.clear();
                            if (status){
                                JSONArray array=object.getJSONArray("result");
                                for (int i=0;i<array.length();i++){
                                    JSONObject jsonObject=array.getJSONObject(i);
                                    ModelHealth near=new ModelHealth();
                                    near.setId(jsonObject.getString("id"));
                                    near.setTitle(jsonObject.getString("title"));
                                    near.setImage(jsonObject.getString("image"));
                                    near.setDescription(jsonObject.getString("description"));
                                    HealthList.add(near);
                                }
                            }
                            healthAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                        getOffers();
                    }

                    @Override
                    public void Failed(String error) {
                        getOffers();
                    }
                });
    }
    private void getOffers() {
        ApiCallBuilder.build(getContext()).setUrl(BaseClass.get().getOffers())
                .isShowProgressBar(true)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            boolean status=object.getString("status").contains("1");
                            OfferList.clear();
                            if (status){
                                JSONArray array=object.getJSONArray("result");
                                for (int i=0;i<array.length();i++){
                                    JSONObject jsonObject=array.getJSONObject(i);
                                    ModelHealth near=new ModelHealth();
                                    near.setId(jsonObject.getString("id"));
                                    near.setTitle(jsonObject.getString("offer_name"));
                                    near.setImage(jsonObject.getString("image_path"));
                                    near.setDescription(jsonObject.getString("offer_description"));
                                    OfferList.add(near);
                                }
                            }
                            offerAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void Failed(String error) {

                    }
                });
    }


}
