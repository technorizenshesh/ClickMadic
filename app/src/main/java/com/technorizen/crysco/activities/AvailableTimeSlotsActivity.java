package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.technorizen.crysco.Adapters.AdapterAvaility;
import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.Model.ModelAvabilityResult;
import com.technorizen.crysco.onlinedoctors.activities.BookingPaymentActivity;
import com.technorizen.crysco.pojos.ModelAvaility;
import com.technorizen.crysco.ModelDoctorDetails;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityAvailableTimeSlotsBinding;
import com.technorizen.crysco.onlinedoctors.activities.BookTestPacakgesOnlineActivity;
import com.utils.Session.SessionManager;
import com.utils.Utils.Tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class AvailableTimeSlotsActivity extends AppCompatActivity {

    Context mContext = AvailableTimeSlotsActivity.this;
    ActivityAvailableTimeSlotsBinding binding;
    private ModelDoctorDetails details;
    private List<ModelAvaility> arrayList=new ArrayList<>();
    private AdapterAvaility adapter;
    HashMap<String,String>Main_param=new HashMap<>();
    private int nextDayCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_available_time_slots);
        init();
    }

    private void init() {
        if (getIntent().getExtras() != null) {
            details = (ModelDoctorDetails) getIntent().getExtras().getSerializable("data");
            Log.e("doctor_id",details.getId());
            binding.setDoctor(details);
            binding.executePendingBindings();
            Main_param.put("user_id", SessionManager.get(this).getUserID());
            Main_param.put("doctor_id",details.getId());
        }
        adapter = new AdapterAvaility(this, arrayList).Callback(time->{
            Main_param.put("time",time.getTime());
        });
        binding.recycleView.setAdapter(adapter);
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.btNext.setOnClickListener(v -> {
            if (Main_param.get("time")!=null){
                startActivity(new Intent(mContext, BookingPaymentActivity.class).putExtra("param", Main_param));
            }
        });
        binding.btNextDay.setOnClickListener(v->{
            nextDayCount++;
            HashMap<String, String> param = new HashMap<>();
            Main_param.put("date",Tools.getNext("yyyy-MM-dd",nextDayCount));
            param.put("doctor_id", details.getId());
            param.put("date", Tools.getNext("yyyy-MM-dd",nextDayCount));
            param.put("day", Tools.getNext(Tools.Type.DAY,nextDayCount).toLowerCase());
            binding.tvDate.setText(Tools.getNext(Tools.Type.DATE,nextDayCount));
            getSlotTime(param);
        });
        HashMap<String, String> param = new HashMap<>();
        param.put("doctor_id", details.getId());
        param.put("date", Tools.getCurrent("yyyy-MM-dd"));
        param.put("day", Tools.getCurrent(Tools.Type.DAY).toLowerCase());
        binding.tvDate.setText(Tools.getCurrent(Tools.Type.DATE));
        Main_param.put("date",Tools.getCurrent("yyyy-MM-dd"));
        getSlotTime(param);
    }

    private void getSlotTime( HashMap<String, String> param) {
        ApiCallBuilder.build(this).setUrl(BaseClass.get().getUserSlot())
                .setParam(param)
                .isShowProgressBar(true)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        arrayList.clear();
                        Log.e("Response",""+response);
                        try {
                            JSONObject object=new JSONObject(response);
//                        Log.e("Response",""+result.getTimeSlote().toString());
                            if (object.getString("status").equals("1")){
                                binding.tvNoRecord.setVisibility(View.GONE);
                                Type listType = new TypeToken<ModelAvabilityResult>() {}.getType();
                                ModelAvabilityResult result = new GsonBuilder().create().fromJson(object.getString("result"), listType);
                                for (String time:result.getTimeSlote()){
                                    arrayList.add(new ModelAvaility(time));
                                }
                                Log.e("arrayList",""+arrayList.size());
                                adapter.notifyDataSetChanged();
                            }else {
                                binding.tvNoRecord.setText("No Slot available for "+Tools.getNext(Tools.Type.DAY,nextDayCount)+","+Tools.getNext(Tools.Type.DATE,nextDayCount));
                                binding.tvNoRecord.setVisibility(View.VISIBLE);
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
