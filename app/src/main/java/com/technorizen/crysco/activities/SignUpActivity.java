package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivitySignUpBinding;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class SignUpActivity extends AppCompatActivity {

    Context mContext = SignUpActivity.this;
    ActivitySignUpBinding binding;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        init();

    }

    private void init() {
        session= SessionManager.get(SignUpActivity.this);
        binding.rlSignUp.setOnClickListener(v -> {
            if (Validation()){
                Continue();
            }
        });

        binding.tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(mContext,LoginActivity.class));
        });
    }
    private HashMap<String,String> getParam(){
        RadioButton button=(RadioButton)findViewById(binding.gender.getCheckedRadioButtonId());
        HashMap<String,String>param=new HashMap<>();
        param.put("user_id",session.getUserID());
        param.put("first_name",binding.name.getText().toString());
        param.put("email",binding.email.getText().toString());
        param.put("password",binding.password.getText().toString());
        param.put("height",binding.height.getText().toString());
        param.put("age",binding.age.getText().toString());
        param.put("gender",button.getText().toString());
        return param;
    }
    private void Continue() {
        ApiCallBuilder.build(this).setUrl(BaseClass.get().updateProfile())
                .isShowProgressBar(true)
                .setParam(getParam()).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    boolean status=object.getString("status").contains("1");
                    if (status){
                        session.setUserLogin(true);
                       session.CreateSession(object.getString("result"));
                        startActivity(new Intent(mContext,HomeActivity.class));
                        finish();
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

    private boolean Validation(){
        if (binding.name.getText().toString().isEmpty()){
            binding.name.setError(getString(R.string.required));
            binding.name.requestFocus();
            return false;
        }if (binding.email.getText().toString().isEmpty()){
            binding.email.setError(getString(R.string.required));
            binding.email.requestFocus();
            return false;
        }
        if (binding.password.getText().toString().isEmpty()){
            binding.password.setError(getString(R.string.required));
            binding.password.requestFocus();
            return false;
        }if (binding.height.getText().toString().isEmpty()){
            binding.height.setError(getString(R.string.required));
            binding.height.requestFocus();
            return false;
        }if (binding.age.getText().toString().isEmpty()){
            binding.age.setError(getString(R.string.required));
            binding.age.requestFocus();
            return false;
        }
        return true;
    }

}
