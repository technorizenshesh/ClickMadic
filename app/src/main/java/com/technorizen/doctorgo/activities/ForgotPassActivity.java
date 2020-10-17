package com.technorizen.doctorgo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityForgotPassBinding;

public class ForgotPassActivity extends AppCompatActivity {

    Context mContext = ForgotPassActivity.this;
    ActivityForgotPassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_forgot_pass);

        init();

    }

    private void init() {
        binding.rlSubmit.setOnClickListener(v -> {
            finish();
        });
    }


}
