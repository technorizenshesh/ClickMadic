package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.ModelDoctorDetails;
import com.technorizen.crysco.Model.ModelNearBy;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityDoctorBookingBinding;
import com.technorizen.crysco.onlinedoctors.activities.BookTestPacakgesOnlineActivity;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class DoctorProfileActivity extends AppCompatActivity {
    Context mContext = DoctorProfileActivity.this;
    ActivityDoctorBookingBinding binding;
    String whichtype = "nearby";
    private ModelNearBy data;
    private  ModelDoctorDetails DoctorData;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_doctor_booking);

        if (getIntent().getExtras()!=null){
             data=(ModelNearBy)getIntent().getExtras().getSerializable("data");
        }
        init();
    }

    private void init() {
        session= SessionManager.get(this);
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });
        binding.btRequest.setOnClickListener(v -> {
            if(whichtype.equalsIgnoreCase("online_doctor")) {
                startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class));
            } else if(whichtype.equalsIgnoreCase("nearby")) {
                startActivity(new Intent(mContext, AvailableTimeSlotsActivity.class).putExtra("data",DoctorData));
            }
        });
        binding.imgFavorite.setOnClickListener(v->{
            AddFavorite();
        });
        getDoctorDetails();
    }

    private void AddFavorite() {
        HashMap<String,String>param=new HashMap<>();
        param.put("user_id",session.getUserID());
        param.put("doctor_id",DoctorData.getId());
        ApiCallBuilder.build(this).setUrl(BaseClass.get().addFavDoctor())
                .setParam(param)
                .isShowProgressBar(true)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        Log.e("Response",response);
                        try {
                            JSONObject object=new JSONObject(response);
                            if (object.getString("result").equals("insert favorite successfull")){
                                binding.imgFavorite.setImageResource(R.drawable.ic_favorite);
                            }else {
                                binding.imgFavorite.setImageResource(R.drawable.ic_favorite_border);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void Failed(String error) {

                    }
                });
    }

    private void getDoctorDetails() {
        HashMap<String,String>param=new HashMap<>();
        param.put("user_id", data.getId());
        ApiCallBuilder.build(this).setUrl(BaseClass.get().getProfile())
                .setParam(param).isShowProgressBar(true)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        Log.e("DoctorDetails","====>"+response);
                        try {
                            JSONObject object=new JSONObject(response);
                            boolean status=object.getString("status").contains("1");
                            if (status){
                                JSONObject jsonarray = object.getJSONObject("result");
                                Type listType = new TypeToken<ModelDoctorDetails>(){}.getType();
                                DoctorData = new GsonBuilder().create().fromJson(jsonarray.toString(), listType);
                                binding.setDoctor(DoctorData);
                                binding.executePendingBindings();
                            }
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
