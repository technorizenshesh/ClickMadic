package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityGetStartedBinding;

public class GetStartedActivity extends AppCompatActivity {

    Context mContext = GetStartedActivity.this;
    ActivityGetStartedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_get_started);

        init();

    }

    private void init() {

        binding.cvMobile.setOnClickListener(v -> {
            startActivity(new Intent(mContext,EnterMobileActivity.class));
        });

        binding.tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(mContext,LoginActivity.class));
        });

    }


}
