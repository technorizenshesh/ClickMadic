package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.R;
import com.technorizen.crysco.Services.GPSTracker;
import com.technorizen.crysco.databinding.ActivityLoginBinding;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class LoginActivity extends AppCompatActivity {
    Context mContext = LoginActivity.this;
    ActivityLoginBinding binding;
    private SessionManager session;
    private GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        init();
    }

    private void init() {
        session=SessionManager.get(this);
        gps=new GPSTracker(this);
        binding.tvSignUp.setOnClickListener(v -> {
            startActivity(new Intent(mContext,SignUpActivity.class));
        });
        binding.rlLogin.setOnClickListener(v -> {
            if (Validation()){
                Continue();
            }
        });
        binding.tvForgotPass.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ForgotPassActivity.class));
        });
    }
    private HashMap<String,String>getParam(){
        HashMap<String,String>param=new HashMap<>();
        param.put("email",binding.email.getText().toString());
        param.put("password",binding.password.getText().toString());
        param.put("register_id","rrr");
        param.put("lat",""+gps.getLatitude());
        param.put("lon",""+gps.getLongitude());
        return param;
    }
    private void Continue() {
        ApiCallBuilder.build(this).setUrl(BaseClass.get().Login())
                .isShowProgressBar(true)
                .setParam(getParam()).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                Log.e("Response","====>"+response);
                try {
                    JSONObject object=new JSONObject(response);
                    boolean status=object.getString("status").contains("1");
                    if (status){
                        session.CreateSession(object.getString("result"));
                        session.setUserLogin(true);
                        startActivity(new Intent(mContext,HomeActivity.class));
                        finish();
                    }else {
                        Toast.makeText(mContext, ""+object.getString("result"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void Failed(String error) {
                Log.e("Response","====>"+error);
            }
        });
    }

    private boolean Validation(){
        if (binding.email.getText().toString().isEmpty()){
            binding.email.setError(getString(R.string.required));
            binding.email.requestFocus();
            return false;
        }
        if (binding.password.getText().toString().isEmpty()){
            binding.password.setError(getString(R.string.required));
            binding.password.requestFocus();
            return false;
        }
        return true;
    }


}
