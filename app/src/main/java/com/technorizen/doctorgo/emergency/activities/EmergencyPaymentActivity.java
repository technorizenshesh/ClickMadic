package com.technorizen.doctorgo.emergency.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityEmergencyPaymentBinding;

public class EmergencyPaymentActivity extends AppCompatActivity {

    Context mContext = EmergencyPaymentActivity.this;
    ActivityEmergencyPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_emergency_payment);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

    }


}

