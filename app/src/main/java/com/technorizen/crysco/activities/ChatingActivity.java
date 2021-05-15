package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.technorizen.crysco.Adapters.AdapterChat;
import com.technorizen.crysco.Adapters.AdapterHistory;
import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityChatingBinding;
import com.technorizen.crysco.pojos.ModelChat;
import com.technorizen.crysco.pojos.ModelRequest;
import com.technorizen.crysco.pojos.UserDetails;
import com.utils.Session.SessionManager;
import com.utils.Utils.Tools;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class ChatingActivity extends AppCompatActivity {
    ActivityChatingBinding binding;
    private UserDetails data;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_chating);
        data=(UserDetails)getIntent().getSerializableExtra("data");
        binding.setUser(data);
        if (!data.getImage().isEmpty()){
            Picasso.get().load(data.getImage()).placeholder(R.drawable.profile).into(binding.profileImg);
        }
        init();
        getChat();
        binding.imgSent.setOnClickListener(v->{
            if (binding.etMessage.getText().toString().isEmpty()){
                binding.etMessage.setError("Required");
                binding.etMessage.requestFocus();
                return;
            }
            insertChat();
        });
    }
    private void getChat(){
        HashMap<String,String>param=new HashMap<>();
        param.put("sender_id",data.getId());
        param.put("receiver_id",session.getUserID());
        ApiCallBuilder.build(this)
                .setUrl(BaseClass.get().get_chat())
                .setParam(param)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            if (object.getString("status").equals("1")){
                                binding.tvNoRecord.setVisibility(View.GONE);
                                Type listType = new TypeToken<ArrayList<ModelChat>>() {}.getType();
                                ArrayList<ModelChat> result = new GsonBuilder().create().fromJson(object.getString("result"), listType);
                                Collections.reverse(result);
                                binding.recycleView.setAdapter(new AdapterChat(ChatingActivity.this,result));
                            }else {
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
    private void insertChat(){
        binding.imgSent.setVisibility(View.GONE);
        binding.progrss.setVisibility(View.VISIBLE);
        HashMap<String,String>param=new HashMap<>();
        param.put("receiver_id",data.getId());
        param.put("sender_id",session.getUserID());
        param.put("chat_message",binding.etMessage.getText().toString());
        ApiCallBuilder.build(this)
                .setUrl(BaseClass.get().insert_chat())
                .setParam(param)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        Log.e("insert",response);
                        binding.imgSent.setVisibility(View.VISIBLE);
                        binding.progrss.setVisibility(View.GONE);
                        try {
                            JSONObject object=new JSONObject(response);
                            if (object.getString("result").equals("successful")){
                                binding.etMessage.setText("");
                                getChat();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void Failed(String error) {
                        binding.imgSent.setVisibility(View.VISIBLE);
                        binding.progrss.setVisibility(View.GONE);
                    }
                });
    }
    private void init() {
        session= SessionManager.get(this);
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });
    }
}
