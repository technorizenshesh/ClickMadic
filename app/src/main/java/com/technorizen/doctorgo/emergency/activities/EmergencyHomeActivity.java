package com.technorizen.doctorgo.emergency.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityEmergencyHomeBinding;

public class EmergencyHomeActivity extends AppCompatActivity {

    Context mContext = EmergencyHomeActivity.this;
    ActivityEmergencyHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_emergency_home);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.ivCall1.setOnClickListener(v -> {
            startActivity(new Intent(mContext,EmergencyPaymentActivity.class));
        });

        binding.ivCall2.setOnClickListener(v -> {
            startActivity(new Intent(mContext,EmergencyPaymentActivity.class));
        });

        binding.ivCall3.setOnClickListener(v -> {
            startActivity(new Intent(mContext,EmergencyPaymentActivity.class));
        });

    }


}
