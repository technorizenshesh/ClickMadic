package com.technorizen.crysco.labathome.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.technorizen.crysco.Adapters.AdapterHistory;
import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityAppointmentLabBinding;
import com.technorizen.crysco.pojos.ModelRequest;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class AppointmentHistory extends AppCompatActivity {

    Context mContext = AppointmentHistory.this;
    ActivityAppointmentLabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_appointment_lab);
        init();
    }

    private void init() {
        binding.ivBack.setOnClickListener(v -> {
           onBackPressed();
        });
        binding.swipeRefresh.setOnRefreshListener(this::getBooking);
        getBooking();
    }

    private void getBooking() {
        binding.swipeRefresh.setRefreshing(true);
        HashMap<String,String>paam=new HashMap<>();
        paam.put("user_id", SessionManager.get(this).getUserID());
        ApiCallBuilder.build(this).setUrl(BaseClass.get().get_booking())
                .setParam(paam).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                binding.swipeRefresh.setRefreshing(false);
                try {
                    JSONObject object=new JSONObject(response);
                    if (object.getString("status").equals("1")){
                        binding.tvNoRecord.setVisibility(View.GONE);
                        Type listType = new TypeToken<ArrayList<ModelRequest>>() {}.getType();
                        ArrayList<ModelRequest> result = new GsonBuilder().create().fromJson(object.getString("result"), listType);
                      binding.recycleView.setAdapter(new AdapterHistory(mContext,result));
                    }else {
                        binding.tvNoRecord.setVisibility(View.VISIBLE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void Failed(String error) {
                binding.swipeRefresh.setRefreshing(false);
            }
        });
    }


}
